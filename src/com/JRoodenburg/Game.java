package com.JRoodenburg;

import java.time.LocalDateTime;
import java.util.Objects;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    //  Een game daalt jaarlijks 30% in waarde.
    // 2 games zijn hetzelfde als de naam en het releaseJaar hetzelfde zijn.
    // Hij kan games kopen met methode koop(g), maar dat kan alleen als hij voldoende budget heeft en als hij die game nog niet bezit

    public Game(String naam, int releaseJaar, double nieuwprijs) {
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwprijs = nieuwprijs;
    }

    public double huidigeWaarde(){
        int currentYear = LocalDateTime.now().getYear();
        int age = currentYear - this.releaseJaar;
        double huidigewaarde = nieuwprijs;

        for (int i = 0; i < age; i++){
            huidigewaarde = huidigewaarde / 100 * 70;
        }
        return huidigewaarde;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getReleaseJaar() {
        return releaseJaar;
    }

    public void setReleaseJaar(int releaseJaar) {
        this.releaseJaar = releaseJaar;
    }

    public double getNieuwprijs() {
        return nieuwprijs;
    }

    public void setNieuwprijs(double nieuwprijs) {
        this.nieuwprijs = nieuwprijs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return releaseJaar == game.releaseJaar && naam.equals(game.naam); // shortened to just jaar & naam. "2 games zijn hetzelfde als de naam en het releaseJaar hetzelfde zijn"
    }

    @Override
    public String toString() {
        return String.format("%s, uitgegeven in %d; nieuwprijs: €%.2f nu voor: €%.2f", this.naam,this.releaseJaar, this.nieuwprijs, this.huidigeWaarde()).replaceAll("\\.",",");
        // Replace . to , because linux does this different than windows.
    }
}
