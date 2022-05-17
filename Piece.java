/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshu
 */
public abstract class Piece {
    public String[][] points;
    public int x;
    public int y;
    public int orientation;

    public abstract void rotateLeft(Board b);

    public abstract void rotateRight(Board b);

    public boolean stop(Board b) {
        int[] dif = new int[points[0].length];

        int q = y;
        int w = x;
        int z = 0;
        int d;
        int[] dif2 = new int[points[0].length];
        for (int i = 0; i < points[0].length; i++) {
            dif2[i] = 23;
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {

                for (int c = 23; c > y + points.length - 1; c--) {
                    if (b.playingArea[c][w].equals("&#9632")) {

                        dif2[j] = c - 1;

                    }
                }

                for (int t = 0; t < points[0].length; t++) {
                    for (int e = 0; e < points.length; e++) {
                        if (points[e][t].equals("&#9632")) {
                            dif[j] = e + y;
                        }
                    }
                }

                w++;
            }
            w = x;
            q++;
        }
        int smallest = dif2[0] - dif[0];
        for (int i = 1; i < points[0].length; i++) {;

            if (dif2[i] - dif[i] < smallest) {
                smallest = dif2[i] - dif[i];
            }
        }

        if (y + points.length - 1 == 23) {

            return true;
        }
        if (smallest == 0) {
            return true;
        } else {
            return false;
        }

    }

    public int[] srs1to2(Board b) {
        int[][] srsList = {{0, 0}, {-1, 0}, {-1, 1}, {0, -2}, {-1, -2}};
         boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
            check=true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                        if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") &&b.playingArea[y + i][x + j].equals("&#9632")) {
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
        int[][] srsList = {{0, 0}, {1, 0}, {1, -1}, {0, 2}, {1, 2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
check=true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                        if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 || points[i][j].equals("&#9632") &&b.playingArea[y + i][x + j].equals("&#9632")) {
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
        int[][] srsList = {{0, 0}, {1, 0}, {1, 1}, {0, -2}, {1, -2}};
         boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
check=true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                        if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 ||points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
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
        int[][] srsList = {{0, 0}, {-1, 0}, {-1, -1}, {0, 2}, {-1, 2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
check=true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                        if ( x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 ||points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
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
        int[][] srsList = {{0, 0}, {1, 0}, {1, -1}, {0, 2}, {1, 2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
check=true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                        if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 ||points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
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
        int[][] srsList = {{0, 0}, {-1, 0}, {-1, 1}, {0, -2}, {-1, -2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
check=true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                        if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 ||points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
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
        int[][] srsList = {{0, 0}, {-1, 0}, {-1, 1}, {0, 2}, {-1, 2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
check=true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                        if (x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 ||points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
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
        int[][] srsList = {{0, 0}, {1, 0}, {1, 1}, {0, -2}, {1, -2}};
        boolean check;
        check = true;
        for (int k = 0; k < srsList.length; k++) {
check=true;
            x += srsList[k][0];
            y -= srsList[k][1];

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {

                        if ( x < 0 || x > 10 - points[0].length || y > 24 - points.length || y < 0 ||points[i][j].equals("&#9632") && b.playingArea[y + i][x + j].equals("&#9632")) {
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

    public void hardDrop(Board b) {
        int[] dif = new int[points[0].length];
        int w = x;
        int[] dif2 = new int[points[0].length];
        for (int i = 0; i < points[0].length; i++) {
            dif2[i] = 23;
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {

                for (int c = 23; c > y + points.length - 1; c--) {
                    if (b.playingArea[c][w].equals("&#9632")) {

                        dif2[j] = c - 1;

                    }
                }

                for (int t = 0; t < points[0].length; t++) {
                    for (int e = 0; e < points.length; e++) {
                        if (points[e][t].equals("&#9632")) {
                            dif[j] = e + y;
                        }
                    }
                }

                w++;
            }
            w = x;
        }
        int smallest = dif2[0] - dif[0];
        for (int i = 1; i < points[0].length; i++) {;

            if (dif2[i] - dif[i] < smallest) {
                smallest = dif2[i] - dif[i];
            }
        }

        y += smallest;
        if (y + points.length > 23) {
            y = 23 - points.length + 1;
        }
    }
}
