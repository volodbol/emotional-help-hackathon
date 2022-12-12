package com.epam.hackathon.emotional.help.controller;

import com.epam.hackathon.emotional.help.dto.AdviceDto;
import com.epam.hackathon.emotional.help.mapper.AdviceMapper;
import com.epam.hackathon.emotional.help.service.AdviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("advice")
@RequiredArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;

    @GetMapping("/{feeling}")
    public AdviceDto getByFeeling(@PathVariable String feeling) {
        return AdviceMapper.toDto(
                adviceService.getByFeeling(feeling)
                        .orElseThrow(() -> new NotFoundException("This " + feeling + " not found")));
    }

}
