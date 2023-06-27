package com.example.opt3v10;

import java.util.ArrayList;
import java.util.List;

// Klasse StoelenData implementeert de Onderwerp interface
class StoelenData implements Onderwerp {
    public int beschikbareStoelen = 2;
    private List<Waarnemer> waarnemers = new ArrayList<>();

    public void setBeschikbareStoelen(int beschikbareStoelen) {
        this.beschikbareStoelen = beschikbareStoelen;
        informeerWaarnemers();
    }

    @Override
    public void registreerWaarnemer(Waarnemer waarnemer) {
        this.waarnemers.add(waarnemer);
    }

    @Override
    public void verwijderWaarnemer(Waarnemer waarnemer) {
        waarnemers.remove(waarnemer);
    }

    @Override
    public void informeerWaarnemers() {
        for (Waarnemer waarnemer : waarnemers) {
            waarnemer.update(beschikbareStoelen);
        }
    }

    public int getBeschikbareStoelen() {
        return beschikbareStoelen;
    }

}
