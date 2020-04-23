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
@Table(name="Template")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @Column(name="template_name")
    public String templateName;
    @Column(name="no_of_columns")
    public long noOfColumns;
    @JsonIgnore
    @OneToMany(mappedBy = "template", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Session> sessionList;

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", templateName='" + templateName + '\'' +
                ", noOfColumns=" + noOfColumns +
                '}';
    }
}
