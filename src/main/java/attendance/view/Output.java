package attendance.view;

import attendance.model.Crew;
import attendance.model.Crews;
import attendance.model.Week;
import attendance.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    public static void printGreetings() {
        System.out.printf("오늘은 %d월 %d일 %s요일입니다. "
                        + "기능을 선택해 주세요.\n", Calendar.checkToday().getMonthValue(), Calendar.checkToday().getDayOfMonth(),
                Week.findWeek(Calendar.checkToday().getDayOfWeek()));
        System.out.printf("1. 출석 확인\n"
                + "2. 출석 수정\n"
                + "3. 크루별 출석 기록 확인\n"
                + "4. 제적 위험자 확인\n"
                + "Q. 종료\n");
    }

    public static void printCrewStatus(String name, Crews crews) {
        Crew id = crews.findCrew(name);
        int hour = id.getTime().getHour();
        int minute = id.getTime().getMinute();
        System.out.printf("%02d월 %02d일 %s요일",
                Calendar.checkTodayMonth(), Calendar.checkTodayDayOfMonth(), Calendar.checkTodayDayOfWeek());
        System.out.printf(" %02d:%02d %s\n", hour, minute, id.getAttend());
    }

    public static void printCrewAttendStatus(String name, Crews crews) {
        System.out.printf("이번 달 %s의 출석 기록입니다.\n", name);
        System.out.println();
        for (Crew crew : crews.getCrews()) {
            if (crew.getName().equals(name)) {
                int month = crew.getDate().getMonthValue();
                int day = crew.getDate().getDayOfMonth();
                String dayOfWeek = Week.findWeek(crew.getDate().getDayOfWeek());
                int hour = crew.getTime().getHour();
                int minute = crew.getTime().getMinute();
                System.out.printf("%02d월 %02d일 %s요일", month, day, dayOfWeek);
                System.out.printf(" %02d:%02d %s\n", hour, minute, crew.getAttend());
            }
        }
    }

    public static void printCrewResult(Crews crews) {
        System.out.println("제적 위험자 조회 결과");
        for (Crew crew : crews.getCrews()) {
            ;
        }
    }

    private static List<Crew> sortByAscend(Crews crews, String name) {
        return crews.getCrews()
                .stream()
                .filter(Crew -> Crew.getName().equals(name))
                .sorted(Comparator.comparing(Crew::getDate))
                .collect(Collectors.toList());
    }
}
