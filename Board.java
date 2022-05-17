/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshu
 */
import java.util.ArrayList;

public class Board {

    public int score;
    public boolean paused;
    public int regularDropSpeed;
    public int dropSpeed;
    public String[][] playingArea;
    public Piece falling;
    public Piece next;
    public Piece hold;
    public int holdKey;
    public ArrayList<Piece> randomizer;
    public int randomSelection;
    public int randomizerCounter;
    public String check;
    public boolean state;

    public Board() {
        regularDropSpeed = 1000;
        score = 0;
        playingArea = new String[24][10];
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 10; j++) {

                playingArea[i][j] = "-";
            }
        }
        randomizer = new ArrayList<>();
        randomizer.add(new L());
        randomizer.add(new J());
        randomizer.add(new S());
        randomizer.add(new Z());
        randomizer.add(new I());
        randomizer.add(new O());
        randomizer.add(new T());
        randomizerCounter = 7;
        randomSelection = (int) (Math.random() * randomizerCounter);
        randomizerCounter--;
        falling = randomizer.get(randomSelection);
        randomizer.remove(randomSelection);
        randomSelection = (int) (Math.random() * randomizerCounter);
        randomizerCounter--;
        next = randomizer.get(randomSelection);
        randomizer.remove(randomSelection);
        dropSpeed = 1000;
        holdKey = 0;
        paused = false;
        check = "";
        hold = new Blank();
        state = true;
    }

    public void hold() {// reset the held peice position
        temp remove = new temp(falling);
        falling.x = 5;
        falling.y = 0;
        remove(remove);
        if (hold instanceof Blank) {

            hold = falling;
            falling = next;
            if (randomizer.isEmpty()) {
                randomizer.add(new L());
                randomizer.add(new J());
                randomizer.add(new S());
                randomizer.add(new Z());
                randomizer.add(new I());
                randomizer.add(new O());
                randomizer.add(new T());
                randomizerCounter = 7;
            }
            randomSelection = (int) (Math.random() * randomizerCounter);
            next = randomizer.get(randomSelection);
            randomizer.remove(randomSelection);
            randomizerCounter--;
            addPiece();
            if (hold instanceof I) {
                hold = new I();
            }
            if (hold instanceof J) {
                hold = new J();
            }
            if (hold instanceof L) {
                hold = new L();
            }
            if (hold instanceof O) {
                hold = new O();
            }
            if (hold instanceof S) {
                hold = new S();
            }
            if (hold instanceof T) {
                hold = new T();
            }
            if (hold instanceof Z) {
                hold = new Z();
            }
        } else {

            Piece a = hold;
            hold = falling;
            falling = a;

            addPiece();
            if (hold instanceof I) {
                hold = new I();
            }
            if (hold instanceof J) {
                hold = new J();
            }
            if (hold instanceof L) {
                hold = new L();
            }
            if (hold instanceof O) {
                hold = new O();
            }
            if (hold instanceof S) {
                hold = new S();
            }
            if (hold instanceof T) {
                hold = new T();
            }
            if (hold instanceof Z) {
                hold = new Z();
            }
        }

    }

    public boolean stop() {
        if (falling.y + falling.points.length == 24) {
            return true;
        }
        if (falling.x < 0) {
            return true;
        }
        for (int i = 0; i < falling.points[0].length; i++) {
            for (int j = 0; j < falling.points.length; j++) {
                if (falling.points[j][i].equals("&#9632")&& j == falling.points.length - 1 && playingArea[falling.y + j + 1][falling.x + i].equals("&#9632") || j != falling.points.length - 1 && falling.points[j][i].equals("&#9632") && !falling.points[j + 1][i].equals("&#9632") && playingArea[falling.y + j+1 ][falling.x + i].equals("&#9632")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteRows() {
        for (int e = 23; e > 0; e--) {

            for (int i = 0; i < 10; i++) {
                check += playingArea[e][i];
            }
            if (check.equals("&#9632&#9632&#9632&#9632&#9632&#9632&#9632&#9632&#9632&#9632")) {
                score += 1000;
                temp remove = new temp(falling);
                for (int i = e; i > 0; i--) {
                    for (int j = 0; j < playingArea[0].length; j++) {
                        remove(remove);
                        playingArea[i][j] = playingArea[i - 1][j];
                        addPiece();
                    }
                }
                e++;
            }
            check = "";
        }
    }

    public void hardDrop() {
        while (!stop()) {
            falling.y++;
        }
    }

    public boolean ghostStop(temp a) {
        if (a.y + a.points.length == 24) {
            return true;
        }
        int[] bottomPoints = new int[a.points[0].length];
        for (int i = 0; i < a.points[0].length; i++) {
            for (int j = 0; j < a.points.length; j++) {
                if (a.points[j][i].equals("&#9632")) {
                    bottomPoints[i] = j + a.y;
                }
            }
        }
        for (int i = 0; i < a.points[0].length; i++) {
            if (playingArea[bottomPoints[i] + 1][a.x + i].equals("&#9632")) {
                return true;
            }
        }
        return false;
    }

    public void addPiece() {
        int q = falling.y;
        int w = falling.x;
        for (int i = 0; i < falling.points.length; i++) {
            for (int j = 0; j < falling.points[0].length; j++) {
                if (falling.points[i][j].equals("&#9632")) {
                    playingArea[q][w] = falling.points[i][j];
                }
                w++;
            }
            w = falling.x;
            q++;
        }
    }

    public void update(temp a) {
        int count = 0;
        int q = a.y;
        int w = a.x;
        for (int i = 0; i < a.points.length; i++) {
            for (int j = 0; j < a.points[0].length; j++) {
                if (a.points[i][j].equals("&#9632")) {
                    playingArea[q][w] = "-";
                }
                w++;
            }
            w = a.x;
            q++;
        }
        while (!ghostStop(a)) {
            a.y++;
            count++;
        }
        q = a.y;
        w = a.x;
        for (int i = 0; i < a.points.length; i++) {
            for (int j = 0; j < a.points[0].length; j++) {
                if (a.points[i][j].equals("&#9632")) {
                    playingArea[q][w] = "-";
                }
                w++;
            }
            w = a.x;
            q++;
        }

        int count2 = 0;
        while (!stop()) {
            count2++;
            falling.y++;
        }
        falling.y -= count2;
        int e = falling.y + count2;
        int r = falling.x;
        if (falling.y != falling.y + count) {

            for (int i = 0; i < falling.points.length; i++) {
                for (int j = 0; j < falling.points[0].length; j++) {
                    if (falling.points[i][j].equals("&#9632")) {
                        playingArea[e][r] = "&#9633";
                    }
                    r++;
                }
                r = falling.x;
                e++;
            }
        }
        e = falling.y;
        r = falling.x;
        for (int i = 0; i < falling.points.length; i++) {
            for (int j = 0; j < falling.points[0].length; j++) {
                if (falling.points[i][j].equals("&#9632")) {
                    playingArea[e][r] = "&#9632";
                }
                r++;
            }
            r = falling.x;
            e++;
        }
    }

    public void remove(temp a) {
        int q = a.y;
        int w = a.x;
        for (int i = 0; i < a.points.length; i++) {
            for (int j = 0; j < a.points[0].length; j++) {
                if (falling.points[i][j].equals("&#9632")) {
                    playingArea[q][w] = "-";

                }
                w++;
            }
            w = a.x;
            q++;
        }
    }

    public boolean checkMove(String move) {//make both into for two for loops, sees the side of peice of full of boxes
        if (move.equals("Left") && falling.x > 0) {
            int lastIndex = 0;
            for (int i = 0; i < falling.points.length; i++) {
                for (int j = falling.points[0].length - 1; j >= 0; j--) {
                    if (falling.points[i][j].equals("&#9632")) {
                        lastIndex = j;
                    }
                }
                if (playingArea[falling.y + i][falling.x + lastIndex - 1].equals("&#9632")) {
                    return false;
                }
                lastIndex = 0;
            }
        } else if (move.equals("Right") && falling.x + falling.points[0].length - 1 < 9) {
            int lastIndex = 0;
            for (int i = 0; i < falling.points.length; i++) {
                for (int j = 0; j < falling.points[0].length; j++) {
                    if (falling.points[i][j].equals("&#9632")) {
                        lastIndex = j;
                    }
                }
                if (playingArea[falling.y + i][falling.x + lastIndex + 1].equals("&#9632")) {
                    return false;
                }
                lastIndex = 0;
            }
        }

        return true;
    }
}
