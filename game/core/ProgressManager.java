package game.core;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ProgressManager {

    private static final String SAVE_FILE = "kenken_progress.dat";

    private final Set<String> completed = new HashSet<>();

    public ProgressManager() {
        load();
    }

    private String key(String difficulty, int level) {
        return difficulty + "_" + level;
    }

    // mark a level completed
    public void markCompleted(String difficulty, int level) {
        completed.add(key(difficulty, level));
        save();
    }

    // get completed levels for a difficulty
    public Set<Integer> getCompletedLevels(String difficulty, int maxLevels) {
        Set<Integer> levels = new HashSet<>();
        for (int i = 1; i <= maxLevels; i++) {
            if (completed.contains(key(difficulty, i))) {
                levels.add(i);
            }
        }
        return levels;
    }

    // save to file
    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            out.writeObject(completed);
        } catch (IOException e) {
            System.err.println("Failed to save progress: " + e.getMessage());
        }
    }

    // load from file
    @SuppressWarnings("unchecked")
    private void load() {
        File file = new File(SAVE_FILE);
        if (!file.exists()) return;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = in.readObject();
            if (obj instanceof Set) {
                completed.addAll((Set<String>) obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load progress: " + e.getMessage());
        }
    }
}
