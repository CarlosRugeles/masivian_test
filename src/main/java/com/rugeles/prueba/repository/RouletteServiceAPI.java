package com.rugeles.prueba.repository;


import com.rugeles.prueba.models.Roulette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouletteServiceAPI extends JpaRepository<Roulette, Integer> {

    Roulette findById(int id);
}
