package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger();
    private final Player player;
    public long numberToGuess;
    private boolean isPlayerWin = false;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        this.player.playerGuessNumber();
        
        if (this.player.getNbGuess() == this.numberToGuess) {
            isPlayerWin = true;
            return true;
        }else{
            if(this.player.getNbGuess() > 0 ){
                this.player.respond(this.player.getNbGuess() > this.numberToGuess);
            }
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long maxLoopValue) {
        int nbTry = 0;
        long start = System.currentTimeMillis();
        while (!nextRound() && nbTry < maxLoopValue) {
            nbTry++;
        }
        String pattern = "mm:ss.SSS";
        String time = " Released in : " + new SimpleDateFormat(pattern).format(new Date(System.currentTimeMillis() - start));
        if(isPlayerWin){
            logger.log("Number " + this.numberToGuess + " is the right one, it took " + nbTry + " try" + time);
        }else {
            logger.log("Number to guess is : " + this.numberToGuess + time);
        }
    }

}
