package com.cognizant.authenticationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @Column(name = "user_name")
    public String userName;
    @Column(name="first_name")
    public String firstName;
    @Column(name="last_name")
    public String lastName;
    @Column(name = "password")
    public String password;
    @Column(name = "contactNumber")
    public String contact;
    @Column(name = "email")
    public String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public List<Notes> notes;

    @JsonIgnore
    @OneToMany(mappedBy = "commentUser", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public List<Comment> comments;



    @JsonIgnore
    @OneToMany(mappedBy = "actionUser", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public List<Action> actions;

    @JsonIgnore
    @OneToMany(mappedBy = "actionAssignedUser", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ActionAssigned> actionAssigned;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", notes=" + notes +
                ", comments=" + comments +
                ", actions=" + actions +
                ", actionAssigned=" + actionAssigned +
                '}';
    }
}
