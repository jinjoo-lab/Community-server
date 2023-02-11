package com.barbel.communityserver.domain.match.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;


@Getter
@ToString
@Document(collection = "match")
public class Match {
    @Id
    private String id;

    private long mentorId;
    private long menteeId;


    @Builder
    public Match(String id,long mentorId,long menteeId)
    {
        this.id = id;
        this.menteeId = menteeId;
        this.mentorId = mentorId;
    }

}
