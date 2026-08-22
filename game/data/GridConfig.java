package game.data;

import java.awt.Color;
import javax.swing.UIManager;

public class GridConfig {

    
    public static int getGridSize(String difficulty, int level) {
        switch (difficulty.toLowerCase()) {
            case "easy": return 3;
            case "medium": return 4;
            case "hard": return 5;
            default:
                throw new IllegalArgumentException("Unsupported difficulty: " + difficulty);
        }
    }

    public static String[][] getHintLayout(String difficulty, int level) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return getEasyHintLayout(level);
            case "medium":
                return getMediumHintLayout(level);
            case "hard":
                return getHardHintLayout(level);
            default:
                throw new IllegalArgumentException("Unsupported difficulty: " + difficulty);
        }
    }

    public static boolean[][][] getCageBorders(String difficulty, int level) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return getEasyCageBorders(level);
            case "medium":
                return getMediumCageBorders(level);
            case "hard":
                return getHardCageBorders(level);
            default:
                throw new IllegalArgumentException("Unsupported difficulty: " + difficulty);
        }
    }

    public static Color[][] getCellColors(String difficulty, int level) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return getEasyCellColors(level);
            case "medium":
                return getMediumCellColors(level);
            case "hard":
                return getHardCellColors(level);
            default:
                throw new IllegalArgumentException("Unsupported difficulty: " + difficulty);
        }
    }



    // Top-left hint labels per cage cell
    private static String[][] getEasyHintLayout(int level) {
        switch (level) {
            case 1: return new String[][] {
                {"1 -", "3 x", ""},
                {"", "5 +", ""},
                {"3 x", "", ""}
            };
            case 2: return new String[][] {
                {"6 x", "", ""},
                {"7 +", "4 x", ""},
                {"", "", ""}
            };
            case 3: return new String[][] {
                {"1 -", "18 x", ""},
                {"", "", "1 -"},
                {"3 x", "", ""}
            };
            case 4: return new String[][] {
                {"2 x", "", "1 -"},
                {"1 -", "", ""},
                {"", "3 x", ""}
            };
            case 5: return new String[][] {
                {"5 +", "", "1 -"},
                {"1 -", "", ""},
                {"", "2 x", ""}
            };
            case 6: return new String[][] {
                {"3 x", "1 -", ""},
                {"", "2 x", ""},
                {"1 -", "", ""}
            };
            case 7: return new String[][] {
                {"1 -", "", "3 x"},
                {"3 x", "7 +", ""},
                {"", "", ""}
            };
            case 8: return new String[][] {
                {"3 x", "", "1 -"},
                {"1 -", "2 x", ""},
                {"", "", ""}
            };
            case 9: return new String[][] {
                {"3 x", "1 -", ""},
                {"", "4 +", ""},
                {"1 -", "", ""}
            };
            case 10: return new String[][] {
                {"5 +", "1 -", ""},
                {"", "", "2 x"},
                {"1 -", "", ""}
            };
            case 11: return new String[][] {
                {"1 -", "", "18 x"},
                {"4 +", "", ""},
                {"", "", ""}
            };
            case 12: return new String[][] {
                {"6 x", "3 x", ""},
                {"", "6 +", ""},
                {"1 -", "", ""}
            };
            case 13: return new String[][] {
                {"1 -", "", "4 +"},
                {"3 x", "", ""},
                {"", "1 -", ""}
            };
            case 14: return new String[][] {
                {"1 -", "3 x", ""},
                {"", "2 x", "1 -"},
                {"", "", ""}
            };
            case 15: return new String[][] {
                {"1 -", "", "9 x"},
                {"1 -", "", ""},
                {"", "2 x", ""}
            };
            case 16: return new String[][] {
                {"4 x", "3 x", ""},
                {"", "", "1 -"},
                {"3 x", "", ""}
            };
            case 17: return new String[][] {
                {"1 -", "", "1 -"},
                {"6 x", "5 +", ""},
                {"", "", ""}
            };
            case 18: return new String[][] {
                {"1 -", "3 x", ""},
                {"", "8 +", "1 -"},
                {"", "", ""}
            };
            case 19: return new String[][] {
                {"1 -", "3 x", ""},
                {"", "6 +", ""},
                {"2 x", "", ""}
            };
            case 20: return new String[][] {
                {"7 +", "", ""},
                {"12 x", "", ""},
                {"", "3 x", ""}
            };
            case 21: return new String[][] {
                {"1 -", "3 x", ""},
                {"", "4 +", ""},
                {"", "", "1 -"}
            };
            case 22: return new String[][] {
                {"3 x", "2 x", ""},
                {"", "8 +", ""},
                {"1 -", "", ""}
            };
            case 23: return new String[][] {
                {"6 x", "18 x", ""},
                {"", "4 +", ""},
                {"", "", ""}
            };
            case 24: return new String[][] {
                {"1 -", "3 x", ""},
                {"", "18 x", "1 -"},
                {"", "", ""}
            };
            default: return new String[3][3];
        }
    }

    // Cage borders: [top, right, bottom, left] per cell
