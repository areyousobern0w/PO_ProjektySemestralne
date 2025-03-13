import java.util.Locale;

public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final double strokeWidth;

    public Style(String fillColor, String strokeColor, double strokeWidth) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public String toSvg() {
        return String.format(Locale.US, " style=\"fill:%s;stroke:%s;stroke-width:%.2f />", fillColor, strokeColor, strokeWidth);
    }
}
//
//style="fill:lime;stroke:purple;stroke-width:5 />
