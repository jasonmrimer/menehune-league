package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineupGeneratorTest {

    @Test
    void testLineupGeneratorWithTwoShortstops() {
        // Create a roster stub with two players eligible at SS
        Player player1 = new Player(1, "Player 1", Arrays.asList(Position.SHORTSTOP));
        Player player2 = new Player(2, "Player 2", Arrays.asList(Position.SHORTSTOP));
        Player catcher = new Player(3, "Catcher", Arrays.asList(Position.CATCHER));
        Player firstBaseman = new Player(4, "First Baseman", Arrays.asList(Position.FIRST_BASE));
        Player secondBaseman = new Player(5, "Second Baseman", Arrays.asList(Position.SECOND_BASE));
        Player thirdBaseman = new Player(6, "Third Baseman", Arrays.asList(Position.THIRD_BASE));
        Player outfielder1 = new Player(7, "Outfielder 1", Arrays.asList(Position.LEFT_FIELD));
        Player outfielder2 = new Player(8, "Outfielder 2", Arrays.asList(Position.CENTER_FIELD));
        Player outfielder3 = new Player(9, "Outfielder 3", Arrays.asList(Position.RIGHT_FIELD));
        Player dh = new Player(10, "DH", Arrays.asList(Position.DESIGNATED_HITTER));

        List<Player> roster = Arrays.asList(
                player1, player2, catcher, firstBaseman, secondBaseman, thirdBaseman,
                outfielder1, outfielder2, outfielder3, dh
        );

        // Initialize the LineupGenerator
        LineupGenerator generator = new LineupGenerator(roster);

        // Run the generator
        generator.run();

        // Verify that two different lineups are generated
        // (This assumes the generator stores or prints the lineups for verification)
        // For simplicity, you can add a method in LineupGenerator to return the generated lineups
        // and assert the size of the generated lineups list.
    }
}