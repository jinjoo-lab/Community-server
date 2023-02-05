package com.barbel.communityserver.domain.match.controller;

import com.barbel.communityserver.domain.match.dto.MatchDto;
import com.barbel.communityserver.domain.match.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService)
    {
        this.matchService = matchService;
    }

    @GetMapping
    public List<MatchDto> start()
    {
        List<MatchDto> list = matchService.findAll();

        return list;
    }

    @GetMapping("/get/{id}")
    public MatchDto matchGet(@PathVariable long id)
    {
        return matchService.getMatch(id);
    }

    @PostMapping("/save")
    public void matchSave(MatchDto matchDto)
    {
        matchService.saveMatch(matchDto);
    }

    @GetMapping("/delete/{id}")
    public void matchDelete(@PathVariable long id)
    {
        matchService.deleteMatch(id);
    }


}
