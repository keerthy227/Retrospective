package com.cognizant.authenticationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "action_assigned")
public class ActionAssigned {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @Column(name = "action_id")
    public long actionId;
    @ManyToOne
    @JoinColumn(name = "action_assigned_user_id", referencedColumnName = "id")
    public User actionAssignedUser;

    @Override
    public String toString() {
        return "ActionAssigned{" +
                "id=" + id +
                ", actionId=" + actionId +
                '}';
    }
}
