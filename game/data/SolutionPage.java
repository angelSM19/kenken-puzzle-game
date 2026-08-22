package game.data;

public class SolutionPage {

    public static int[][] getSolution(String difficulty, int level) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return getEasySolution(level);
            case "medium":
                return getMediumSolution(level);
            case "hard":
                return getHardSolution(level);
            default:
                throw new IllegalArgumentException("Unknown difficulty: " + difficulty);
        }
    }

    // Easy mode (3×3) — levels 1–24
    private static int[][] getEasySolution(int level) {
        switch (level) {
            case 1: return new int[][] {{2,1,3}, {3,2,1}, {1,3,2}};
            case 2: return new int[][] {{2,1,3}, {3,2,1}, {1,3,2}};
            case 3: return new int[][] {{1,2,3}, {2,3,1}, {3,1,2}};
            case 4: return new int[][] {{1,2,3}, {3,1,2}, {2,3,1}};
            case 5: return new int[][] {{1,3,2}, {2,1,3}, {3,2,1}};
            case 6: return new int[][] {{1,2,3}, {3,1,2}, {2,3,1}};
            case 7: return new int[][] {{2,1,3}, {3,2,1}, {1,3,2}};
            case 8: return new int[][] {{1,3,2}, {2,1,3}, {3,2,1}};
            case 9: return new int[][] {{1,2,3}, {3,1,2}, {2,3,1}};
            case 10: return new int[][] {{1,2,3}, {3,1,2}, {2,3,1}};
            case 11: return new int[][] {{3,2,1}, {1,3,2}, {2,1,3}};
            case 12: return new int[][] {{2,3,1}, {3,1,2}, {1,2,3}};
            case 13: return new int[][] {{2,3,1}, {3,1,2}, {1,2,3}};
            case 14: return new int[][] {{2,3,1}, {3,1,2}, {1,2,3}};
            case 15: return new int[][] {{1,2,3}, {2,3,1}, {3,1,2}};
            case 16: return new int[][] {{2,3,1}, {1,2,3}, {3,1,2}};
            case 17: return new int[][] {{1,2,3}, {3,1,2}, {2,3,1}};
            case 18: return new int[][] {{2,1,3}, {1,3,2}, {3,2,1}};
            case 19: return new int[][] {{2,3,1}, {3,1,2}, {1,2,3}};
            case 20: return new int[][] {{1,3,2}, {3,2,1}, {2,1,3}};
            case 21: return new int[][] {{2,3,1}, {3,1,2}, {1,2,3}};
            case 22: return new int[][] {{3,2,1}, {1,3,2}, {2,1,3}};
            case 23: return new int[][] {{1,3,2}, {2,1,3}, {3,2,1}};
            case 24: return new int[][] {{2,1,3}, {1,3,2}, {3,2,1}};
            default: throw new IllegalArgumentException("Easy level not found: " + level);
        }
    }

    // Medium mode (4×4) — levels 1–24
    private static int[][] getMediumSolution(int level) {
        switch (level) {
            case 1: return new int[][] {{4,3,2,1}, {3,2,1,4}, {2,1,4,3}, {1,4,3,2}};
            case 2: return new int[][] {{3,2,4,1}, {2,4,1,3}, {4,1,3,2}, {1,3,2,4}};
            case 3: return new int[][] {{1,4,3,2}, {4,3,2,1}, {3,2,1,4}, {2,1,4,3}};
            case 4: return new int[][] {{3,2,4,1}, {2,4,1,3}, {4,1,3,2}, {1,3,2,4}};
            case 5: return new int[][] {{4,1,2,3}, {1,2,3,4}, {2,3,4,1}, {3,4,1,2}};
            case 6: return new int[][] {{4,3,2,1}, {3,2,1,4}, {2,1,4,3}, {1,4,3,2}};
            case 7: return new int[][] {{3,4,2,1}, {4,2,1,3}, {2,1,3,4}, {1,3,4,2}};
            case 8: return new int[][] {{1,2,4,3}, {2,4,3,1}, {4,3,1,2}, {3,1,2,4}};
            case 9: return new int[][] {{1,3,2,4}, {3,2,4,1}, {2,4,1,3}, {4,1,3,2}};
            case 10: return new int[][] {{2,4,3,1}, {4,3,1,2}, {3,1,2,4}, {1,2,4,3}};
            case 11: return new int[][] {{1,2,4,3}, {2,4,3,1}, {4,3,1,2}, {3,1,2,4}};
            case 12: return new int[][] {{1,4,2,3}, {4,2,3,1}, {2,3,1,4}, {3,1,4,2}};
            case 13: return new int[][] {{4,3,1,2}, {3,1,2,4}, {1,2,4,3}, {2,4,3,1}};
            case 14: return new int[][] {{2,1,4,3}, {1,4,3,2}, {4,3,2,1}, {3,2,1,4}};
            case 15: return new int[][] {{2,4,1,3}, {4,1,3,2}, {1,3,2,4}, {3,2,4,1}};
            case 16: return new int[][] {{1,4,2,3}, {4,2,3,1}, {2,3,1,4}, {3,1,4,2}};
            case 17: return new int[][] {{3,4,1,2}, {4,1,2,3}, {1,2,3,4}, {2,3,4,1}};
            case 18: return new int[][] {{2,1,4,3}, {1,4,3,2}, {4,3,2,1}, {3,2,1,4}};
            case 19: return new int[][] {{1,2,4,3}, {2,4,3,1}, {4,3,1,2}, {3,1,2,4}};
            case 20: return new int[][] {{2,4,1,3}, {4,1,3,2}, {1,3,2,4}, {3,2,4,1}};
            case 21: return new int[][] {{4,2,3,1}, {2,3,1,4}, {3,1,4,2}, {1,4,2,3}};
            case 22: return new int[][] {{1,2,4,3}, {2,4,3,1}, {4,3,1,2}, {3,1,2,4}};
            case 23: return new int[][] {{4,3,1,2}, {3,1,2,4}, {1,2,4,3}, {2,4,3,1}};
            case 24: return new int[][] {{1,4,2,3}, {4,2,3,1}, {2,3,1,4}, {3,1,4,2}};

            default: throw new IllegalArgumentException("Medium level not found: " + level);
        }
    }

    private static int[][] getHardSolution(int level) {
    switch (level) {
        case 1: return new int[][] {{4,3,2,1,5}, {3,2,1,5,4}, {2,1,5,4,3}, {1,5,4,3,2}, {5,4,3,2,1}};
        case 2: return new int[][] {{2,3,5,1,4}, {4,1,3,2,5}, {5,4,2,3,1}, {3,2,1,4,5}, {1,5,4,2,3}};
        case 3: return new int[][] {{5,4,3,1,2}, {3,2,5,4,1}, {4,5,1,2,3}, {1,3,2,5,4}, {2,1,4,3,5}};
        case 4: return new int[][] {{3,1,4,5,2}, {4,5,2,3,1}, {5,2,3,1,4}, {2,3,1,4,5}, {1,4,5,2,3}};
        case 5: return new int[][] {{3,1,4,2,5}, {4,2,5,3,1}, {5,3,1,4,2}, {2,5,3,1,4}, {1,4,2,5,3}};
        case 6: return new int[][] {{4,3,5,1,2}, {1,5,3,4,2}, {5,1,2,3,4}, {3,2,4,5,1}, {2,4,1,3,5}};
        case 7: return new int[][] {{3,5,1,4,2}, {2,1,4,3,5}, {5,4,3,2,1}, {1,3,2,5,4}, {4,2,5,1,3}};
        case 8: return new int[][] {{5,4,2,3,1}, {2,3,1,5,4}, {3,1,5,4,2}, {1,5,4,2,3}, {4,2,3,1,5}};
        case 9: return new int[][] {{2,3,1,5,4}, {1,5,3,4,2}, {5,4,2,3,1}, {3,2,5,1,4}, {4,1,4,2,3}};
        case 10: return new int[][] {{4,3,1,5,2}, {5,1,4,2,3}, {1,2,3,4,5}, {2,5,3,1,4}, {3,4,5,2,1}};
        case 11: return new int[][] {{3,2,1,4,5}, {2,1,5,3,4}, {5,4,3,2,1}, {4,5,2,1,3}, {1,3,4,5,2}};
        case 12: return new int[][] {{3,2,5,1,4}, {2,1,4,5,3}, {5,4,3,2,1}, {1,5,2,4,3}, {4,3,1,2,5}};

        default: throw new IllegalArgumentException("Hard level not found: " + level);
        }
    }

}
