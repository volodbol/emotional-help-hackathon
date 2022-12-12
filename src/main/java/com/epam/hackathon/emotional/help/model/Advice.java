package com.epam.hackathon.emotional.help.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "advice")
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tip",length = 2000, nullable = false)
    private String tip;
    @Column(name = "video", length = 50, nullable = false)
    private String video;

    @Enumerated(EnumType.STRING)
    private AnswerGroup answerGroup;
}
