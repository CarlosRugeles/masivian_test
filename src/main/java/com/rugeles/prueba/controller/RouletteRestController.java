package com.rugeles.prueba.controller;

import com.rugeles.prueba.models.Bet;
import com.rugeles.prueba.repository.BetServiceApi;
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
    @Autowired
    private BetServiceApi betServiceApi;

    @GetMapping(value = "/all")
    public List<Roulette> getAll(){
        return rouletteServiceAPI.findAll();
    }

    @PostMapping(value = "/save/")
    public ResponseEntity<Roulette> save(@RequestBody Roulette rou){
        rou.setOpen(true);
        final Roulette roulette=rouletteServiceAPI.save(rou);
        return new ResponseEntity<>(roulette, HttpStatus.OK);
    }
    @PostMapping(value = "/close/{id}")
    public ResponseEntity<Roulette> update(@PathVariable int id){
        final Roulette roulette= rouletteServiceAPI.findById(id);
        if (roulette==null)return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        roulette.setOpen(false);
        rouletteServiceAPI.save(roulette);
        return new ResponseEntity<>(roulette, HttpStatus.OK);
    }

    @PostMapping(value ="/bet/{id}")
    public ResponseEntity<Bet> makeBet(@RequestBody Bet bet){
        Roulette roulette= rouletteServiceAPI.findById(bet.getRouletteId());
        if (roulette!=null && roulette.isOpen()){
            final Bet betResponse=betServiceApi.save(bet);
            return new ResponseEntity<>(betResponse,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
