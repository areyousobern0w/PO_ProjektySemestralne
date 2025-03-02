//Zadanie 1.
//Zdefiniuj klasę Point posiadającą dwa publiczne, zmiennoprzecinkowe pola - współrzędne x i y. Ustaw i wyświetl te pola.
//Stwórz bezargumentową metodę toString(), która zwraca informację o współrzędnych punktu za pomocą napisu.

public class Point {
    public double x;
    public double y;

    public String toString() {
        return ("(" + x + "; " + y + ")");
    }

    public String toSvg() {
        return ("<circle r=\"2\" cx=\"" + x + "\" cy=\"" + y + "\" fill=\"red\" />");
    }

    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public Point translated(double dx, double dy) {
        return new Point(x + dx, y + dy);
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
