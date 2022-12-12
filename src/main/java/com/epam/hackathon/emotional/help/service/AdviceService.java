package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.Advice;
import com.epam.hackathon.emotional.help.model.AnswerGroup;
import com.epam.hackathon.emotional.help.repository.AdviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdviceService {

    private final AdviceRepository adviceRepository;

    public Optional<Advice> getByFeeling(String feeling) {
        return adviceRepository.findAdviceByAnswerGroup(AnswerGroup.valueOf(feeling));
    }
}