private static boolean[][][] getEasyCageBorders(int level) {
    int size = 3;
    boolean[][][] borders = new boolean[size][size][4];

    switch (level) {
        // borders[row][column] = new boolean[] {top, right, bottom, left};
        case 1:
            borders[0][0] = new boolean[] {true, true, true, true}; 
            borders[0][1] = new boolean[] {true, false, true, true}; 
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};   
            borders[1][2] = new boolean[] {true, true, false, false};
                
            borders[2][0] = new boolean[] {true, false, true, true};     
            borders[2][1] = new boolean[] {true, true, true, false};    
            borders[2][2] = new boolean[] {false, true, true, true};     
            return borders;

        case 2:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, false, true, false};
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, false, false};

            borders[2][0] = new boolean[] {false, false, true, true};
            borders[2][1] = new boolean[] {true, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            return borders;

        case 3:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, false, true};
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {false, true, true, true};
            borders[1][2] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {true, false, true, true};
            borders[2][1] = new boolean[] {true, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            return borders;

        case 4:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, false, false};
            borders[0][2] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {false, true, true, true};
            borders[1][2] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            return borders;

        case 5:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, false, false};
            borders[0][2] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {false, true, true, true};
            borders[1][2] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            return borders;

        case 6:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, false, true, true}; 
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};   
            borders[1][2] = new boolean[] {true, true, false, false};
                
            borders[2][0] = new boolean[] {true, false, true, true};     
            borders[2][1] = new boolean[] {true, true, true, false};    
            borders[2][2] = new boolean[] {false, true, true, true};     
            return borders;

        case 7:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {false, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            return borders;

        case 8:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {false, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            return borders;
        
        case 9:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, false, true, true}; 
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};   
            borders[1][2] = new boolean[] {true, true, false, false};
                
            borders[2][0] = new boolean[] {true, false, true, true};     
            borders[2][1] = new boolean[] {true, true, true, false};    
            borders[2][2] = new boolean[] {false, true, true, true};     
            return borders;

        case 10:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, false, true, true};
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {true, false, true, true};
            borders[2][1] = new boolean[] {true, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            return borders;

        case 11:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {false, true, false, false};

            borders[2][0] = new boolean[] {false, false, true, true};
            borders[2][1] = new boolean[] {true, true, true, true};
            borders[2][2] = new boolean[] {false, true, true, true};
            return borders;

        case 12:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, false, true, true}; 
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};   
            borders[1][2] = new boolean[] {true, true, false, false};
                
            borders[2][0] = new boolean[] {true, false, true, true};     
            borders[2][1] = new boolean[] {true, true, true, false};    
            borders[2][2] = new boolean[] {false, true, true, true};     
            return borders;

        case 13:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {false, true, true, false};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            return borders;

        case 14:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {true, false, true, true};
            borders[2][1] = new boolean[] {false, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            return borders;

        case 15:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {false, true, true, false};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            return borders;

        case 16:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, false, true, true};
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {true, false, true, true};
            borders[2][1] = new boolean[] {true, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            return borders;

        case 17:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {false, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            return borders;

        case 18:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {true, false, true, true};
            borders[2][1] = new boolean[] {false, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            return borders;

        case 19:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, false, true, true}; 
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};   
            borders[1][2] = new boolean[] {true, true, false, false};
                
            borders[2][0] = new boolean[] {true, false, true, true};     
            borders[2][1] = new boolean[] {true, true, true, false};    
            borders[2][2] = new boolean[] {false, true, true, true};     
            return borders;

        case 20:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, false, true, false};
            borders[0][2] = new boolean[] {true, true, false, false};

            borders[1][0] = new boolean[] {true, false, false, true};
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            return borders;

        case 21:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {true, false, true, true};
            borders[2][1] = new boolean[] {false, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            return borders;

        case 22:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, false, true, true}; 
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};   
            borders[1][2] = new boolean[] {true, true, false, false};
                
            borders[2][0] = new boolean[] {true, false, true, true};     
            borders[2][1] = new boolean[] {true, true, true, false};    
            borders[2][2] = new boolean[] {false, true, true, true};     
            return borders;

        case 23:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, false, false};

            borders[1][0] = new boolean[] {false, true, false, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {false, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            return borders;

        case 24:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {true, false, true, true};
            borders[2][1] = new boolean[] {false, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            return borders;

        default:
            return new boolean[size][size][4];
        }
    }

public static Color[][] getEasyCellColors(int level) {
        int size = 3;
        Color[][] colors = new Color[size][size];

        switch (level) {
            case 1: return new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color2"), (Color) UIManager.get("Color2") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color3"), (Color) UIManager.get("Color3") },
                    { (Color) UIManager.get("Color4"), (Color) UIManager.get("Color4"), (Color) UIManager.get("Color3") }
                };
            case 2: return new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color2"), (Color) UIManager.get("Color3"), (Color) UIManager.get("Color3") },
                    { (Color) UIManager.get("Color2"), (Color) UIManager.get("Color2"), (Color) UIManager.get("Color3") }
                };
            case 3: return new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color2"), (Color) UIManager.get("Color2") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color2"), (Color) UIManager.get("Color4") },
                    { (Color) UIManager.get("Color3"), (Color) UIManager.get("Color3"), (Color) UIManager.get("Color4") }
                };
            /*case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
                case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };
            case 1:
                colors = new Color[][] {
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") },
                    { (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1"), (Color) UIManager.get("Color1") }
                };*/

            default:
                for (int r = 0; r < size; r++)
                    for (int c = 0; c < size; c++)
                        colors[r][c] = Color.WHITE;
        }
        return colors;
    }

