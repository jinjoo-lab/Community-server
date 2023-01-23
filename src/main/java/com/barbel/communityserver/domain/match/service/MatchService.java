package com.barbel.communityserver.domain.match.service;

import com.barbel.communityserver.domain.match.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private MatchRepository matchRepository;

    @Autowired
    MatchService(MatchRepository matchRepository)
    {
        this.matchRepository = matchRepository;
    }


}
