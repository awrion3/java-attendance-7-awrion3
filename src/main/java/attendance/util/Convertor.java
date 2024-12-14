package attendance.util;

import java.util.Arrays;
import java.util.List;

public class Convertor {
    public static List<String> splitToList(String input) {
        return Arrays.asList(input.split(" "));
    }
}