private static String[][] getMediumHintLayout(int level) {
    switch (level) {
        case 1: return new String[][] {
            {"8 +", "2 -", "", "2 /"},
            {"", "2 /", "", ""},
            {"", "24 x", "2 -", "3 x"},
            {"", "", "", ""}
        };
        case 2: return new String[][] {
            {"1 -", "", "4 x", ""},
            {"8 x", "", "6 +", "1 -"},
            {"", "", "", ""},
            {"", "9 +", "", ""}
        };
        case 3: return new String[][] {
            {"2 -", "13 +", "", ""},
            {"", "2 /", "", ""},
            {"24 x", "", "2 /", ""},
            {"", "", "1 -", ""}
        };
        case 4: return new String[][] {
            {"5 +", "2 /", "", "3 x"},
            {"", "1 -", "2 /", ""},
            {"4 x", "", "", "2 /"},
            {"", "2 -", "", ""}
        };
        case 5: return new String[][] {
            {"2 /", "2 /", "", "12 x"},
            {"", "1 -", "", ""},
            {"2 -", "", "8 x", ""},
            {"", "5 +", "", ""}
        };
        case 6: return new String[][] {
            {"2 /", "1 -", "9 +", ""},
            {"", "", "", "7 +"},
            {"12 x", "3 x", "", ""},
            {"", "1 -", "", ""}
        };
        case 7: return new String[][] {
            {"12 x", "", "5 +", ""},
            {"2 /", "2 -", "", ""},
            {"", "6 x", "5 +", "1 -"},
            {"", "", "", ""}
        };
        case 8: return new String[][] {
            {"11 +", "24 x", "", ""},
            {"", "8 x", "", "2 /"},
            {"", "", "", ""},
            {"2 /", "", "2 -", ""}
        };
        case 9: return new String[][] {
            {"8 +", "1 -", "", "2 -"},
            {"", "", "2 /", ""},
            {"9 x", "", "", "2 -"},
            {"", "4 x", "", ""}
        };
        case 10: return new String[][] {
            {"2 /", "", "12 x", ""},
            {"1 -", "", "", "7 +"},
            {"12 x", "2 /", "", ""},
            {"", "2 -", "", ""}
        };
        case 11: return new String[][] {
            {"9 x", "", "", "9 +"},
            {"2 -", "4 x", "", ""},
            {"", "", "1 -", ""},
            {"5 +", "", "4 x", ""}
        };
        case 12: return new String[][] {
            {"4 x", "", "9 +", "2 /"},
            {"9 +", "", "", ""},
            {"", "2 x", "", "1 -"},
            {"", "2 -", "", ""}
        };
        case 13: return new String[][] {
            {"9 +", "", "2 -", "2 /"},
            {"", "4 x", "", ""},
            {"2 -", "", "24 x", ""},
            {"", "2 /", "", ""}
        };
        case 14: return new String[][] {
            {"2 /", "1 -", "", "48 x"},
            {"", "2 /", "", ""},
            {"1 -", "", "6 x", ""},
            {"", "5 +", "", ""}
        };
        case 15: return new String[][] {
            {"2 /", "", "6 x", ""},
            {"1 -", "5 +", "", ""},
            {"", "18 x", "7 +", ""},
            {"", "", "", ""},
        };
        case 16: return new String[][] {
            {"2 /", "1 -", "", "5 +"},
            {"", "2 -", "", ""},
            {"3 x", "", "32 x", "5 +"},
            {"", "", "", ""},
        };
        case 17: return new String[][] {
            {"1 -", "", "4 +", "1 -"},
            {"8 x", "", "", ""},
            {"", "", "1 -", ""},
            {"5 +", "", "4 x", ""}
        };
        case 18: return new String[][] {
            {"2 /", "4 x", "", "1 -"},
            {"", "2 -", "10 +", ""},
            {"12 x", "", "", ""},
            {"", "6 +", "", ""}
        };
        case 19: return new String[][] {
            {"7 +", "", "1 -", ""},
            {"5 +", "", "2 -", ""},
            {"", "12 x", "16 x", ""},
            {"", "", "", ""}
        };
        case 20: return new String[][] {
            {"2 /", "", "1 -", ""},
            {"12 x", "1 -", "", "2 /"},
            {"", "5 +", "8 x", ""},
            {"", "", "", ""}
        };
        case 21: return new String[][] {
            {"2 -", "", "1 -", "6 +"},
            {"2 /", "", "", ""},
            {"24 x", "2 /", "", ""},
            {"", "", "4 x", ""}
        };
        case 22: return new String[][] {
            {"1 -", "", "5 +", ""},
            {"1 -", "4 x", "2 -", ""},
            {"", "", "", "48 x"},
            {"2 /", "", "", ""}
        };
        case 23: return new String[][] {
            {"5 +", "6 x", "", "6 +"},
            {"", "4 x", "", ""},
            {"12 x", "", "5 +", "1 -"},
            {"", "", "", ""}
        };

        case 24: return new String[][] {
            {"6 +", "1 -", "", "5 +"},
            {"", "32 x", "", ""},
            {"", "12 x", "", "1 -"},
            {"", "", "", ""}
        };

        default: return new String[4][4];
        }
    }

