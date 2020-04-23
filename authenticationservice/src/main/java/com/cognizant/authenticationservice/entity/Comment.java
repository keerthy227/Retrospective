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
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    public long commentId;
    @Column(name = "comment")
    public String comment;
    @ManyToOne
    @JoinColumn(name = "comment_notes_id",referencedColumnName="notes_id")
    public Notes notes;
    @ManyToOne
    @JoinColumn(name = "comment_user_id",referencedColumnName="id")
    public User commentUser;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
