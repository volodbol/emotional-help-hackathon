package com.epam.hackathon.emotional.help.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer_value")
    private String value;

    @Column(name = "mark")
    private Integer mark;

    @Enumerated(EnumType.ORDINAL)
    private AnswerGroup answerGroup;

}
