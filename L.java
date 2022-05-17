
public class L extends Piece {

    public L() {
        String[][] point = {
            {"-", "-", "&#9632"},
            {"&#9632", "&#9632", "&#9632"}
        };
        points = point;
        x = 3;
        y = 0;
        orientation = 1;
    }

    public void rotateRight(Board b) {
        b.remove(new temp(this));
        if (orientation == 1) {
            String[][] n = {
                {"&#9632", "-"},
                {"&#9632", "-"},
                {"&#9632", "&#9632"}
            };
            points = n;
            x++;
            orientation++;
            int[] srs = srs1to2(b);
            if (srs.length == 1) {
            String[][] q = {
                {"-", "-", "&#9632"},
                {"&#9632", "&#9632", "&#9632"}
            };
            points = q;
            x--;
            orientation--;
            }

        } else if (orientation == 2) {
            String[][] n = {
                {"&#9632", "&#9632", "&#9632"},
                {"&#9632", "-", "-"},};
            points = n;
            x--;
            y++;
            orientation++;
            int[] srs = srs2to3(b);
            if (srs.length == 1) {
            String[][] q = {
                {"&#9632", "-"},
                {"&#9632", "-"},
                {"&#9632", "&#9632"}
            };
            points = q;
            x++;
            y--;
            orientation--;
            }

        } else if (orientation == 3) {
            String[][] n = {
                {"&#9632", "&#9632"},
                {"-", "&#9632"},
                {"-", "&#9632"},
            };
            points = n;
            y--;
            orientation++;
            int[] srs = srs3to4(b);
            if (srs.length == 1) {
            String[][] q = {
                {"&#9632", "&#9632", "&#9632"},
                {"&#9632", "-", "-"},};
            points = q;
            y++;
            orientation--;
            }

        } else if (orientation == 4) {
            String[][] n = {
                {"-", "-", "&#9632"},
                {"&#9632", "&#9632", "&#9632"}
            };
            points = n;
            orientation = 1;
            int[] srs = srs4to1(b);
            if (srs.length == 1) {
            String[][] q = {
                {"&#9632", "&#9632"},
                {"-", "&#9632"},
                {"-", "&#9632"}
            };
            points = q;
            orientation = 4;
            }

        }
    }

    public void rotateLeft(Board b) {
        b.remove(new temp(this));
        if (orientation == 1) {
            String[][] n = {
                {"&#9632", "&#9632"},
                {"-", "&#9632"},
                {"-", "&#9632"}
            };
            points = n;
            orientation = 4;
            int[] srs = srs1to4(b);
            if (srs.length == 1) {
            String[][] q = {
                {"-", "-", "&#9632"},
                {"&#9632", "&#9632", "&#9632"}
            };
            points = q;
            orientation = 1;
            }

        } else if (orientation == 2) {
            String[][] n = {
                {"-", "-", "&#9632"},
                {"&#9632", "&#9632", "&#9632"}
            };
            points = n;
            x--;
            orientation--;
            int[] srs = srs2to1(b);
            if (srs.length == 1) {
            String[][] q = {
                {"&#9632", "-"},
                {"&#9632", "-"},
                {"&#9632", "&#9632"}
            };
            points = q;
            x++;
            orientation++;
            }

        } else if (orientation == 3) {
            String[][] n = {
                {"&#9632", "-"},
                {"&#9632", "-"},
                {"&#9632", "&#9632"}
            };
            points = n;
            x++;
            y--;
            orientation--;
            int[] srs = srs3to2(b);
            if (srs.length == 1) {
            String[][] q = {
                {"&#9632", "&#9632", "&#9632"},
                {"&#9632", "-", "-"},};
            points = q;
            x--;
            y++;
            orientation++;
            }

        } else if (orientation == 4) {
            String[][] n = {
                {"&#9632", "&#9632", "&#9632"},
                {"&#9632", "-", "-"},};
            points = n;
            y++;
            orientation--;
            int[] srs = srs4to3(b);
            if (srs.length == 1) {
            String[][] q = {
                {"&#9632", "&#9632"},
                {"-", "&#9632"},
                {"-", "&#9632"},
            };
            points = q;
            y--;
            orientation++;
            }
        }

    }

}
