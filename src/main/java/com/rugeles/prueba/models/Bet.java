package com.rugeles.prueba.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bet")
public class Bet {
    private int id;
    private String bet;
    private int rouletteId;
    private Timestamp timestamp;

    public Bet() {
    }

    public Bet(int id, String bet, int rouletteId) {
        this.id = id;
        this.bet = bet;
        this.rouletteId = rouletteId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bet")
    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    @Basic
    @Column(name = "roulette_id")
    public int getRouletteId() {
        return rouletteId;
    }

    @Basic
    @Column(name = "time_stamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setRouletteId(int rouletteId) {
        this.rouletteId = rouletteId;
    }
}
