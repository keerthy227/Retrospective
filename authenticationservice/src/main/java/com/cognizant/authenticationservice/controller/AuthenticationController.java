package com.cognizant.authenticationservice.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.entity.User;
import com.cognizant.authenticationservice.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {
	

	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	@Autowired
	UserRepository UserRepository;
	
	@GetMapping("/authenticate") 
	public Map<String,String> authenticate(@RequestHeader("Authorization") String authHeader){
		LOGGER.info("start authentication");
		LOGGER.info(authHeader);
		Map<String,String> authmap= new HashMap<String,String>();
		authmap.put("token",generateJwt(getUser(authHeader)));

		String username =  getUser(authHeader);
        authmap.put("username", username);
		Long id = UserRepository.findIdByUserName(username);

       authmap.put("id",String.valueOf(id));

        LOGGER.info("END OF AUTH FUNCTION");

		return authmap;
	}
	private String getUser(String authHeader){
		String user=new String(Base64.getDecoder().decode(authHeader.substring(6)));
		user= user.substring(0, user.indexOf(":"));
		LOGGER.info(user);
		return user;
	}
	private String generateJwt(String user){
		JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);

        builder.setIssuedAt(new Date());

        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();
        LOGGER.info(token);
        return token;
	}

}