private static boolean[][][] getMediumCageBorders(int level) {
    int size = 4;
    boolean[][][] borders = new boolean[size][size][4];

    switch (level) {
        case 1:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};
            borders[2][2] = new boolean[] {true, true, false, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            
            borders[3][0] = new boolean[] {true, false, true, true};
            borders[3][1] = new boolean[] {false, true, true, false};
            borders[3][2] = new boolean[] {false, true, true, true};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 2:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {true, false, false, true};
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {true, true, false, true};
            borders[1][3] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {false, true, false, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {false, true, true, false};
            borders[2][3] = new boolean[] {false, true, true, true};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, false, true, false};
            borders[3][3] = new boolean[] {true, true, true, false};
            return borders;

        case 3:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, false, true, false};
            borders[0][3] = new boolean[] {true, true, false, false};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {true, false, false, true};
            borders[2][1] = new boolean[] {true, true, false, false};
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, true, false};
            
            borders[3][0] = new boolean[] {false, false, true, true};
            borders[3][1] = new boolean[] {false, true, true, false};
            borders[3][2] = new boolean[] {true, false, true, true};
            borders[3][3] = new boolean[] {true, true, true, false};
            return borders;

        case 4:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, true, false, true};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {false, true, true, true};
            borders[2][2] = new boolean[] {false, true, true, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 5:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, false, true, true};
            borders[1][3] = new boolean[] {false, true, true, false};

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {false, true, true, true};
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, false, false};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 6:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, true, false, true};
            borders[0][2] = new boolean[] {true, false, false, true};
            borders[0][3] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {false, true, true, true};
            borders[1][2] = new boolean[] {false, true, true, true};
            borders[1][3] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            borders[2][3] = new boolean[] {false, true, false, true};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 7:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, false, false};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};
            borders[2][2] = new boolean[] {true, true, false, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            
            borders[3][0] = new boolean[] {true, false, true, true};
            borders[3][1] = new boolean[] {false, true, true, false};
            borders[3][2] = new boolean[] {false, true, true, true};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 8:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, false, true, false};
            borders[0][3] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, false, false};
            borders[1][3] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {false, false, true, true};
            borders[2][1] = new boolean[] {true, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            borders[2][3] = new boolean[] {false, true, true, true};
            
            borders[3][0] = new boolean[] {true, false, true, true};
            borders[3][1] = new boolean[] {true, true, true, false};
            borders[3][2] = new boolean[] {true, false, true, true};
            borders[3][3] = new boolean[] {true, true, true, false};
            return borders;

        case 9:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, false, true, true};
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {true, true, false, true};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {true, false, false, true};
            borders[2][1] = new boolean[] {true, true, true, false};
            borders[2][2] = new boolean[] {false, true, true, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 10:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, false, true};
            borders[0][3] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {true, false, true, true};
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {false, true, true, true};
            borders[1][3] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            borders[2][3] = new boolean[] {false, true, true, false};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 11:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, false, true, false};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, false, true, true};
            borders[1][3] = new boolean[] {false, true, true, false};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {false, true, true, true};
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, true, false};
            
            borders[3][0] = new boolean[] {true, false, true, true};
            borders[3][1] = new boolean[] {true, true, true, false};
            borders[3][2] = new boolean[] {true, false, true, true};
            borders[3][3] = new boolean[] {true, true, true, false};
            return borders;

        case 12:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {false, true, true, false};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, false, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            borders[2][3] = new boolean[] {true, true, false, true};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 13:
            borders[0][0] = new boolean[] {true, false, false, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {false, true, true, true};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {false, true, true, true};
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, false, false};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 14:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, false, true, true};
            borders[1][3] = new boolean[] {false, true, true, false};

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {false, true, true, true};
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, false, false};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 15:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, false, false};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, false, false};
            
            borders[3][0] = new boolean[] {true, false, true, true};
            borders[3][1] = new boolean[] {false, false, true, false};
            borders[3][2] = new boolean[] {true, false, true, true};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 16:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {true, false, false, true};
            borders[2][1] = new boolean[] {true, true, true, false};
            borders[2][2] = new boolean[] {true, true, false, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {false, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 17:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {false, true, true, false};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, false, true, true};
            borders[2][1] = new boolean[] {true, true, true, false};
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, true, false};
            
            borders[3][0] = new boolean[] {true, false, true, true};
            borders[3][1] = new boolean[] {true, true, true, false};
            borders[3][2] = new boolean[] {true, false, true, true};
            borders[3][3] = new boolean[] {true, true, true, false};
            return borders;

        case 18:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, true, false, true};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {false, true, true, true};
            borders[2][2] = new boolean[] {false, false, true, true};
            borders[2][3] = new boolean[] {true, true, true, false};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {true, false, true, true};
            borders[3][2] = new boolean[] {true, false, true, false};
            borders[3][3] = new boolean[] {true, true, true, false};
            return borders;

        case 19:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, false, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {false, true, true, true};
            borders[1][2] = new boolean[] {true, false, true, true};
            borders[1][3] = new boolean[] {true, true, true, false};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, false, false};
            
            borders[3][0] = new boolean[] {true, false, true, true};
            borders[3][1] = new boolean[] {false, false, true, false};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 20:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {true, true, false, true};

            borders[2][0] = new boolean[] {false, true, false, true};
            borders[2][1] = new boolean[] {true, true, false, true};
            borders[2][2] = new boolean[] {true, true, false, true};
            borders[2][3] = new boolean[] {false, true, true, true};
            
            borders[3][0] = new boolean[] {false, true, true, true};
            borders[3][1] = new boolean[] {false, true, true, true};
            borders[3][2] = new boolean[] {false, false, true, true};
            borders[3][3] = new boolean[] {true, true, true, false};
            return borders;

        case 21:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, true, false, true};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, false, true, true};
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {false, true, true, true};
            borders[1][3] = new boolean[] {false, true, false, true};

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {true, false, true, true};
            borders[2][2] = new boolean[] {true, true, true, false};
            borders[2][3] = new boolean[] {false, true, true, true};
            
            borders[3][0] = new boolean[] {false, false, true, true};
            borders[3][1] = new boolean[] {true, true, true, false};
            borders[3][2] = new boolean[] {true, false, true, true};
            borders[3][3] = new boolean[] {true, true, true, false};
            return borders;

        case 22:
            borders[0][0] = new boolean[] {true, false, true, true};
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, false, false};

            borders[1][0] = new boolean[] {true, true, false, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, true, false, true};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {false, true, true, true};
            borders[2][2] = new boolean[] {false, true, true, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            
            borders[3][0] = new boolean[] {true, false, true, true};
            borders[3][1] = new boolean[] {true, true, true, false};
            borders[3][2] = new boolean[] {true, false, true, true};
            borders[3][3] = new boolean[] {false, true, true, false};
            return borders;

        case 23:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true};
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, false, true, true};
            borders[1][3] = new boolean[] {false, true, true, false};

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {false, true, true, true};
            borders[2][2] = new boolean[] {true, true, false, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            
            borders[3][0] = new boolean[] {false, false, true, true};
            borders[3][1] = new boolean[] {true, true, true, false};
            borders[3][2] = new boolean[] {false, true, true, true};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        case 24:
            borders[0][0] = new boolean[] {true, true, false, true};
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, false, true};
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, false, false};
            borders[1][3] = new boolean[] {false, true, true, true};

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};
            borders[2][2] = new boolean[] {false, true, true, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            
            borders[3][0] = new boolean[] {true, false, true, true};
            borders[3][1] = new boolean[] {false, false, true, false};
            borders[3][2] = new boolean[] {true, true, true, false};
            borders[3][3] = new boolean[] {false, true, true, true};
            return borders;

        default: return new boolean[size][size][4];
        }
    }

