package attendance.util;

import static attendance.view.Exception.INVALID_INPUT;
import static attendance.view.Exception.INVALID_NAME;

import attendance.model.Crews;
import attendance.view.Exception;

public class Validator {
    public static void validatePattern(String input) {
        if (!input.matches("^[1-4|Q]$")) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public static void validateClass() {
        if (Calendar.checkTodayDayOfWeek().equals("토")) {
            throw new IllegalArgumentException(Exception.formatMessage());
        }
        if (Calendar.checkTodayDayOfWeek().equals("일")) {
            throw new IllegalArgumentException(Exception.formatMessage());
        }
    }


    public static void validateCrewName(Crews crews, String name) {
        boolean isMatch = crews.getCrews()
                .stream()
                .anyMatch(crew -> crew.getName().equals(name));
        if (!isMatch) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
    }

    public static void validateTimeFormat(String time) {
        if (!time.matches("^[0-9]{2}:[0-9]{2}$")) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
    //try {
    //            return LocalDate.parse(time);
    //        } catch (DateTimeParseException e) {
    //           }
}
