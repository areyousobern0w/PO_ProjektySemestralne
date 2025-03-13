import java.util.Arrays;
import java.util.Locale;

public class Polygon extends Shape {
    // Prywatna tablica obiektów Point
    private Point[] points;
    // private Style style;

    // Konstruktor przyjmujący tablicę obiektów Point
    public Polygon(Point[] points, Style style) {
        super(style);

        if (style == null) {
            this.style = new Style("none", "black", 1.0);
        } else {
            this.style = style;
        }
        // this.points=points;

        // Konstruktor kopiujący, płytka kopia
        //this.points = Arrays.copyOf(points, points.length);

        // Konstruktor kopiujący, głęboka kopia
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point(points[i].getX(), points[i].getY());
        }
    }

    // Konstruktor kopiujący wykonujący głęboką kopię obiektu
    public Polygon(Polygon other) {
        super(other.style);

        this.points = new Point[other.points.length];
        for (int i = 0; i < other.points.length; i++) {
            this.points[i] = new Point(other.points[i].getX(), other.points[i].getY());
        }
        this.style = other.style;
    }

    public static Polygon square(Segment segment, Style style) {
        Segment[] diagonals = Segment.perpendicular(
                segment,
                new Point(((segment.getStart().getX() + segment.getEnd().getX()) / 2),
                        (segment.getStart().getY() + segment.getEnd().getY()) / 2),
                segment.length() / 2);

        Point p1, p2, p3, p4;
        p1 = segment.getStart();
        p2 = segment.getEnd();
        p3 = diagonals[0].getEnd();
        p4 = diagonals[1].getEnd();

        return new Polygon(new Point[] {p1, p2, p3, p4}, style);
    }

    // Metoda toString() zwracająca informacje o punktach wielokątu
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Polygon: [");
        for (Point point : points) {
            sb.append(point.toString()).append(", ");
        }
        if (points.length > 0) {
            sb.setLength(sb.length() - 2); // Usunięcie ostatniego przecinka
        }
        sb.append("]");
        return sb.toString();
    }

    // Metoda toSvg() zwracająca opis wielokąta w formacie SVG
    public String toSvg() {
        StringBuilder sb = new StringBuilder("<polygon points='");
        for (Point point : points) {
            sb.append(String.format(Locale.US, "%.2f,%.2f ", point.getX(), point.getY()));
        }
        if (points.length > 0) {
            sb.setLength(sb.length() - 1); // Usunięcie ostatniej spacji
        }
        sb.append(style.toSvg());
        return sb.toString();
    }

    public BoundingBox boundingBox() {
        if (points.length == 0) {
            return new BoundingBox(0, 0, 0, 0);
        }

        double minX = points[0].getX();
        double minY = points[0].getY();
        double maxX = points[0].getX();
        double maxY = points[0].getY();

        for (Point point : points) {
            if (point.getX() < minX) minX = point.getX();
            if (point.getY() < minY) minY = point.getY();
            if (point.getX() > maxX) maxX = point.getX();
            if (point.getY() > maxY) maxY = point.getY();
        }

        return new BoundingBox(minX, minY, maxX - minX, maxY - minY);
    }

    // Przykładowa metoda main do testowania
    public static void main(String[] args) {
        Point point = new Point();
        Point[] points = {point, new Point(10, 0), new Point(10, 10), new Point(0, 10)};
        Polygon polygon = new Polygon(points, null);

        System.out.println(polygon);
        System.out.println(polygon.toSvg());

        Polygon copiedPolygon = new Polygon(polygon);

        System.out.println(polygon);
        System.out.println(polygon.toSvg());
        System.out.println(copiedPolygon);
        System.out.println(copiedPolygon.toSvg());

        System.out.println();

        Segment seg1 = new Segment(new Point(0, 0), new Point(2, 2));
        System.out.println(Polygon.square(seg1, null));

//        points[0]=new Point(1.,1.);
//        System.out.println(polygon);
//        System.out.println(polygon.toSvg());
//        System.out.println(copiedPolygon);
//        System.out.println(copiedPolygon.toSvg());
//
//        point.translate(2.,0.);
//
//        System.out.println(polygon);
//        System.out.println(polygon.toSvg());
//        System.out.println(copiedPolygon);
//        System.out.println(copiedPolygon.toSvg());
    }
}