public static Color[][] getMediumCellColors(int level) {
        int size = 4;
        Color[][] colors = new Color[size][size];

        switch (level) {
            case 1:
                colors = new Color[][] {
                    { new Color(255, 230, 230), new Color(230, 255, 230), new Color(230, 230, 255), new Color(255, 240, 200) },
                    { new Color(255, 210, 240), new Color(200, 255, 250), new Color(240, 200, 250), new Color(200, 240, 255) },
                    { new Color(250, 220, 180), new Color(180, 250, 200), new Color(220, 250, 220), new Color(250, 220, 220) },
                    { new Color(200, 230, 250), new Color(250, 200, 230), new Color(230, 250, 200), new Color(210, 210, 240) }
                };
                break;

            default:
                for (int r = 0; r < size; r++)
                    for (int c = 0; c < size; c++)
                        colors[r][c] = Color.WHITE;
        }
        return colors;
    }

private static String[][] getHardHintLayout(int level) {
    switch (level) {
        case 1: return new String[][] {
            {"7 +", "2 -", "", "2 /", "20 x"},
            {"", "1 -", "2 /", "", ""},
            {"8 +", "", "", "2 -", "2 -"},
            {"", "6 x", "20 x", "", ""},
            {"", "", "", "2 /", ""}
        };

        case 2: return new String[][] {
            {"14 +", "", "", "5 x", "2 /"},
            {"20 x", "", "2 -", "", ""},
            {"", "7 +", "", "5 +", "2 -"},
            {"", "", "2 /", "", ""},
            {"3 x", "", "", "1 -", ""}
        };

        case 3: return new String[][] {
            {"60 x", "", "", "1 -", ""},
            {"6 +", "2 -", "", "8 +", ""},
            {"", "5 x", "2 /", "", ""},
            {"6 +", "", "2 /", "15 x", "1 -"},
            {"", "", "", "", ""}
        };

        case 4: return new String[][] {
            {"6 x", "", "3 -", "", "6 +"},
            {"11 +", "", "6 x", "2 -", ""},
            {"", "4 x", "", "", "1 -"},
            {"5 x", "", "3 -", "", ""},
            {"", "7 +", "", "2 /", ""}
        };

        case 5: return new String[][] {
            {"2 -", "", "3 -", "", "6 x"},
            {"10 +", "", "3 -", "", ""},
            {"", "3 x", "7 +", "2 /", ""},
            {"13 +", "", "", "2 -", "5 x"},
            {"", "", "", "", ""}
        };

        case 6: return new String[][] {
            {"20 x", "2 -", "6 +", "", "2 /"},
            {"", "", "6 x", "", ""},
            {"", "16 x", "3 -", "", "9 +"},
            {"1 -", "", "", "2 -", ""},
            {"", "5 +", "", "", ""}
        };

        case 7: return new String[][] {
            {"1 -", "7 +", "5 x", "", "1 -"},
            {"", "", "3 -", "", ""},
            {"1 -", "", "7 +", "2 /", ""},
            {"3 x", "", "", "10 x", ""},
            {"4 x", "", "10 +", "", ""}
        };

        case 8: return new String[][] {
            {"1 -", "", "6 x", "", ""},
            {"5 +", "15 x", "5 x", "", "2 /"},
            {"", "", "", "2 /", ""},
            {"10 +", "", "", "", "2 -"},
            {"2 /", "", "2 -", "", ""}
        };
        case 9:
            return new String[][] {
                {"2 /", "3 x", "", "1 -", ""},
                {"", "2 -", "", "12 x", "2 /"},
                {"1 -", "", "6 +", "", ""},
                {"7 +", "2 /", "", "30 x", ""},
                {"", "", "6 +", "", ""}
            };

        case 10:
            return new String[][] {
                {"60 x", "", "", "2 /", ""},
                {"5 x", "", "24 x", "5 +", ""},
                {"7 +", "", "", "1 -", ""},
                {"", "", "2 /", "6 +", "1 -"},
                {"2 -", "", "", "", ""}
            };

        case 11:
            return new String[][] {
                {"30 x", "2 /", "", "60 x", ""},
                {"", "6 +", "", "", "12 x"},
                {"", "16 +", "1 -", "", ""},
                {"5 +", "", "", "3 -", "2 x"},
                {"", "", "", "", ""}
            };

        case 12:
            return new String[][] {
                {"6 x", "", "1 -", "", "10 +"},
                {"", "6 x", "", "", ""},
                {"20 x", "3 -", "", "6 x", ""},
                {"", "", "5 +", "", "2 -"},
                {"7 +", "", "3 -", "", ""}
            };

            default: return new String[5][5];

        }
    }

