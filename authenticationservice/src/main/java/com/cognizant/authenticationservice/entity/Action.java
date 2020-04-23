package com.cognizant.authenticationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="action")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id")
    public long actionId;

    @Column(name = "action")
    public String action;

    @ManyToOne
    @JoinColumn(name = "action_user_id",referencedColumnName="id")
    public User actionUser;

    @ManyToOne
    @JoinColumn(name = "action_notes_id",referencedColumnName="notes_id")
    public Notes notes;

    @Override
    public String toString() {
        return "Action{" +
                "actionId=" + actionId +
                ", action='" + action + '\'' +
                '}';
    }
}
