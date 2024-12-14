package attendance.view;

import attendance.model.Crew;
import attendance.model.Week;
import attendance.util.Calendar;

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

    public static void printCrewStatus(Crew crew) {

    }

    private static void formatGreetings() {
        ;
    }
}
