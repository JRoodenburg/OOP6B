package com.JRoodenburg;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> gamelist = new ArrayList<Game>();

    public Persoon(String naam, double budget) {
        this.naam = naam;
        this.budget = budget;
    }

    public boolean koop(Game g1) {
        if (this.budget > g1.huidigeWaarde()){
            if (gamelist.contains(g1)){ return false; }
            gamelist.add(g1);
            this.budget = this.budget - g1.huidigeWaarde();
            return true;
        }
        return false;
    }

    public boolean verkoop(Game g2, Persoon p2) {
        if (gamelist.contains(g2)){
            if (p2.gamelist.contains(g2)){ return  false;}
            if (p2.getBudget() > g2.huidigeWaarde()){
                this.gamelist.remove(g2);
                this.budget = this.budget + g2.huidigeWaarde();
                return p2.koop(g2);
            }
        }
        return false;
    }

    // 6B
    public Game zoekGameOpNaam(String naam){
        for (int i = 0; i < this.gamelist.size(); i++) {
            if (this.gamelist.get(i).getNaam() == naam){
                return this.gamelist.get(i);
            }
        }
        return null;
    }

    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> tekoop){
        tekoop.removeIf(game -> this.gamelist.contains(game));
        return tekoop;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public ArrayList<Game> getGamelist() {
        return gamelist;
    }

    //    add leerling objecten to single string through stringbuilder for propper output
    private String listGamesString() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < this.gamelist.size(); i++) {
            list.append("\n").append(gamelist.get(i));
        }
        return list.toString();
    }

    @Override
    public String toString() {
        return String.format("%s heeft een budget van €%.2f en bezit de volgende games:%s", this.naam, this.budget, listGamesString()).replaceAll("\\.",",");
        // Replace . to , because linux does this different than windows.
    }
}
