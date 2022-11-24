package com.epam.hackathon.emotional.help.service;

import com.epam.hackathon.emotional.help.model.EmotionalMap;
import com.epam.hackathon.emotional.help.repository.EmotionalMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmotionalMapService {

    private final EmotionalMapRepository emotionalMapRepository;

    public Optional<EmotionalMap> getEmotionalMap(String username) {
        return emotionalMapRepository.findByApplicationUser_Username(username);
    }

    public EmotionalMap addEmotionalMap(EmotionalMap emotionalMap) {
        return emotionalMapRepository.save(emotionalMap);
    }

    public boolean updateEmotionalMapByUsername(EmotionalMap emotionalMap) {
        String username = emotionalMap.getApplicationUser().getUsername();
        Optional<EmotionalMap> emotionalMapFromRepository = emotionalMapRepository.findByApplicationUser_Username(username);
        if (emotionalMapFromRepository.isEmpty()) {
            return false;
        }
        EmotionalMap emotionalMapToUpdate = emotionalMapFromRepository.get();
        emotionalMapToUpdate.setAngryValue(emotionalMap.getAngryValue());
        emotionalMapToUpdate.setFearValue(emotionalMap.getFearValue());
        emotionalMapToUpdate.setJoyValue(emotionalMap.getJoyValue());
        emotionalMapToUpdate.setSadnessValue(emotionalMap.getSadnessValue());
        emotionalMapToUpdate.setHappyValue(emotionalMap.getHappyValue());
        emotionalMapToUpdate.setSurpriseValue(emotionalMap.getSurpriseValue());
        emotionalMapRepository.save(emotionalMapToUpdate);
        return true;
    }

    public void deleteEmotionalMap(Long id) {
        emotionalMapRepository.deleteById(id);
    }


}
