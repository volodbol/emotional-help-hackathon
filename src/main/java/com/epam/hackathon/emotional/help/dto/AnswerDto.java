package com.epam.hackathon.emotional.help.dto;

import com.epam.hackathon.emotional.help.model.AnswerGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {

    private String value;

    private Integer mark;

    private AnswerGroup answerGroup;

}
