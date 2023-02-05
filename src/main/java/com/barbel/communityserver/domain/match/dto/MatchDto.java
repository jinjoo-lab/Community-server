package com.barbel.communityserver.domain.match.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MatchDto {
    public long mentorId;
    public long menteeId;
    public Date matchDate;

    public MatchDto(long mentorId,long menteeId,Date date)
    {
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.matchDate = date;
    }
}
