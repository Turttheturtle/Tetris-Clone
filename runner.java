/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 694587
 */
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.Font;

public class runner {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris");
        JPanel tetris = new JPanel();
        String s = "S";
        JLabel label = new JLabel("s", JLabel.LEFT);
        JLabel hold = new JLabel("aaaaaaaaaaaa", JLabel.RIGHT);


        tetris.add(label);
        tetris.add(hold);

        frame.add(tetris);
        hold.setText("aaaaa");
        frame.setSize(1000, 1000);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        label.setText("s");
        ArrayList<Piece> randomizer = new ArrayList<>();
        randomizer.add(new L());
        randomizer.add(new J());
        randomizer.add(new S());
        randomizer.add(new Z());
        randomizer.add(new I());
        randomizer.add(new O());
        randomizer.add(new T());
        Board one = new Board();
        temp delete = new temp(one.falling);
        label.setText(convertToString(one.playingArea));
        
        label.setFont(new Font("Courier New", Font.BOLD, 30));
        hold.setFont(new Font("Courier New", Font.BOLD, 30));
        one.update(delete);
        label.setText(convertToString(one.playingArea));
        hold.setText(sideConvertToString(one));
        temp check = new temp(one.falling);

        frame.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                if (!gameOver(one)) {
                    if (e.getKeyCode() == KeyEvent.VK_P) {
                        if (one.paused == false) {
                            one.paused = true;
                        } else {
                            one.paused = false;
                        }
                    }
                    if (e.getKeyCode() == KeyEvent.VK_Z) {
                        one.remove(new temp(one.falling));

                        delete.change(one.falling);

                        one.falling.rotateLeft(one);
                        one.update(delete);
                        label.setText(convertToString(one.playingArea));
                        hold.setText(sideConvertToString(one));
                        check.change(one.falling);

                    }
                    if (e.getKeyCode() == KeyEvent.VK_X) {
                        one.remove(new temp(one.falling));
                        delete.change(one.falling);
                        one.falling.rotateRight(one);
                        one.update(delete);
                        label.setText(convertToString(one.playingArea));
                        hold.setText(sideConvertToString(one));
                        check.change(one.falling);
                    }

                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        if (one.falling.x > 0 && one.checkMove("Left")) {
                            delete.change(one.falling);
                            one.falling.x--;
                            one.update(delete);
                            label.setText(convertToString(one.playingArea));
                            hold.setText(sideConvertToString(one));
                            check.change(one.falling);
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                        if (one.falling.x < 10 - one.falling.points[0].length && one.checkMove("Right")) {
                            delete.change(one.falling);
                            one.falling.x++;
                            one.update(delete);
                            label.setText(convertToString(one.playingArea));
                            hold.setText(sideConvertToString(one));
                            check.change(one.falling);
                        }

                    } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        one.regularDropSpeed*=.97;
                        one.remove(new temp(one.falling));
                        delete.change(one.falling);
                        one.hardDrop();
                        one.update(delete);
                        one.falling = one.next;
                        if (gameOver(one)) {

                        } else {
                            if (one.randomizer.isEmpty()) {
                                one.randomizer.add(new L());
                                one.randomizer.add(new J());
                                one.randomizer.add(new S());
                                one.randomizer.add(new Z());
                                one.randomizer.add(new I());
                                one.randomizer.add(new O());
                                one.randomizer.add(new T());
                                one.randomizerCounter = 7;
                            }
                            one.randomSelection = (int) (Math.random() * one.randomizerCounter);
                            one.next = one.randomizer.get(one.randomSelection);
                            one.randomizer.remove(one.randomSelection);
                            one.randomizerCounter--;
                            one.addPiece();
                            one.deleteRows();
                            label.setText(convertToString(one.playingArea));
                            hold.setText(sideConvertToString(one));
                            check.change(one.falling);
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        one.holdKey = 200;

                    } else if (e.getKeyCode() == KeyEvent.VK_C) {
                        delete.change(one.falling);
                        one.hold();
                        one.update(delete);
                        label.setText(convertToString(one.playingArea));
                        hold.setText(sideConvertToString(one));
                        check.change(one.falling);
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    one.holdKey = 00;

                }
            }

        }
        );
        long dropTime = System.currentTimeMillis();

        while (!gameOver(one)) {
            while (!one.paused && !gameOver(one)) {

                if (one.holdKey > 100) {
                    one.dropSpeed = one.regularDropSpeed / 15;
                } else {
                    one.dropSpeed = one.regularDropSpeed;
                }

                if (System.currentTimeMillis() - dropTime > one.dropSpeed) {

                    while (one.stop() && !gameOver(one)) {//might have something wrong with this or the ghost peice for tspin triple and srs
                        if (check.x != one.falling.x || check.y != one.falling.y || check.points.length != one.falling.points.length || check.points[0].length != one.falling.points[0].length) {
                            dropTime = System.currentTimeMillis();

                        }
                        if (System.currentTimeMillis() - dropTime > 1000) {
                            if (one.stop()) {
                                one.regularDropSpeed*=.97;
                                one.falling = one.next;
                                if (one.randomizer.isEmpty()) {
                                    one.randomizer.add(new L());
                                    one.randomizer.add(new J());
                                    one.randomizer.add(new S());
                                    one.randomizer.add(new Z());
                                    one.randomizer.add(new I());
                                    one.randomizer.add(new O());
                                    one.randomizer.add(new T());
                                    one.randomizerCounter = 7;
                                }
                                one.randomSelection = (int) (Math.random() * one.randomizerCounter);
                                one.next = one.randomizer.get(one.randomSelection);
                                one.randomizer.remove(one.randomSelection);
                                one.randomizerCounter--;
                                one.deleteRows();
                                label.setText(convertToString(one.playingArea));
                                hold.setText(sideConvertToString(one));
                            }
                        }
                    }

                    if (!one.stop()) {
                        one.score+=5;
                        delete.change(one.falling);
                        one.falling.y++;
                        one.update(delete);
                        label.setText(convertToString(one.playingArea));
                        hold.setText(sideConvertToString(one));
                        dropTime = System.currentTimeMillis();
                        check.change(one.falling);
                    }
                }

            }
        }
        label.setVisible(false);
        hold.setVisible(false);
        JLabel end = new JLabel("Game Over", JLabel.CENTER);
        frame.remove(tetris);
        frame.add(end);
        end.setFont(new Font("Courier New", Font.BOLD, 30));
        end.setText("Game Over");

        System.out.println("xx");
    }

    public static boolean gameOver(Board b) {//random game over
        String check = "";
        String check2 = "";
        if (b.falling.y == 0) {
            for (int w = 0; w < b.falling.points[0].length; w++) {

                for (int i = 0; i < b.falling.points.length + 1; i++) {
                    check += b.playingArea[i][w + b.falling.x];
                    check2+="&#9632";
                }
                if(check.equals(check2)){
                    return true;
                }
                check="";
                check2="";
            }
        }
        return false;
//    if(b.falling.y<b.falling.points.length-1){
//        String[][] n = copyArray(b.playingArea);
//        for (int i = 0; i < b.falling.points[0].length; i++) {
//            for (int j = 0; j < b.falling.points.length; j++) {
//                if(n[j+1][i].equals("&#9632")){//make it so that it only checks last one
//                    return true;
//                }
//            }
//        }
//    }
//    return false;
//    String[][] n=copyArray(b.playingArea);
//    remove2(n,b);
//    int count=23;
//    for (int i = b.falling.x; i < b.falling.x+b.falling.points[0].length; i++) {
//        for (int j = 23; j >= 0; j--) {
//            if(n[j][i].equals("&#9632")){
//                count=j;
//            }
//        }
//        if(count-b.falling.points.length+1<0){
// 
//            return true;
//        }
//        count=23;
//    }
//    return false;
    }

    public static void remove2(String[][] n, Board b) {
        int q = b.falling.y;
        int w = b.falling.x;
        for (int i = 0; i < b.falling.points.length; i++) {
            for (int j = 0; j < b.falling.points[0].length; j++) {
                if (b.falling.points[i][j].equals("&#9632")) {
                    n[q][w] = "-";

                }
                w++;
            }
            w = b.falling.x;
            q++;
        }
    }

    public static String convertToString(String[][] board) {
        String s = "<html>";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                s += board[i][j];
                s += " ";

            }
            s += "<BR>";
        }
        s += "</html>";
        return s;
    }

    public static String sideConvertToString(Board b) {
        String s = "<html>";
        s+="&nbsp score = "+b.score;
        s+="<BR> <BR>";
        s += " &nbsp H o l d <BR>";
        s += " &nbsp ";
        for (int i = 0; i < b.hold.points.length; i++) {
            for (int j = 0; j < b.hold.points[0].length; j++) {
                if (b.hold.points[i][j].equals("&#9632")) {
                    s += b.hold.points[i][j];
                } else {
                    s += " &nbsp ";
                }
                s += " ";

            }
            s += "<BR>";
            s += " &nbsp ";
        }
        s += " <BR>  &nbsp ";
        s += "  N E X T <BR>";
        s += "  &nbsp ";
        for (int t = 0; t < b.next.points.length; t++) {
            for (int q = 0; q < b.next.points[0].length; q++) {

                if (b.next.points[t][q].equals("&#9632")) {
                    s += b.next.points[t][q];
                } else {
                    s += " &nbsp ";
                }
                s += " ";

            }
            s += "<BR>";
            s += "  &nbsp ";
        }
        s += "</html>";
        return s;
    }

    public static void addToBoard(String[][] b, I t) {
        int q = t.y;
        int w = t.x;
        for (int i = 0; i < t.points.length; i++) {
            for (int j = 0; j < t.points[0].length; j++) {
                b[q][w] = t.points[i][j];
                q++;
            }
            w++;
        }
    }

    public static void updateBoard(Board b, Piece p, temp t) {
        t.change(p);
        b.update(t);
        //Useless for now
    }

    public static String[][] copyArray(String[][] s) {
        String[][] n = new String[s.length][s[0].length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                n[i][j] = s[i][j];
            }
        }
        return n;
    }

}
