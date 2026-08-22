package game.data;

public class PresetBank {

    public static int[][] getPresets(String difficulty, int level) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return getEasyPresets(level);
            case "medium":
                return getMediumPresets(level);
            case "hard":
                return getHardPresets(level);
            default:
                throw new IllegalArgumentException("Unsupported difficulty: " + difficulty);
        }
    }

    private static int[][] getEasyPresets(int level) {
        switch (level) {
            case 1: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 2: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 3: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 4: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 5: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 6: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 7: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 8: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 9: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 10: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 11: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 12: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 13: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 14: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 15: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 16: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 17: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 18: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 19: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 20: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 21: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 22: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 23: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            case 24: return new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            default: return new int[3][3];
        }
    }

    private static int[][] getMediumPresets(int level) {
        switch (level) {
            case 1: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 2: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 3: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 4: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 5: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 6: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 7: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 8: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 9: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 10: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 11: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 12: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 13: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 14: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 15: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 16: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 17: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 18: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 19: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 20: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 21: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 22: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 23: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            case 24: return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            default: return new int[4][4];
        }
    }

    private static int[][] getHardPresets(int level) {
        switch (level) {
            case 1: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 2: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 3: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 4: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 5: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 6: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 7: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 8: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 9: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 10: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 11: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            case 12: return new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            default: return new int[5][5];
        }
    }
}
