package com.epam.hackathon.emotional.help.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AnswersDto {

    private String userId;

    private List<AnswerDto> answerDtos;

}
