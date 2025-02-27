public class Main {
    public static Segment longestSegment(Segment[] arr) {
        double biggestLength = arr[0].length();
        int i = 1;
        int n = 0;
        for (Segment segment: arr) {
            if (arr[i].length() > biggestLength) {
                n = i;
                biggestLength = arr[i].length();
            }
            i++;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Point point = new Point(5.5, 2.7);
        System.out.println(point.x + " " + point.y);
        System.out.println(point.toString());
        System.out.println(point.toSvg());

        System.out.println(point);
        point.translate(2, 2);
        System.out.println(point);
        Point point1 = point.translated(2, 2);
        System.out.println(point1);

        Segment segment = new Segment();
        System.out.println(segment.length());
    }
}
