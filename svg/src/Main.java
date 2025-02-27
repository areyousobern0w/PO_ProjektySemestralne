public class Main {
    public static void main(String[] args) {
        Point point = new Point(5.5, 2.7);
        System.out.println(point.x + " " + point.y);
        System.out.println(point.toString());
        System.out.println(point.toSvg());
    }
}
