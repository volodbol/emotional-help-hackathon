package com.epam.hackathon.emotional.help.mapper;

import com.epam.hackathon.emotional.help.dto.DiagramValueDto;
import com.epam.hackathon.emotional.help.model.EmotionalMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmotionalMapMapper {

    public List<DiagramValueDto> toDiagramValueDtos(EmotionalMap emotionalMap) {
        return List.of(
                new DiagramValueDto("Fear", emotionalMap.getFearValue()),
                new DiagramValueDto("Angry", emotionalMap.getAngryValue()),
                new DiagramValueDto("Sadness", emotionalMap.getSadnessValue()),
                new DiagramValueDto("Joy", emotionalMap.getJoyValue()),
                new DiagramValueDto("Surprise", emotionalMap.getSurpriseValue()),
                new DiagramValueDto("Happy", emotionalMap.getHappyValue())
        );
    }


}
