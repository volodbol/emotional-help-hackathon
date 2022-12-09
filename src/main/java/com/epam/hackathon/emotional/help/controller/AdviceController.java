package com.epam.hackathon.emotional.help.controller;

import com.epam.hackathon.emotional.help.dto.AdviceDto;
import com.epam.hackathon.emotional.help.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("advice")
public class AdviceController {
    @Autowired
    private AdviceService adviceService;

    @GetMapping("/{feeling}")
    public AdviceDto getByFeeling(@PathVariable String feeling) {
        return adviceService.getByFeeling(feeling);
    }
}
