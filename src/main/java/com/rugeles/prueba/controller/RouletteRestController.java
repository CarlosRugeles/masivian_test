package com.rugeles.prueba.controller;

import com.rugeles.prueba.repository.RouletteServiceAPI;
import com.rugeles.prueba.models.Roulette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping(value = "/api/roulette/")
public class RouletteRestController {

    @Autowired
    private RouletteServiceAPI rouletteServiceAPI;

    @GetMapping(value = "/all")
    public List<Roulette> getAll(){
        return rouletteServiceAPI.findAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Roulette> save(@RequestBody Roulette rou){
        Roulette roulette=rouletteServiceAPI.save(rou);
        return new ResponseEntity<>(roulette, HttpStatus.OK);
    }
    /*@PostMapping(value = "/close/{id}")
    public ResponseEntity<Roulette> update(@PathVariable int id){
        Roulette roulette= rouletteServiceAPI.findById(id);
        if (roulette=!null){

        }
    }*/

}
