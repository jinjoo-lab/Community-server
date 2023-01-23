package com.barbel.communityserver.domain.match.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private long mentorId;

    @NotBlank
    private String mentorName;

    private long menteeId;

    @NotBlank
    private String menteeName;

    @NotBlank
    @Pattern(regexp = "(19|20)\\d{2}\\.((11|12)|(0?(\\d)))\\.(30|31|((0|1|2)?\\d))")
    private String matchDate;


    @Builder
    public Match(long mentorId,String mentorName,long menteeId,String menteeName,String matchDate)
    {
        this.menteeId = menteeId;
        this.mentorId = mentorId;
        this.mentorName = mentorName;
        this.menteeName = menteeName;
        this.matchDate = matchDate;
    }

}
