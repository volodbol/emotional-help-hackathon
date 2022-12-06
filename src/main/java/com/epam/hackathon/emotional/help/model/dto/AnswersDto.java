package com.epam.hackathon.emotional.help.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AnswersDto {

    private List<AnswerDto> answerDtos;

}
