package udemy_master_class.section_7.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import udemy_master_class.section_7.two.databases.Database;

import static udemy_master_class.section_7.two.annotations.Annotations.*;

public class BestGamesFinder {

    private Database database = new Database();

    @Operation("All-Games")
    public Set<String> getAllGames() {
        return database.readAllGames();
    }

    @Operation("Get-To-Price")
    public Map<String, Float> getGameToPrice(@DependsOn("All-Games") Set<String> allGames) {
        return database.readGameToPrice(allGames);
    }

    @Operation("Get-To-Rating")
    public Map<String, Float> getGameToRating(@DependsOn("All-Games") Set<String> allGames) {
        return database.readGameToRatings(allGames);
    }

    @Operation("Score-To-Game")
    public SortedMap<Double, String> scoreGames(@DependsOn("Get-To-Price") Map<String, Float> gameToPrice,
                                                @DependsOn("Get-To-Rating") Map<String, Float> gameToRating) {
        SortedMap<Double, String> gameToScore = new TreeMap<>(Collections.reverseOrder());
        for (String gameName : gameToPrice.keySet()) {
            double score = (double) gameToRating.get(gameName) / gameToPrice.get(gameName);
            gameToScore.put(score, gameName);
        }

        return gameToScore;
    }

    @FinalResult
    public List<String> getTopGames(@DependsOn("Score-To-Game") Map<Double, String> gameToScore) {
        return new ArrayList<>(gameToScore.values());
    }
}

