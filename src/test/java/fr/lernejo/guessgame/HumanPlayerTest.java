package fr.lernejo.guessgame;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

class HumanPlayerTest {

    @Test
    void playerGuessNumber() {
        HumanPlayer humanPlayer = new HumanPlayer("test");
        String initialString = "text";
        // InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        // assertTrue(assertThrows(IllegalArgumentException.class, () -> humanPlayer.playerGuessNumber(targetStream)).getMessage().contains("Invalid number"));
        // assertEquals(humanPlayer.playerGuessNumber(targetStream), "Please enter a number");
    }
}
