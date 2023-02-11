package com.barbel.communityserver.domain.match.repository;
import com.barbel.communityserver.domain.match.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends MongoRepository<Match,Long> {

    Optional<Match> findById(String id);

    Optional<Match> findByMentorIdAndMenteeId(long mentorId, long menteeId);
    @Override
    List<Match> findAll();

    void deleteById(String id);
}
