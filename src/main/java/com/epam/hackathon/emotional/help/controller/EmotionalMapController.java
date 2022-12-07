package com.epam.hackathon.emotional.help.controller;

import com.epam.hackathon.emotional.help.dto.AnswersDto;
import com.epam.hackathon.emotional.help.dto.DiagramValueDto;
import com.epam.hackathon.emotional.help.exception.EmotionalMapNotFoundException;
import com.epam.hackathon.emotional.help.mapper.EmotionalMapMapper;
import com.epam.hackathon.emotional.help.model.EmotionalMap;
import com.epam.hackathon.emotional.help.service.EmotionalMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "emotional-maps")
@CrossOrigin
@RequiredArgsConstructor
public class EmotionalMapController {

    private final EmotionalMapService emotionalMapService;

    private final EmotionalMapMapper emotionalMapMapper;

    @GetMapping
    public List<DiagramValueDto> findEmotionalMap(@RequestParam(name = "userId") String userId) {
        EmotionalMap emotionalMap = emotionalMapService.findEmotionalMapById(userId)
                .orElseThrow(
                        () -> new EmotionalMapNotFoundException("Emotional map with user id - " + userId + " not found")
                );
        return emotionalMapMapper.toDiagramValueDtos(emotionalMap);
    }

    @PostMapping
    public List<DiagramValueDto> saveEmotionalMap(
            @RequestBody AnswersDto answersDto,
            @RequestParam(name = "userId") String userId) {
        EmotionalMap emotionalMap = emotionalMapService.findEmotionalMapById(userId)
                .map(map -> emotionalMapService.updateEmotionalMap(map, answersDto))
                .orElseGet(() -> emotionalMapService.saveEmotionalMap(answersDto, userId));
        return emotionalMapMapper.toDiagramValueDtos(emotionalMap);
    }

}
