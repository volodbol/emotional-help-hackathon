package com.epam.hackathon.emotional.help.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiagramValueDto {

    private String name;

    private Integer value;

}
