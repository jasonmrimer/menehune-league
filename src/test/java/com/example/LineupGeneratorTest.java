package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LineupGeneratorTest {

    @Test
    void testLineupGeneratorWithTwoShortstops() {
        // Get the roster and expected lineups from the stub
        List<Player> roster = LineupStub.getRoster();
        List<Map<Position, Player>> expectedLineups = LineupStub.getExpectedLineups();

        // Initialize the LineupGenerator
        LineupGenerator generator = new LineupGenerator(roster);

        // Run the generator
        generator.run();

        // Retrieve the generated lineups
        List<Map<Position, Player>> actualLineups = generator.getGeneratedLineups();

        // Verify that the number of lineups matches
        assertEquals(expectedLineups.size(), actualLineups.size(), "The number of generated lineups should match the expected lineups.");

        // Verify that each expected lineup is present in the generated lineups
        for (Map<Position, Player> expectedLineup : expectedLineups) {
            boolean found = actualLineups.stream()
                    .anyMatch(actualLineup -> actualLineup.equals(expectedLineup));
            assertTrue(found, "Expected lineup is missing: " + expectedLineup);
        }
    }
}