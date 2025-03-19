package com.example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for LineupCreator.
 */
class LineupCreatorTest {

    @Test
    void testLineupCreation() {
        // Create a test roster
        Roster roster = RosterTestStub.createTestRoster();

        // Generate a lineup from the roster
        Lineup lineup = LineupCreator.createFromRoster(roster);

        // assert enough players in lineup
        assertEquals(9, lineup.playerCount());

        // Assert that there is one player per position
        Map<Position, String> positionAssignments = lineup.getPositionAssignments();
        assertEquals(Position.values().length, positionAssignments.size(), "Each position should have one player assigned.");

        // Assert that there are exactly 3 players assigned to the outfield
        long outfieldCount = positionAssignments.entrySet().stream()
                .filter(entry -> entry.getKey() == Position.OUTFIELD)
                .count();
        assertEquals(3, outfieldCount, "There should be exactly 3 players assigned to the outfield.");

        // Assert that each player is unique (no duplicates across positions)
        Set<String> uniquePlayers = new HashSet<>(positionAssignments.values());
        assertEquals(positionAssignments.size(), uniquePlayers.size(), "Each player should be assigned to only one position.");
    }
}
