package attendance.model;

import java.time.DayOfWeek;

public enum Week {
    MON("월", DayOfWeek.MONDAY),
    TUE("화", DayOfWeek.TUESDAY),
    WED("수", DayOfWeek.WEDNESDAY),
    THU("목", DayOfWeek.THURSDAY),
    FRI("금", DayOfWeek.FRIDAY),
    SAT("토", DayOfWeek.SATURDAY),
    SUN("일", DayOfWeek.SUNDAY);

    private String name;
    private DayOfWeek dayOfWeek;

    Week(String name, DayOfWeek dayOfWeek) {
        this.name = name;
        this.dayOfWeek = dayOfWeek;
    }

    public static String findWeek(DayOfWeek dayOfWeek) {
        Week week = null;
        for (Week day : Week.values()) {
            if (day.dayOfWeek == dayOfWeek) {
                week = day;
            }
        }
        return week.name;
    }

    public String getName() {
        return name;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    // Mon 1 ~ Sun 7
    public int getDayOfWeekValue() {
        return dayOfWeek.getValue();
    }
}
