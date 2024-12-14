package attendance.model;

import attendance.util.Convertor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Crew {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String attend = "(결석)";

    //LocalDate date = LocalDate.of(year, month, dayOfMonth);
    //        LocalTime time = LocalTime.of(hour, minute);
    //        return new LocalDateTime(date, time);

    public Crew(List<String> token) {
        name = token.getFirst();
        List<String> tokens = Convertor.splitToList(token.getLast());
        date = LocalDate.parse(tokens.getFirst());
        time = LocalTime.parse(tokens.getLast());
//
//        time = LocalDateTime.parse(formatCheck(token.getLast()));
        // validateTokenPattern
        // splitToList

        // validateName .getFirst()
        // validateNumber .getLast()
    }

    public static void changeTime(Crew crew, LocalTime localTime) {
        crew.time = localTime;
    }

    public static void checkMonday(Crew crew) {
        if (crew.time.isBefore(LocalTime.parse("13:00"))) {
            crew.attend = "(출석)";
            return;
        }
        if (crew.time.equals(LocalTime.parse("13:00"))) {
            crew.attend = "(출석)";
            return;
        }
        if (crew.time.isAfter(LocalTime.parse("13:05"))) {
            crew.attend = "(지각)";
        }
        if (crew.time.isAfter(LocalTime.parse("13:30"))) {
            crew.attend = "(결석)";
        }
    }

    public static void checkOtherDay(Crew crew) {
        if (crew.time.isBefore(LocalTime.parse("10:00"))) {
            crew.attend = "(출석)";
            return;
        }
        if (crew.time.equals(LocalTime.parse("10:00"))) {
            crew.attend = "(출석)";
            return;
        }
        if (crew.time.isAfter(LocalTime.parse("10:05"))) {
            crew.attend = "(지각)";
        }
        if (crew.time.isAfter(LocalTime.parse("10:30"))) {
            crew.attend = "(결석)";
        }
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getAttend() {
        return attend;
    }
}
