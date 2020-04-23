package com.cognizant.authenticationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ses_id")
    public long id;

    @Column(name="role")
    public String role;

    @Column(name="session_id")
    public String sessionId;

    @Column(name="session_name")
    public String sessionName;

    @Column(name="user_id")
    public long userId;

    @JsonIgnore
    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Notes> notes;

    @ManyToOne
    @JoinColumn(name = "session_template_id",referencedColumnName="id")
    public Template template;

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", sessionName='" + sessionName + '\'' +
                ", userId=" + userId +
                ", template=" + template +
                '}';
    }
}
