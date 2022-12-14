package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.dto.AnswerDto;
import com.epam.hackathon.emotional.help.dto.AnswersDto;
import com.epam.hackathon.emotional.help.model.AnswerGroup;
import com.epam.hackathon.emotional.help.model.EmotionalMap;
import com.epam.hackathon.emotional.help.repository.EmotionalMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmotionalMapService {

    private final EmotionalMapRepository emotionalMapRepository;

    private final ApplicationUserService applicationUserService;

    public EmotionalMap saveEmotionalMap(EmotionalMap emotionalMap) {
        return emotionalMapRepository.save(emotionalMap);
    }

    public EmotionalMap saveEmotionalMap(AnswersDto answersDto, String userId) {
        EmotionalMap emotionalMap = computeEmotionalMap(answersDto);
        try {
            Long id = Long.parseLong(userId);
            applicationUserService.findUserById(id)
                    .ifPresentOrElse(
                            emotionalMap::setApplicationUser,
                            () -> emotionalMap.setAnonymousUUID(userId)
                    );
        } catch (NumberFormatException e) {
            emotionalMap.setAnonymousUUID(userId);
        }
        return emotionalMapRepository.save(emotionalMap);
    }

    public EmotionalMap updateEmotionalMap(EmotionalMap emotionalMap, AnswersDto answersDto) {
        EmotionalMap computedEmotionalMap = computeEmotionalMap(answersDto);
        computedEmotionalMap.setId(emotionalMap.getId());
        computedEmotionalMap.setApplicationUser(emotionalMap.getApplicationUser());
        computedEmotionalMap.setAnonymousUUID(emotionalMap.getAnonymousUUID());
        computedEmotionalMap.setCreateDate(LocalDateTime.now());
        return emotionalMapRepository.save(computedEmotionalMap);
    }

    private static EmotionalMap computeEmotionalMap(AnswersDto answersDto) {
        return EmotionalMap.builder()
                .happyValue(sumAnswersMarksOf(answersDto, AnswerGroup.HAPPY))
                .angryValue(sumAnswersMarksOf(answersDto, AnswerGroup.ANGRY))
                .joyValue(sumAnswersMarksOf(answersDto, AnswerGroup.JOY))
                .sadnessValue(sumAnswersMarksOf(answersDto, AnswerGroup.SADNESS))
                .surpriseValue(sumAnswersMarksOf(answersDto, AnswerGroup.SURPRISE))
                .fearValue(sumAnswersMarksOf(answersDto, AnswerGroup.FEAR))
                .build();
    }

    public Optional<EmotionalMap> findEmotionalMapById(String id) {
        return findEmotionalMapByAnonymousUUID(id)
                .or(() -> findEmotionalMapByUserId(id));
    }

    private Optional<EmotionalMap> findEmotionalMapByAnonymousUUID(String id) {
        return emotionalMapRepository.findByAnonymousUUID(id);
    }

    private Optional<EmotionalMap> findEmotionalMapByUserId(String id) {
        try {
            Long userId = Long.parseLong(id);
            return applicationUserService
                    .findUserById(userId)
                    .flatMap(emotionalMapRepository::findByApplicationUser);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    private static Integer sumAnswersMarksOf(AnswersDto answersDto, AnswerGroup answerGroup) {
        return answersDto.getAnswers().stream()
                .filter(answerDto -> answerDto.getAnswerGroup() == answerGroup)
                .mapToInt(AnswerDto::getMark)
                .sum();
    }

}
