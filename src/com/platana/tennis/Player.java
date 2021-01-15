package com.platana.tennis;

import java.util.Arrays;

public class Player {
    private int score;
    private String name;
    private int[] rounds = new int[6];
    private boolean hasAd;
    private int matchesWon;


    public Player(String name) {
        this.name = name;
    }

    public void addScore(int otherScore, boolean otherAd) {
        if (score == 40) {
            if(otherScore==40 || otherAd)
            {
                hasAd=true;
            }
            score += 15;
        } else if(score==30) {
            score += 10;
        } else {
            score+=15;
        }
    }
    public void wonMatch(){
        matchesWon++;
    }
    public boolean hasWonTheGame()
    {
        return matchesWon==3;
    }

    public void resetScore(int reset) {
        score = reset;
        hasAd=false;
    }
    public int getScore() {
        return score;
    }
    public String calculateScore(){
        return hasAd? "AD":String.valueOf (score);
    }
    public String getName() {
        return name;
    }
    public int[] getRounds() {
        return rounds;
    }
    public boolean isHasAd() {
        return hasAd;
    }
    @Override
    public String toString() {
        return name+"{" +
                "score=" + calculateScore() +
                ", rounds=" + Arrays.toString (rounds) +
                ", Set score=" + matchesWon +
                '}';
    }
}
