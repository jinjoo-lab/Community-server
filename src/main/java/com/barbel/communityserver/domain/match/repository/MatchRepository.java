package com.barbel.communityserver.domain.match.repository;

import com.barbel.communityserver.domain.match.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MatchRepository extends MongoRepository<Match,Long> {

    @Override
    Optional<Match> findById(Long aLong);
}
