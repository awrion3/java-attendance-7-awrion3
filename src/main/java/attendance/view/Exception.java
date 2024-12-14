package attendance.view;

import attendance.util.Calendar;

public class Exception {
    public static final String INVALID_INPUT = "[ERROR] 잘못된 형식을 입력하였습니다.";
    public static final String INVALID_NAME = "[ERROR] 등록되지 않은 닉네임입니다.";

    public static final String INVALID_FILE = "[ERROR] 존재하지 않는 파일입니다.";

    public static String formatMessage() {
        int month = Calendar.checkTodayMonth();
        int day = Calendar.checkTodayDayOfMonth();
        String dayOfWeek = Calendar.checkTodayDayOfWeek();
        return String.format("[ERROR] %d월 %d일 %s요일은 등교일이 아닙니다.", month, day, dayOfWeek);
    }
}
