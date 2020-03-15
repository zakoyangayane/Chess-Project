package chessboard;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Figure {
    int x;
    int y;
    public static Set<Figure> figureSet = new LinkedHashSet<>();

    public Figure(int x, int y) {
        if (x < 1 || x > 8 || y < 1 || y > 8) {
            throw new IllegalArgumentException("Coordinate out of bounds");
        }
        this.x = x;
        this.y = y;
        if (figureSet.contains(this)) {
            throw new IllegalArgumentException("This place is already occupied");
        }
        figureSet.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return x == figure.x &&
                y == figure.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
