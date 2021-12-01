package fr.lernejo.guessgame;

import java.io.InputStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private String name;
    private int score;
    private int maxScore;
    private long nbGuess;

    public HumanPlayer(String name) {
        this.name = name;
        this.score = 0;
        //this.maxScore = maxScore; //TODO: set maxScore on game creation
        this.nbGuess = 0;
    }

    public long getNbGuess() {
        return nbGuess;
    }

    public void playerGuessNumber(InputStream in) {
        Scanner scanner = new Scanner(in);
        System.out.println("What is your guess ?");
        try {
            this.nbGuess = scanner.nextLong();
        }
        catch (Exception e) {
            this.nbGuess = 0;
            System.out.println("Please enter a number");
            // throw  new IllegalArgumentException("Invalid number");
        }

    }

    @Override
    public void respond(boolean lowerOrGreater) {

    }


    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void addGuess() {
        this.nbGuess++;
    }

    public void resetScore() {
        this.score = 0;
    }

    public void resetGuess() {
        this.nbGuess = 0;
    }

    public boolean isWinner() {
        return this.score == this.maxScore;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.score + " / " + this.maxScore + " (" + this.nbGuess + ")";
    }
}
