package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LineupGeneratorTest {

    @Test
    void testLineupGeneratorWithTwoShortstops() {
        // Create a roster stub with two players eligible at SS
        Player player1 = new Player(1, "Player 1", Arrays.asList(Position.SHORTSTOP, Position.DESIGNATED_HITTER));
        Player player2 = new Player(2, "Player 2", Arrays.asList(Position.SHORTSTOP, Position.DESIGNATED_HITTER));
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

        // Retrieve the generated lineups
        List<Map<Position, Player>> lineups = generator.getGeneratedLineups();

        // Verify that four different lineups are generated
        assertEquals(4, lineups.size(), "There should be exactly four lineups generated with the SS and DH exchanging.");

        // Verify that the lineups differ in the shortstop and DH positions
        for (int i = 0; i < lineups.size(); i++) {
            for (int j = i + 1; j < lineups.size(); j++) {
                Map<Position, Player> lineup1 = lineups.get(i);
                Map<Position, Player> lineup2 = lineups.get(j);

                // Ensure that either the SS or DH positions differ between the two lineups
                boolean shortstopDiffers = !lineup1.get(Position.SHORTSTOP).equals(lineup2.get(Position.SHORTSTOP));
                boolean dhDiffers = !lineup1.get(Position.DESIGNATED_HITTER).equals(lineup2.get(Position.DESIGNATED_HITTER));

                assertNotEquals(
                    lineup1.get(Position.SHORTSTOP),
                    lineup2.get(Position.SHORTSTOP),
                    "The shortstop position should differ between some lineups."
                );

                assertNotEquals(
                    lineup1.get(Position.DESIGNATED_HITTER),
                    lineup2.get(Position.DESIGNATED_HITTER),
                    "The DH position should differ between some lineups."
                );

                // Ensure all other positions remain the same
                for (Position position : Position.values()) {
                    if (position != Position.SHORTSTOP && position != Position.DESIGNATED_HITTER) {
                        assertEquals(
                            lineup1.get(position),
                            lineup2.get(position),
                            "The players at position " + position + " should be the same in both lineups."
                        );
                    }
                }
            }
        }
    }
}