package com.rugeles.prueba.repository;

import com.rugeles.prueba.models.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetServiceApi extends JpaRepository<Bet, Integer> {
    List<Bet> findByRouletteId(int id);
}
