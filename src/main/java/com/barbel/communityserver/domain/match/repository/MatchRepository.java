package com.barbel.communityserver.domain.match.repository;

import com.barbel.communityserver.domain.match.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match,Long> {

    @Override
    Optional<Match> findById(Long aLong);

    @Override
    List<Match> findAll();
}
