public class Segment {
    public Point point1 = new Point(2, 4);
    public Point point2 = new Point(8, 10);

    double length() {
        return (Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2)));
    }
}
