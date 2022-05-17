/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 694587
 */
/**
 *
 * @author 694587
 */
public class I extends Piece {// needs different srs

    public I() {
        String[][] n = {{"&#9632", "&#9632", "&#9632", "&#9632"}};
        points = n;
        y = 0;
        x = 3;
        orientation = 1;
    }

    public void rotateRight(Board b) {
        //wierd rotation

        if (orientation == 1) {
            String[][] n = {
                {"&#9632"},
                {"&#9632"},
                {"&#9632"},
                {"&#9632"}
            };
            points = n;
            x += 2;
            y--;
            orientation++;
            int[] srs = srs1to2(b);
            x += srs[0];
            y -= srs[1];
        } else if (orientation == 2) {
            String[][] n = {{"&#9632", "&#9632", "&#9632", "&#9632"}};
            points = n;
            x -= 2;
            y += 2;
            orientation++;
        } else if (orientation == 3) {
            String[][] n = {
                {"&#9632"},
                {"&#9632"},
                {"&#9632"},
                {"&#9632"}
            };
            points = n;
            x++;
            y -= 2;
            orientation++;
        } else if (orientation == 4) {
            String[][] n = {{"&#9632", "&#9632", "&#9632", "&#9632"}};
            points = n;
            x--;
            y++;
            orientation = 1;
        }
        if (x < 0) {
            x = 0;
        } else if (x > 6) {
            x = 6;
        }
        if (y < 0) {
            y = 0;
        } else if (y > 20) {
            y = 20;
        }

    }

    public void rotateLeft(Board b) {
        if (orientation == 1) {
            String[][] n = {
                {"&#9632"},
                {"&#9632"},
                {"&#9632"},
                {"&#9632"}
            };
            points = n;
            x += 1;
            y--;
            orientation = 4;
        } else if (orientation == 2) {
            String[][] n = {{"&#9632", "&#9632", "&#9632", "&#9632"}};
            points = n;
            x -= 2;
            y += 1;
            orientation--;
        } else if (orientation == 3) {
            String[][] n = {
                {"&#9632"},
                {"&#9632"},
                {"&#9632"},
                {"&#9632"}
            };
            points = n;
            x += 2;
            y -= 2;
            orientation--;
        } else if (orientation == 4) {
            String[][] n = {{"&#9632", "&#9632", "&#9632", "&#9632"}};
            points = n;
            x--;
            y += 2;
            orientation--;
        }
        if (x < 0) {
            x = 0;
        } else if (x > 6) {
            x = 6;
        }
        if (y < 0) {
            y = 0;
        } else if (y > 20) {
            y = 20;
        }
    }

    public int[] srs1to2(Board b) {
        int[][] srsList = {{0, 0}, {-2, 0}, {1, 0}, {-2, -1}, {1, 2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
            check = true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                    if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
                        check = false;

                    }

                }

            }
            if (check) {
                return srsList[k];
            }
            x -= srsList[k][0];
            y += srsList[k][1];
        }
        int[] nothing = {0};
        return nothing;
    }

    public int[] srs2to3(Board b) {
        int[][] srsList = {{0, 0}, {-1, 0}, {2, 0}, {-1, 2}, {2, -1}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
            check = true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                    if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
                        check = false;

                    }

                }

            }
            if (check) {
                return srsList[k];
            }
            x -= srsList[k][0];
            y += srsList[k][1];
        }
        int[] nothing = {0};
        return nothing;
    }

    public int[] srs3to4(Board b) {
        int[][] srsList = {{0, 0}, {2, 0}, {-1, 0}, {2, 1}, {-1, -2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
            check = true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                    if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
                        check = false;

                    }

                }

            }
            if (check) {
                return srsList[k];
            }
            x -= srsList[k][0];
            y += srsList[k][1];
        }
        int[] nothing = {0};
        return nothing;
    }

    public int[] srs4to1(Board b) {
        int[][] srsList = {{0, 0}, {1, 0}, {-2, 0}, {1, -2}, {-2, 1}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
            check = true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                    if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
                        check = false;

                    }

                }

            }
            if (check) {
                return srsList[k];
            }
            x -= srsList[k][0];
            y += srsList[k][1];
        }
        int[] nothing = {0};
        return nothing;
    }

    public int[] srs2to1(Board b) {
        int[][] srsList = {{0, 0}, {2, 0}, {-1, 0}, {2, 1}, {-1, -2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
            check = true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                    if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
                        check = false;

                    }

                }

            }
            if (check) {
                return srsList[k];
            }
            x -= srsList[k][0];
            y += srsList[k][1];
        }
        int[] nothing = {0};
        return nothing;
    }

    public int[] srs3to2(Board b) {
        int[][] srsList = {{0, 0}, {1, 0}, {-2, 0}, {1, -2}, {-2, 1}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
            check = true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                    if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
                        check = false;

                    }

                }

            }
            if (check) {
                return srsList[k];
            }
            x -= srsList[k][0];
            y += srsList[k][1];
        }
        int[] nothing = {0};
        return nothing;
    }

    public int[] srs4to3(Board b) {
        int[][] srsList = {{0, 0}, {-2, 0}, {1, 0}, {-2, -1}, {1, 2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
            check = true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                    if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
                        check = false;

                    }

                }

            }
            if (check) {
                return srsList[k];
            }
            x -= srsList[k][0];
            y += srsList[k][1];
        }
        int[] nothing = {0};
        return nothing;
    }

    public int[] srs1to4(Board b) {
        int[][] srsList = {{0, 0}, {-1, 0}, {2, 0}, {-1, 2}, {2, -1}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
            check = true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                    if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
                        check = false;

                    }

                }

            }
            if (check) {
                return srsList[k];

            }

            x -= srsList[k][0];
            y += srsList[k][1];
        }
        int[] nothing = {0};
        return nothing;
    }
}
