package com.example;

import java.util.List;
import java.util.Objects;

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

    // Override equals to compare players by their attributes
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check for reference equality
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null or different class

        Player other = (Player) obj; // Cast to Player
        return playerId == other.playerId && // Compare playerId
               Objects.equals(name, other.name) && // Compare name
               Objects.equals(positions, other.positions); // Compare positions
    }

    // Override hashCode to generate a hash based on player attributes
    @Override
    public int hashCode() {
        return Objects.hash(playerId, name, positions); // Generate hash based on playerId, name, and positions
    }
}
