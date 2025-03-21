import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.Player;

public class LineupConnector {

    static final String DB_URL = "jdbc:mysql://localhost:3306/baseball_lineups";
    static final String USER = "root";
    static final String PASS = "your_root_password";

    List<Player> players;
    List<Player> dhOnlyPlayers;
    List<Player> outfielders;

    private void loadPlayersFromDatabase() {
        players = new ArrayList<>();
        dhOnlyPlayers = new ArrayList<>();
        outfielders = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT player_id, name, positions FROM players";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("player_id");
                String name = rs.getString("name");
                String posStr = rs.getString("positions");
                List<String> posList = Arrays.stream(posStr.split(",\\s*")).collect(Collectors.toList());

                Player p = new Player(id, name, posList);
                players.add(p);

                if (p.isDhOnly()) dhOnlyPlayers.add(p);
                if (p.isOutfielder()) outfielders.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    private void saveLineupToDatabase(Map<String, Integer> lineup) {
        String sql = "INSERT INTO lineups (C, 1B, 2B, 3B, SS, LF, CF, RF, DH) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, lineup.get("C"));
            stmt.setInt(2, lineup.get("1B"));
            stmt.setInt(3, lineup.get("2B"));
            stmt.setInt(4, lineup.get("3B"));
            stmt.setInt(5, lineup.get("SS"));
            stmt.setInt(6, lineup.get("LF"));
            stmt.setInt(7, lineup.get("CF"));
            stmt.setInt(8, lineup.get("RF"));
            stmt.setInt(9, lineup.get("DH"));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}}
