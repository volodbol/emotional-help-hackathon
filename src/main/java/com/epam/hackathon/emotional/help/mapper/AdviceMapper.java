package com.epam.hackathon.emotional.help.mapper;

import com.epam.hackathon.emotional.help.dto.AdviceDto;
import com.epam.hackathon.emotional.help.model.Advice;

public class AdviceMapper {
    public static AdviceDto toDto(Advice advice){
        AdviceDto adviceDto = new AdviceDto();
        adviceDto.setId(advice.getId());
        adviceDto.setTip(advice.getTip());
        adviceDto.setFeeling(advice.getAnswerGroup().toString());
        adviceDto.setVideo(advice.getVideo());

        return adviceDto;
    }
}
