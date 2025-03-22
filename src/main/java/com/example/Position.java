package com.example;

/**
 * Enum representing standard defensive baseball positions.
 */
public enum Position {
    CATCHER("C"),
    FIRST_BASE("1B"),
    SECOND_BASE("2B"),
    THIRD_BASE("3B"),
    SHORTSTOP("SS"),
    RIGHT_FIELD("RF"),
    CENTER_FIELD("CF"),
    LEFT_FIELD("LF"),
    DESIGNATED_HITTER("DH"), 
    OUTFIELD("OF");

    private final String abbreviation;

    /**
     * Constructor for the Position enum.
     *
     * @param abbreviation The abbreviation for the position.
     */
    Position(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Gets the abbreviation for the position.
     *
     * @return The abbreviation.
     */
    public String getAbbreviation() {
        return abbreviation;
    }
}