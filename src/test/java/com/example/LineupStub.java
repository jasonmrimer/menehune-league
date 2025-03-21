package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LineupStub {

    public static List<Player> getRoster() {
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

        return Arrays.asList(
                player1, player2, catcher, firstBaseman, secondBaseman, thirdBaseman,
                outfielder1, outfielder2, outfielder3, dh
        );
    }

    public static List<Map<Position, Player>> getExpectedLineups() {
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

        return Arrays.asList(
            Map.of(
                Position.CATCHER, catcher,
                Position.FIRST_BASE, firstBaseman,
                Position.SECOND_BASE, secondBaseman,
                Position.THIRD_BASE, thirdBaseman,
                Position.SHORTSTOP, player1,
                Position.LEFT_FIELD, outfielder1,
                Position.CENTER_FIELD, outfielder2,
                Position.RIGHT_FIELD, outfielder3,
                Position.DESIGNATED_HITTER, player2
            ),
            Map.of(
                Position.CATCHER, catcher,
                Position.FIRST_BASE, firstBaseman,
                Position.SECOND_BASE, secondBaseman,
                Position.THIRD_BASE, thirdBaseman,
                Position.SHORTSTOP, player2,
                Position.LEFT_FIELD, outfielder1,
                Position.CENTER_FIELD, outfielder2,
                Position.RIGHT_FIELD, outfielder3,
                Position.DESIGNATED_HITTER, player1
            ),
            Map.of(
                Position.CATCHER, catcher,
                Position.FIRST_BASE, firstBaseman,
                Position.SECOND_BASE, secondBaseman,
                Position.THIRD_BASE, thirdBaseman,
                Position.SHORTSTOP, player1,
                Position.LEFT_FIELD, outfielder1,
                Position.CENTER_FIELD, outfielder2,
                Position.RIGHT_FIELD, outfielder3,
                Position.DESIGNATED_HITTER, dh
            ),
            Map.of(
                Position.CATCHER, catcher,
                Position.FIRST_BASE, firstBaseman,
                Position.SECOND_BASE, secondBaseman,
                Position.THIRD_BASE, thirdBaseman,
                Position.SHORTSTOP, player2,
                Position.LEFT_FIELD, outfielder1,
                Position.CENTER_FIELD, outfielder2,
                Position.RIGHT_FIELD, outfielder3,
                Position.DESIGNATED_HITTER, dh
            )
        );
    }
}