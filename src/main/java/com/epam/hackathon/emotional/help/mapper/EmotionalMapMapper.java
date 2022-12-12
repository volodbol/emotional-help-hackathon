package com.epam.hackathon.emotional.help.mapper;

import com.epam.hackathon.emotional.help.dto.DiagramValueDto;
import com.epam.hackathon.emotional.help.dto.EmotionalMapDto;
import com.epam.hackathon.emotional.help.model.EmotionalMap;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class EmotionalMapMapper {

    private static final int ONE_HUNDRED_PERCENT = 100;

    private static final int PERCENT_VALUE_SCALE = 2;

    public EmotionalMapDto toEmotionalMapDto(EmotionalMap emotionalMap) {
        List<DiagramValueDto> diagramValueDtos = List.of(
                new DiagramValueDto("Fear", emotionalMap.getFearValue().doubleValue()),
                new DiagramValueDto("Angry", emotionalMap.getAngryValue().doubleValue()),
                new DiagramValueDto("Sadness", emotionalMap.getSadnessValue().doubleValue()),
                new DiagramValueDto("Joy", emotionalMap.getJoyValue().doubleValue()),
                new DiagramValueDto("Surprise", emotionalMap.getSurpriseValue().doubleValue()),
                new DiagramValueDto("Happy", emotionalMap.getHappyValue().doubleValue())
        );
        BigDecimal oneValuePercent = getOneValuePercent(diagramValueDtos);
        diagramValueDtos.forEach(diagramValue ->
                diagramValue.setValue(convertToPercent(diagramValue.getValue(), oneValuePercent)));
        return EmotionalMapDto.builder()
                .diagramValues(diagramValueDtos)
                .createDate(emotionalMap.getCreateDate())
                .build();
    }

    private static BigDecimal getOneValuePercent(List<DiagramValueDto> diagramValueDtos) {
        return diagramValueDtos.stream()
                .map(DiagramValueDto::getValue)
                .reduce(Double::sum)
                .map(total -> BigDecimal.valueOf(ONE_HUNDRED_PERCENT / total))
                .orElse(BigDecimal.valueOf(1.0));
    }

    private static Double convertToPercent(Double aDouble, BigDecimal oneValuePercent) {
        return oneValuePercent
                .multiply(BigDecimal.valueOf(aDouble))
                .setScale(PERCENT_VALUE_SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

}
