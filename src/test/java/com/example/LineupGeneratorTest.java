package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LineupGeneratorTest {

    @Test
    void testLineupGeneratorWithTwoShortstops() {
        // Get the roster and expected lineups from the stub
        List<Player> roster = LineupStub.getRosterWithExtraShortstop();
        List<Map<Position, Object>> expectedLineups = LineupStub.getExpectedLineupsWithTwoSS();

        // Initialize the LineupGenerator
        LineupGenerator generator = new LineupGenerator(roster);

        // Run the generator
        generator.run();

        // Retrieve the generated lineups
        List<Map<Position, Object>> actualLineups = generator.getGeneratedLineups();

        // Verify that the number of lineups matches
        assertEquals(expectedLineups.size(), actualLineups.size(), "The number of generated lineups should match the expected lineups.");

        // Verify that each expected lineup is present in the generated lineups
        for (Map<Position, Object> expectedLineup : expectedLineups) {
            boolean found = actualLineups.stream().anyMatch(actualLineup -> {
                // Compare all non-outfield positions
                for (Position pos : Position.values()) {
                    if (pos != Position.OUTFIELD) {
                        if (!Objects.equals(expectedLineup.get(pos), actualLineup.get(pos))) {
                            return false;
                        }
                    }
                }
                // Compare outfield as a set
                Set<Player> expectedOutfield = (Set<Player>) expectedLineup.get(Position.OUTFIELD);
                Set<Player> actualOutfield = (Set<Player>) actualLineup.get(Position.OUTFIELD);
                return expectedOutfield.equals(actualOutfield);
            });
            assertTrue(found, "Expected lineup is missing: " + expectedLineup);
        }
    }

    @Test
    void testLineupGeneratorWithExtraOutfielder() {;
        // Get the roster and expected lineups from the stub
        List<Player> roster = LineupStub.getRosterWithExtraOutfielder();
        List<Map<Position, Object>> expectedLineups = LineupStub.getExpectedLineupsWithExtraOF();

        // Initialize the LineupGenerator
        LineupGenerator generator = new LineupGenerator(roster);

        // Run the generator
        generator.run();

        // Retrieve the generated lineups
        List<Map<Position, Object>> actualLineups = generator.getGeneratedLineups();

        // Verify that the number of lineups matches
        assertEquals(expectedLineups.size(), actualLineups.size(), "The number of generated lineups should match the expected lineups.");

        // Verify that each expected lineup is present in the generated lineups
        for (Map<Position, Object> expectedLineup : expectedLineups) {
            boolean found = actualLineups.stream().anyMatch(actualLineup -> {
                // Compare all non-outfield positions
                for (Position pos : Position.values()) {
                    if (pos != Position.OUTFIELD) {
                        if (!Objects.equals(expectedLineup.get(pos), actualLineup.get(pos))) {
                            return false;
                        }
                    }
                }
                // Compare outfield as a set
                Set<Player> expectedOutfield = (Set<Player>) expectedLineup.get(Position.OUTFIELD);
                Set<Player> actualOutfield = (Set<Player>) actualLineup.get(Position.OUTFIELD);
                return expectedOutfield.equals(actualOutfield);
            });
            assertTrue(found, "Expected lineup is missing: " + expectedLineup);
        }
    }
}