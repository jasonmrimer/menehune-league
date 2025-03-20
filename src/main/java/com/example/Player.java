package com.example;

import java.util.List;

public class Player {
    int playerId;
    String name;
    List<Position> positions; // Use Position enum instead of String

    public Player(int playerId, String name, List<Position> positions) {
        this.playerId = playerId;
        this.name = name;
        this.positions = positions;
    }

    public boolean canPlayPosition(Position position) {
        if (position == Position.DESIGNATED_HITTER) {
            return true; // anyone can DH, but we'll handle DH-only separately
        }
        if (isOutfielder()) {
            return position == Position.LEFT_FIELD || position == Position.CENTER_FIELD || position == Position.RIGHT_FIELD;
        }
        return positions.contains(position);
    }

    public boolean isDhOnly() {
        return positions.size() == 1 && positions.contains(Position.DESIGNATED_HITTER);
    }

    public boolean isOutfielder() {
        return positions.contains(Position.LEFT_FIELD) || positions.contains(Position.CENTER_FIELD) || positions.contains(Position.RIGHT_FIELD);
    }

    @Override
    public String toString() {
        return name + " (" + playerId + ")";
    }
}
