package com.barbel.communityserver.domain.match.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long mentorId;
    private long menteeId;

    private Date date;


    @Builder
    public Match(long mentorId,String mentorName,long menteeId,String menteeName,Date matchDate)
    {
        this.menteeId = menteeId;
        this.mentorId = mentorId;
        this.date = matchDate;
    }

}
