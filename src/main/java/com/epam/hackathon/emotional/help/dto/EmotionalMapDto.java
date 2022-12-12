package com.epam.hackathon.emotional.help.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmotionalMapDto {

    private List<DiagramValueDto> diagramValues;

    private LocalDateTime createDate;

}
