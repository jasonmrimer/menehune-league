package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LineupStub {

    // Static player fields
    public static final Player catcher = new Player(3, "Catcher", Arrays.asList(Position.CATCHER));
    public static final Player firstBaseman = new Player(4, "First Baseman", Arrays.asList(Position.FIRST_BASE));
    public static final Player secondBaseman = new Player(5, "Second Baseman", Arrays.asList(Position.SECOND_BASE));
    public static final Player thirdBaseman = new Player(6, "Third Baseman", Arrays.asList(Position.THIRD_BASE));
    public static final Player shortstop = new Player(1, "Shortstop 1",
            Arrays.asList(Position.SHORTSTOP, Position.DESIGNATED_HITTER));
    public static final Player shortstop2 = new Player(2, "Shortstop 2",
            Arrays.asList(Position.SHORTSTOP, Position.DESIGNATED_HITTER));
    public static final Player outfielder1 = new Player(7, "Outfielder 1", Arrays.asList(Position.LEFT_FIELD));
    public static final Player outfielder2 = new Player(8, "Outfielder 2", Arrays.asList(Position.CENTER_FIELD));
    public static final Player outfielder3 = new Player(9, "Outfielder 3", Arrays.asList(Position.RIGHT_FIELD));
    public static final Player outfielder4 = new Player(10, "Outfielder 4",
            Arrays.asList(Position.LEFT_FIELD, Position.CENTER_FIELD, Position.RIGHT_FIELD)); // Extra outfielder
    public static final Player dh = new Player(11, "DH", Arrays.asList(Position.DESIGNATED_HITTER));

    // Roster with default players
    public static List<Player> getRosterWithExtraShortstop() {
        return Arrays.asList(
                shortstop, shortstop2, catcher, firstBaseman, secondBaseman, thirdBaseman,
                outfielder1, outfielder2, outfielder3, dh);
    }

    // Roster with an extra outfielder
    public static List<Player> getRosterWithExtraOutfielder() {
        return Arrays.asList(
                shortstop, catcher, firstBaseman, secondBaseman, thirdBaseman,
                outfielder1, outfielder2, outfielder3, outfielder4, dh);
    }

    // Expected lineups for the default roster
    public static List<Map<Position, Object>> getExpectedLineupsWithTwoSS() {
        return Arrays.asList(
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder2, outfielder3),
                        Position.DESIGNATED_HITTER, shortstop2),
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop2,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder2, outfielder3),
                        Position.DESIGNATED_HITTER, shortstop),
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder2, outfielder3),
                        Position.DESIGNATED_HITTER, dh),
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop2,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder2, outfielder3),
                        Position.DESIGNATED_HITTER, dh));
    }

    // Expected lineups for the roster with an extra outfielder
    public static List<Map<Position, Object>> getExpectedLineupsWithExtraOF() {
        return Arrays.asList(
                // Original lineups with DH as a fixed player
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder2, outfielder3),
                        Position.DESIGNATED_HITTER, dh),
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder4, outfielder2, outfielder3),
                        Position.DESIGNATED_HITTER, dh),
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder2, outfielder4),
                        Position.DESIGNATED_HITTER, dh),
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder3, outfielder4),
                        Position.DESIGNATED_HITTER, dh),
                // Original lineups with DH as a fixed player
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder2, outfielder3),
                        Position.DESIGNATED_HITTER, outfielder4),
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder4, outfielder2, outfielder3),
                        Position.DESIGNATED_HITTER, outfielder1),
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder2, outfielder4),
                        Position.DESIGNATED_HITTER, outfielder3),
                Map.of(
                        Position.CATCHER, catcher,
                        Position.FIRST_BASE, firstBaseman,
                        Position.SECOND_BASE, secondBaseman,
                        Position.THIRD_BASE, thirdBaseman,
                        Position.SHORTSTOP, shortstop,
                        Position.OUTFIELD, Set.of(outfielder1, outfielder3, outfielder4),
                        Position.DESIGNATED_HITTER, outfielder2));
    }
}