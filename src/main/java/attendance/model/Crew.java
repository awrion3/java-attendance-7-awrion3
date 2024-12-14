package attendance.model;

import attendance.util.Convertor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Crew {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String Attend;

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

//    private void checkAttend(){
//        if ()
//    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
