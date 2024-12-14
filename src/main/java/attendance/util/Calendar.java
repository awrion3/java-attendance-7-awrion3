package attendance.util;

import attendance.model.Week;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;

public class Calendar {
    public static LocalDateTime checkToday() {
        return DateTimes.now();
    }

    public static int checkTodayYear() {
        return DateTimes.now().getYear();
    }

    public static int checkTodayMonth() {
        return DateTimes.now().getMonthValue();
    }

    public static int checkTodayDayOfMonth() {
        return DateTimes.now().getDayOfMonth();
    }

    public static String checkTodayDayOfWeek() {
        return Week.findWeek(DateTimes.now().getDayOfWeek());
    }
}
