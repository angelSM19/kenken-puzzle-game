package game.core;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ScoreManager {

    private static final Map<String, Map<Integer, Integer>> scores = new HashMap<>();
    private static final String FILE_NAME = "kenken_scores.dat";

    static {
        loadScores();
    }

    public static void setScore(String difficulty, int level, int score) {
        difficulty = difficulty.toLowerCase();
        scores.putIfAbsent(difficulty, new HashMap<>());
        scores.get(difficulty).put(level, score);
        saveScores();
    }

    public static int getScore(String difficulty, int level) {
        difficulty = difficulty.toLowerCase();
        if (!scores.containsKey(difficulty)) return 0;
        return scores.get(difficulty).getOrDefault(level, 0);
    }

    // Total score for a specific difficulty
    public static int getTotalScore(String difficulty) {
        difficulty = difficulty.toLowerCase();
        if (!scores.containsKey(difficulty)) return 0;
        return scores.get(difficulty).values().stream().mapToInt(Integer::intValue).sum();
    }

    // Total score across all difficulties
    public static int getGlobalScore() {
        return scores.values().stream()
                .flatMap(m -> m.values().stream())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void resetAllScores() {
        scores.clear();
        saveScores();
    }

    // Persistence

    private static void saveScores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(scores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadScores() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                scores.clear();
                scores.putAll((Map<String, Map<Integer, Integer>>) obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
