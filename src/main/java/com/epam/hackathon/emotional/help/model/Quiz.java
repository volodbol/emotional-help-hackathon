package com.epam.hackathon.emotional.help.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "quiz_answers_mapping",
            joinColumns = {@JoinColumn(name = "quiz_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "answers_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "question")
    private Map<String, Answers> questionAnswersMap;

}
