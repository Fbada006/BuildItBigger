package com.disruption.killerjokes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class KillerJokes {
    private final List<String> jokes = new ArrayList<>(
            Arrays.asList("Q: What goes up and down but does not move?\n" +
                            "A: Stairs",
                    "Q: Where should a 500 pound alien go?\n" +
                            "A: On a diet",
                    "Q: What did one toilet say to the other?\n" +
                            "A: You look a bit flushed.",
                    "Q: Why did the picture go to jail?\n" +
                            "A: Because it was framed.",
                    "Q: What did one wall say to the other wall?\n" +
                            "A: I'll meet you at the corner.",
                    "Q: What gets wetter the more it dries?\n" +
                            "A: A towel.",
                    "Q: What did the laundryman say to the impatient customer?\n" +
                            "A: Keep your shirt on!"));

    public String getRandomKillerJoke() {
        return jokes.get(new Random().nextInt(jokes.size()));
    }
}
