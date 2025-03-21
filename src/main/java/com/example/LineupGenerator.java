package com.example;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class LineupGenerator {
    List<Player> players;
    List<Player> dhOnlyPlayers;
    List<Player> outfielders;
    List<Map<Position, Player>> generatedLineups;

    public LineupGenerator(List<Player> players) {
        this.players = players;
        generatedLineups = new ArrayList<>();
    
        // Populate DH-only players
        this.dhOnlyPlayers = extractOnlyDHPlayers(players);
    
        // Populate outfielders
        this.outfielders = extractOutfielders(players);
    }

    private List<Player> extractOutfielders(List<Player> players) {
        return this.outfielders = players.stream()
                .filter(p -> p.canPlayPosition(Position.LEFT_FIELD) ||
                             p.canPlayPosition(Position.CENTER_FIELD) ||
                             p.canPlayPosition(Position.RIGHT_FIELD))
                .collect(Collectors.toList());
    }

    private List<Player> extractOnlyDHPlayers(List<Player> players) {
        return this.dhOnlyPlayers = players.stream()
                .filter(Player::isDhOnly) // Only players who can exclusively DH
                .collect(Collectors.toList());
    }

    public void run() {
        List<Player> catchers = filterByPosition(Position.CATCHER);
        List<Player> firstBasemen = filterByPosition(Position.FIRST_BASE);
        List<Player> secondBasemen = filterByPosition(Position.SECOND_BASE);
        List<Player> thirdBasemen = filterByPosition(Position.THIRD_BASE);
        List<Player> shortstops = filterByPosition(Position.SHORTSTOP);

        // Loop through all eligible combinations for infield + catcher
        for (Player c : catchers) {
            for (Player b1 : firstBasemen) {
                if (overlap(c, b1)) continue;
                for (Player b2 : secondBasemen) {
                    if (overlap(c, b1, b2)) continue;
                    for (Player b3 : thirdBasemen) {
                        if (overlap(c, b1, b2, b3)) continue;
                        for (Player ss : shortstops) {
                            if (overlap(c, b1, b2, b3, ss)) continue;

                            // Choose 3 outfielders (combination, order doesn't matter)
                            List<Player> outfieldPool = availableOutfielders(c, b1, b2, b3, ss);
                            List<List<Player>> outfieldCombos = combinations(outfieldPool, 3);

                            for (List<Player> ofs : outfieldCombos) {
                                Set<Player> used = new HashSet<>(Arrays.asList(c, b1, b2, b3, ss));
                                used.addAll(ofs);

                                // Choose DH
                                List<Player> dhCandidates = availableDhCandidates(used);
                                for (Player dh : dhCandidates) {
                                    // Build lineup map
                                    Map<Position, Player> lineup = new HashMap<>();
                                    lineup.put(Position.CATCHER, c);
                                    lineup.put(Position.FIRST_BASE, b1);
                                    lineup.put(Position.SECOND_BASE, b2);
                                    lineup.put(Position.THIRD_BASE, b3);
                                    lineup.put(Position.SHORTSTOP, ss);

                                    // Assign OFs to LF, CF, RF (order doesn't matter)
                                    lineup.put(Position.LEFT_FIELD, ofs.get(0));
                                    lineup.put(Position.CENTER_FIELD, ofs.get(1));
                                    lineup.put(Position.RIGHT_FIELD, ofs.get(2));

                                    lineup.put(Position.DESIGNATED_HITTER, dh);
                                    System.out.println("lineup " + lineup);
                                    // Store the lineup
                                    generatedLineups.add(lineup);
                                    // saveLineupToDatabase(lineup);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Finished generating lineups!");
    }

    

    private List<Player> filterByPosition(Position pos) {
        return players.stream()
                .filter(p -> p.canPlayPosition(pos))
                .collect(Collectors.toList());
    }

    private List<Player> availableOutfielders(Player... usedPlayers) {
        Set<Player> used = new HashSet<>(Arrays.asList(usedPlayers));
        return outfielders.stream()
                .filter(p -> !used.contains(p))
                .collect(Collectors.toList());
    }

    private List<Player> availableDhCandidates(Set<Player> used) {
        return players.stream()
                .filter(p -> !used.contains(p))
                .filter(p -> !p.isDhOnly() || !used.contains(p)) // DH-only must DH if not already used
                .collect(Collectors.toList());
    }

    private boolean overlap(Player... ps) {
        Set<Integer> ids = new HashSet<>();
        for (Player p : ps) {
            if (!ids.add(p.playerId)) return true; // duplicate found
        }
        return false;
    }

    private <T> List<List<T>> combinations(List<T> list, int k) {
        List<List<T>> result = new ArrayList<>();
        combineHelper(list, new ArrayList<>(), 0, k, result);
        return result;
    }

    private <T> void combineHelper(List<T> list, List<T> temp, int start, int k, List<List<T>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            temp.add(list.get(i));
            combineHelper(list, temp, i + 1, k, result);
            temp.remove(temp.size() - 1);
        }
    }

    public List<Map<Position, Player>> getGeneratedLineups() {
        return generatedLineups;
    }

}
