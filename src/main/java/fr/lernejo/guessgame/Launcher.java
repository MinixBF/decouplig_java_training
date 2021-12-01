package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {

        long randomNumber = getRandomNumber();
        HumanPlayer humanPlayer = new HumanPlayer("Sarah");
        Simulation game = new Simulation(humanPlayer);
        game.initialize(randomNumber);
        game.loopUntilPlayerSucceed();
    }

    public static long getRandomNumber() {
        SecureRandom random = new SecureRandom();
        return random.nextLong(100);
    }
}
