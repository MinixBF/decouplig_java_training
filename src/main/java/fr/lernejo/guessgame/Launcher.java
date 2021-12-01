package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Launcher.class, "GuessGame");
        System.out.println("Welcome to the Guess Capatain Age");
        switch (args.length) {
            case 0 -> logger.log("no arguments to launch the game, restart the program with arguments (-interactive or -auto and number)");
            case 1 -> {
                if (args[0].equals("-interactive")) {
                    HumanPlayer humanPlayer = new HumanPlayer("Sarah");
                    start(humanPlayer, Long.MAX_VALUE, 100L);
                }
                else {
                    logger.log("unknown argument, restart the program with arguments (-interactive or -auto and number)");
                }
            }
            case 2 -> {
                if (args[0].equals("-auto")) {
                    ComputerPlayer computerPlayer = new ComputerPlayer("Roger");
                    start(computerPlayer, 1000, null);
                }
                else {
                    logger.log("unknown argument, restart the program with arguments (-interactive or -auto and number)");
                }
            }
            default -> logger.log("invalid arguments to launch the game, restart the program with arguments (-interactive or -auto and number)");
        }
    }

    private static void start(Player player, long MaxLoopValue, Long bounds) {
        long randomNumber = getRandomNumber(bounds);
        Simulation game = new Simulation(player);
        game.initialize(randomNumber);
        game.loopUntilPlayerSucceed(MaxLoopValue);
    }

    private static long getRandomNumber(Long bounds) {
        SecureRandom random = new SecureRandom();
        return random.nextLong(0, bounds != null ? bounds : Long.MAX_VALUE);
    }
}
