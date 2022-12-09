package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.Advice;
import com.epam.hackathon.emotional.help.model.AnswerGroup;
import com.epam.hackathon.emotional.help.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class AdviceService {
    @Autowired
    private AdviceRepository adviceRepository;

    public Advice getByFeeling(String feeling) {
        Optional<Advice> advice = Optional.ofNullable(
                adviceRepository.findAdviceByAnswerGroup(Enum.valueOf(AnswerGroup.class, feeling)));
        if (advice.isEmpty())
            throw new NotFoundException("This " + feeling + " not found");
        return advice.get();
    }
}
