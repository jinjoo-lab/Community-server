package com.barbel.communityserver.domain.match.service;

import com.barbel.communityserver.domain.match.dto.MatchDto;
import com.barbel.communityserver.domain.match.entity.Match;
import com.barbel.communityserver.domain.match.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    MatchService(MatchRepository matchRepository)
    {
        this.matchRepository = matchRepository;
    }

    public List<MatchDto> findAll()
    {
        List<MatchDto> list = new ArrayList<>();

        matchRepository.findAll().forEach(
                x->list.add(convert(x)));

        return list;
    }

    public MatchDto getMatch(String id)
    {
        Optional<Match> match = matchRepository.findById(id);
        if(match.isPresent())
        {
            return convert(match.get());
        }
        else{
            throw new IllegalArgumentException("해당 id의 매칭 정보가 존재하지 않습니다 : "+ id);
        }
    }

    public void saveMatch(MatchDto matchDto)
    {
        Match match = Match.builder().mentorId(matchDto.mentorId)
                .menteeId(matchDto.menteeId).build();
        matchRepository.save(match);

    }

    public void deleteMatch(String id)
    {
        matchRepository.deleteById(id);
    }
    public MatchDto convert(Match match)
    {
        MatchDto dto = new MatchDto(match.getMentorId(), match.getMenteeId(),new Date());

        return dto;
    }
}
