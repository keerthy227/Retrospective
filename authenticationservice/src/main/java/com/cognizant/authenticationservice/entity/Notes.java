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
@Table(name="Notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notes_id")
    public long notesId;

    @Column(name = "notes")
    public String notes;

    @Column(name = "getNotes_id")
    public long getNotesId;

    @ManyToOne
    @JoinColumn(name = "sessions_id",referencedColumnName="ses_id")
    public Session session;

    @Column(name = "no_of_votes")
    public long votes;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName="id")
    public User user;

    @JsonIgnore
    @OneToMany(mappedBy = "notes", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public List<Comment> commentList;

    @JsonIgnore
    @OneToMany(mappedBy = "notes", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public List<Action> actionList;

    @Override
    public String toString() {
        return "Notes{" +
                "notesId=" + notesId +
                ", notes='" + notes + '\'' +
                ", getNotesId=" + getNotesId +
                ", session=" + session +
                ", votes=" + votes +
                ", commentList=" + commentList +
                ", actionList=" + actionList +
                '}';
    }
}