private static boolean[][][] getHardCageBorders(int level) { 
    int size = 5; 
    boolean[][][] borders = new boolean[size][size][4];

    switch (level) {
        case 1:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};
            borders[0][4] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, true, false, true};
            borders[1][3] = new boolean[] {false, true, true, true};
            borders[1][4] = new boolean[] {false, true, true, true}; 

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {false, true, true, true};  
            borders[2][2] = new boolean[] {false, true, true, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            borders[2][4] = new boolean[] {true, true, false, true};

            borders[3][0] = new boolean[] {false, true, false, true}; 
            borders[3][1] = new boolean[] {true, true, false, true};
            borders[3][2] = new boolean[] {true, true, false, true}; 
            borders[3][3] = new boolean[] {false, true, true, true};
            borders[3][4] = new boolean[] {false, true, true, true};

            borders[4][0] = new boolean[] {false, true, true, true};
            borders[4][1] = new boolean[] {false, true, true, true};
            borders[4][2] = new boolean[] {false, true, true, true}; 
            borders[4][3] = new boolean[] {true, false, true, true};
            borders[4][4] = new boolean[] {true, true, true, false};
            return borders;

        case 2:
            borders[0][0] = new boolean[] {true, false, true, true}; 
            borders[0][1] = new boolean[] {true, false, false, false};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, true, false, true};
            borders[0][4] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, true, false, true}; 
            borders[1][1] = new boolean[] {false, true, true, true};
            borders[1][2] = new boolean[] {true, true, false, true};
            borders[1][3] = new boolean[] {false, true, true, true};
            borders[1][4] = new boolean[] {false, true, true, true}; 

            borders[2][0] = new boolean[] {false, true, false, true};
            borders[2][1] = new boolean[] {true, true, false, true};  
            borders[2][2] = new boolean[] {false, true, true, true};
            borders[2][3] = new boolean[] {true, true, false, true};
            borders[2][4] = new boolean[] {true, true, false, true};

            borders[3][0] = new boolean[] {false, true, true, true}; 
            borders[3][1] = new boolean[] {false, true, true, true};
            borders[3][2] = new boolean[] {true, true, false, true}; 
            borders[3][3] = new boolean[] {false, true, true, true};
            borders[3][4] = new boolean[] {false, true, true, true};

            borders[4][0] = new boolean[] {true, false, true, true};
            borders[4][1] = new boolean[] {true, true, true, false};
            borders[4][2] = new boolean[] {false, true, true, true}; 
            borders[4][3] = new boolean[] {true, false, true, true};
            borders[4][4] = new boolean[] {true, true, true, false};
            return borders;

        case 3:
            borders[0][0] = new boolean[] {true, false, true, true}; 
            borders[0][1] = new boolean[] {true, false, true, false};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, false, true, true};
            borders[0][4] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {true, true, false, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {true, false, true, true};
            borders[1][4] = new boolean[] {true, true, false, false}; 

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};  
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, true, false};
            borders[2][4] = new boolean[] {false, true, true, true};

            borders[3][0] = new boolean[] {true, true, false, true}; 
            borders[3][1] = new boolean[] {false, true, true, true};
            borders[3][2] = new boolean[] {true, true, false, true}; 
            borders[3][3] = new boolean[] {true, true, false, true};
            borders[3][4] = new boolean[] {true, true, false, true};

            borders[4][0] = new boolean[] {false, false, true, true};
            borders[4][1] = new boolean[] {true, true, true, false};
            borders[4][2] = new boolean[] {false, true, true, true}; 
            borders[4][3] = new boolean[] {false, true, true, true};
            borders[4][4] = new boolean[] {false, true, true, true};
            return borders;

        case 4:
            borders[0][0] = new boolean[] {true, false, true, true}; 
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, true, false};
            borders[0][4] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, false, false, true}; 
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {true, true, false, true};
            borders[1][3] = new boolean[] {true, true, false, true};
            borders[1][4] = new boolean[] {false, true, true, true}; 

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};  
            borders[2][2] = new boolean[] {false, true, true, true};
            borders[2][3] = new boolean[] {false, true, true, true};
            borders[2][4] = new boolean[] {true, true, false, true};

            borders[3][0] = new boolean[] {true, true, false, true}; 
            borders[3][1] = new boolean[] {false, true, true, true};
            borders[3][2] = new boolean[] {true, false, true, true}; 
            borders[3][3] = new boolean[] {true, true, true, false};
            borders[3][4] = new boolean[] {false, true, true, true};

            borders[4][0] = new boolean[] {false, true, true, true};
            borders[4][1] = new boolean[] {true, false, true, true};
            borders[4][2] = new boolean[] {true, true, true, false}; 
            borders[4][3] = new boolean[] {true, false, true, true};
            borders[4][4] = new boolean[] {true, true, true, false};
            return borders;

        case 5:
            borders[0][0] = new boolean[] {true, false, true, true}; 
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, true, false};
            borders[0][4] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {true, false, false, true}; 
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {true, false, true, true};
            borders[1][3] = new boolean[] {true, true, true, false};
            borders[1][4] = new boolean[] {false, true, true, true}; 

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};  
            borders[2][2] = new boolean[] {true, true, false, true};
            borders[2][3] = new boolean[] {true, false, true, true};
            borders[2][4] = new boolean[] {true, true, true, false};

            borders[3][0] = new boolean[] {true, true, false, true}; 
            borders[3][1] = new boolean[] {false, true, true, true};
            borders[3][2] = new boolean[] {false, true, true, true}; 
            borders[3][3] = new boolean[] {true, true, false, true};
            borders[3][4] = new boolean[] {true, true, false, true};

            borders[4][0] = new boolean[] {false, false, true, true};
            borders[4][1] = new boolean[] {true, false, true, false};
            borders[4][2] = new boolean[] {true, true, true, false}; 
            borders[4][3] = new boolean[] {false, true, true, true};
            borders[4][4] = new boolean[] {false, true, true, true};
            return borders;

        case 6:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, true, false, true};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, true, false};
            borders[0][4] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, false, true}; 
            borders[1][1] = new boolean[] {false, true, true, true};
            borders[1][2] = new boolean[] {true, false, true, true};
            borders[1][3] = new boolean[] {true, true, true, false};
            borders[1][4] = new boolean[] {false, true, true, true}; 

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};  
            borders[2][2] = new boolean[] {true, false, true, true};
            borders[2][3] = new boolean[] {true, true, true, false};
            borders[2][4] = new boolean[] {true, true, false, true};

            borders[3][0] = new boolean[] {true, true, false, true}; 
            borders[3][1] = new boolean[] {false, false, true, true};
            borders[3][2] = new boolean[] {true, true, true, false}; 
            borders[3][3] = new boolean[] {false, true, true, true};
            borders[3][4] = new boolean[] {false, true, true, true};

            borders[4][0] = new boolean[] {false, true, true, true};
            borders[4][1] = new boolean[] {true, false, true, true};
            borders[4][2] = new boolean[] {true, true, true, false}; 
            borders[4][3] = new boolean[] {false, true, true, true};
            borders[4][4] = new boolean[] {false, true, true, true};
            return borders;

        case 7:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, true, false, true};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, true, false};
            borders[0][4] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {false, true, true, true};
            borders[1][2] = new boolean[] {true, false, true, true};
            borders[1][3] = new boolean[] {true, true, true, false};
            borders[1][4] = new boolean[] {false, true, true, true}; 

            borders[2][0] = new boolean[] {true, false, true, true};
            borders[2][1] = new boolean[] {true, true, true, false};  
            borders[2][2] = new boolean[] {true, true, false, true};
            borders[2][3] = new boolean[] {true, false, true, true};
            borders[2][4] = new boolean[] {true, true, true, false};

            borders[3][0] = new boolean[] {true, false, true, true}; 
            borders[3][1] = new boolean[] {true, true, true, false};
            borders[3][2] = new boolean[] {false, true, true, true}; 
            borders[3][3] = new boolean[] {true, false, true, true};
            borders[3][4] = new boolean[] {true, true, true, false};

            borders[4][0] = new boolean[] {true, false, true, true};
            borders[4][1] = new boolean[] {true, true, true, false};
            borders[4][2] = new boolean[] {true, false, true, true}; 
            borders[4][3] = new boolean[] {true, false, true, false};
            borders[4][4] = new boolean[] {true, true, true, false};
            return borders;

        case 8:
            borders[0][0] = new boolean[] {true, false, true, true}; 
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, false, true, false};
            borders[0][4] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {true, true, false, true}; 
            borders[1][1] = new boolean[] {true, true, false, true};
            borders[1][2] = new boolean[] {true, false, true, true};
            borders[1][3] = new boolean[] {true, true, true, false};
            borders[1][4] = new boolean[] {true, true, false, true}; 

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {false, false, true, true};  
            borders[2][2] = new boolean[] {true, true, true, false};
            borders[2][3] = new boolean[] {true, true, false, true};
            borders[2][4] = new boolean[] {false, true, true, true};

            borders[3][0] = new boolean[] {true, false, true, true}; 
            borders[3][1] = new boolean[] {true, false, true, false};
            borders[3][2] = new boolean[] {true, true, true, false}; 
            borders[3][3] = new boolean[] {false, true, true, true};
            borders[3][4] = new boolean[] {true, true, false, true};

            borders[4][0] = new boolean[] {true, false, true, true};
            borders[4][1] = new boolean[] {true, true, true, false};
            borders[4][2] = new boolean[] {true, false, true, true}; 
            borders[4][3] = new boolean[] {true, true, true, false};
            borders[4][4] = new boolean[] {false, true, true, true};
            return borders;

        case 9:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, false, true, true};
            borders[0][4] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {true, true, false, true};
            borders[1][4] = new boolean[] {true, true, false, true}; 

            borders[2][0] = new boolean[] {true, false, true, true};
            borders[2][1] = new boolean[] {true, true, true, false};  
            borders[2][2] = new boolean[] {true, true, false, true};
            borders[2][3] = new boolean[] {false, true, true, true};
            borders[2][4] = new boolean[] {false, true, true, true};

            borders[3][0] = new boolean[] {true, true, false, true}; 
            borders[3][1] = new boolean[] {true, true, false, true};
            borders[3][2] = new boolean[] {false, true, true, true}; 
            borders[3][3] = new boolean[] {true, false, true, true};
            borders[3][4] = new boolean[] {true, true, false, false};

            borders[4][0] = new boolean[] {false, true, true, true};
            borders[4][1] = new boolean[] {false, true, true, true};
            borders[4][2] = new boolean[] {true, false, true, true}; 
            borders[4][3] = new boolean[] {true, true, true, false};
            borders[4][4] = new boolean[] {false, true, true, true};
            return borders;

        case 10:
            borders[0][0] = new boolean[] {true, false, true, true}; 
            borders[0][1] = new boolean[] {true, false, true, false};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, false, true, true};
            borders[0][4] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {true, false, true, true}; 
            borders[1][1] = new boolean[] {true, true, true, false};
            borders[1][2] = new boolean[] {true, true, false, true};
            borders[1][3] = new boolean[] {true, false, true, true};
            borders[1][4] = new boolean[] {true, true, true, false}; 

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {true, false, true, true};  
            borders[2][2] = new boolean[] {false, true, true, false};
            borders[2][3] = new boolean[] {true, false, true, true};
            borders[2][4] = new boolean[] {true, true, true, false};

            borders[3][0] = new boolean[] {false, false, true, true}; 
            borders[3][1] = new boolean[] {true, true, true, false};
            borders[3][2] = new boolean[] {true, true, false, true}; 
            borders[3][3] = new boolean[] {true, true, false, true};
            borders[3][4] = new boolean[] {true, true, false, true};

            borders[4][0] = new boolean[] {true, false, true, true};
            borders[4][1] = new boolean[] {true, true, true, false};
            borders[4][2] = new boolean[] {false, true, true, true}; 
            borders[4][3] = new boolean[] {false, true, true, true};
            borders[4][4] = new boolean[] {false, true, true, true};
            return borders;

        case 11:
            borders[0][0] = new boolean[] {true, true, false, true}; 
            borders[0][1] = new boolean[] {true, false, true, true};
            borders[0][2] = new boolean[] {true, true, true, false};
            borders[0][3] = new boolean[] {true, false, false, true};
            borders[0][4] = new boolean[] {true, true, true, false};

            borders[1][0] = new boolean[] {false, true, false, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {false, true, true, true};
            borders[1][4] = new boolean[] {true, true, false, true}; 

            borders[2][0] = new boolean[] {false, true, true, true};
            borders[2][1] = new boolean[] {true, true, false, true};  
            borders[2][2] = new boolean[] {true, true, false, true};
            borders[2][3] = new boolean[] {true, false, true, true};
            borders[2][4] = new boolean[] {false, true, true, false};

            borders[3][0] = new boolean[] {true, true, false, true}; 
            borders[3][1] = new boolean[] {false, true, false, true};
            borders[3][2] = new boolean[] {false, true, true, true}; 
            borders[3][3] = new boolean[] {true, true, false, true};
            borders[3][4] = new boolean[] {true, true, false, true};

            borders[4][0] = new boolean[] {false, true, true, true};
            borders[4][1] = new boolean[] {false, false, true, true};
            borders[4][2] = new boolean[] {true, true, true, false}; 
            borders[4][3] = new boolean[] {false, true, true, true};
            borders[4][4] = new boolean[] {false, true, true, true};
            return borders;

        case 12:
            borders[0][0] = new boolean[] {true, false, false, true}; 
            borders[0][1] = new boolean[] {true, true, true, false};
            borders[0][2] = new boolean[] {true, false, true, true};
            borders[0][3] = new boolean[] {true, true, true, false};
            borders[0][4] = new boolean[] {true, true, false, true};

            borders[1][0] = new boolean[] {false, true, true, true}; 
            borders[1][1] = new boolean[] {true, false, true, true};
            borders[1][2] = new boolean[] {true, true, true, false};
            borders[1][3] = new boolean[] {true, false, true, true};
            borders[1][4] = new boolean[] {false, true, true, false}; 

            borders[2][0] = new boolean[] {true, true, false, true};
            borders[2][1] = new boolean[] {true, false, true, true};  
            borders[2][2] = new boolean[] {true, true, true, false};
            borders[2][3] = new boolean[] {true, false, true, true};
            borders[2][4] = new boolean[] {true, true, true, false};

            borders[3][0] = new boolean[] {false, false, true, true}; 
            borders[3][1] = new boolean[] {true, true, true, false};
            borders[3][2] = new boolean[] {true, false, true, true}; 
            borders[3][3] = new boolean[] {true, true, true, false};
            borders[3][4] = new boolean[] {true, true, false, true};

            borders[4][0] = new boolean[] {true, false, true, true};
            borders[4][1] = new boolean[] {true, true, true, false};
            borders[4][2] = new boolean[] {true, false, true, true}; 
            borders[4][3] = new boolean[] {true, true, true, false};
            borders[4][4] = new boolean[] {false, true, true, true};
            return borders;

        default:
            return new boolean[size][size][4];
            
        }
    }

