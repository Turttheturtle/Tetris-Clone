/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshu
 */
public class O extends Piece {

    public O() {
        points = new String[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = "&#9632";
            }

        }
        y = 0;
        x = 4;
    }

    public void rotateLeft(Board b) {
        //Havent Done
    }

    public void rotateRight(Board b) {
        //havent Done
    }
}
