package com.barbel.communityserver.domain.match.dto;

import com.barbel.communityserver.domain.match.handler.DateHandler;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.Date;

@Data
public class MatchDto {
    public long mentorId;
    public long menteeId;

    public String matchDate;

    public MatchDto(long mentorId,long menteeId,String date)
    {
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.matchDate = date;
    }
}