public static Color[][] getHardCellColors(int level) {
    int size = 6;
    Color[][] colors = new Color[size][size];

    switch (level) {
        case 1:
            colors = new Color[][] {
                { new Color(255, 240, 240), new Color(240, 255, 240), new Color(240, 240, 255), new Color(255, 250, 200), new Color(250, 200, 255), new Color(200, 250, 250) },
                { new Color(250, 230, 200), new Color(220, 250, 220), new Color(250, 220, 220), new Color(200, 230, 250), new Color(250, 200, 230), new Color(230, 250, 200) },
                { new Color(240, 200, 150), new Color(200, 240, 180), new Color(180, 200, 240), new Color(240, 220, 180), new Color(200, 220, 240), new Color(220, 240, 200) },
                { new Color(255, 230, 210), new Color(210, 255, 230), new Color(230, 210, 255), new Color(255, 200, 240), new Color(200, 255, 240), new Color(240, 200, 255) },
                { new Color(250, 240, 180), new Color(180, 250, 200), new Color(220, 250, 220), new Color(250, 220, 220), new Color(200, 230, 250), new Color(250, 200, 230) },
                { new Color(210, 210, 240), new Color(240, 210, 210), new Color(210, 240, 210), new Color(240, 240, 210), new Color(210, 240, 240), new Color(240, 210, 240) }
            };
            break;

        default:
            for (int r = 0; r < size; r++)
                for (int c = 0; c < size; c++)
                    colors[r][c] = Color.WHITE;
    }
    return colors;
}
}