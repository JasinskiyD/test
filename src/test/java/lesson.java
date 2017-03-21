import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.StringJoiner;

public class lesson {
    String boxName;
    Integer width;

    public lesson (int width, String boxName) {
        this.boxName = boxName;
    }

    public String getBox () {
        return boxName + " width " +width;
    }

    public static void main(String[] args) {

    }
}
