/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshu
 */
public class temp {
            public String[][] points;
            public int x;
            public int y;
            public int orientation;
    public int[] place;
    public temp(Piece a){
        points= a.points;
        x=a.x;
        y=a.y;
    }
    public void change(Piece New){
        points= New.points;
        x=New.x;
        y=New.y;
        orientation=New.orientation;
    }
}
