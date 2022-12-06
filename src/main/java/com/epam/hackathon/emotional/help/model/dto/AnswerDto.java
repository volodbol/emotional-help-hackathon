package com.epam.hackathon.emotional.help.model.dto;

import com.epam.hackathon.emotional.help.model.AnswerGroup;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDto {

    private Integer mark;

    private AnswerGroup answerGroup;

}
