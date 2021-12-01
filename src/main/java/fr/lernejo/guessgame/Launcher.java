package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Launcher.class, "GuessGame");
        System.out.println("Welcome to the Guess Capatain Age");
        switch (args.length) {
            case 0 -> logger.log(Error.NO_ARGS.toString());
            case 1 -> {
                if (args[0].equals("-interactive")) {
                    HumanPlayer humanPlayer = new HumanPlayer("Sarah");
                    start(humanPlayer, Long.MAX_VALUE, 100L);
                }
                else {
                    logger.log(Error.UNKNOWN_ARGS.toString());
                }
            }
            case 2 -> {
                if (args[0].equals("-auto")) {
                    ComputerPlayer computerPlayer = new ComputerPlayer("Roger");
                    start(computerPlayer, 1000, Long.parseLong(args[1]));
                }
                else {
                    logger.log(Error.UNKNOWN_ARGS.toString());
                }
            }
            default -> logger.log(Error.INVALID_ARGS.toString());
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
