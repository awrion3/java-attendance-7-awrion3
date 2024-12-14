package attendance.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String askOption() {
        return Console.readLine();
    }

    public static String askAttendCheckName() {
        System.out.println("닉네임을 입력해 주세요.");
        return Console.readLine();
    }

    public static String askAttendCheckTime() {
        System.out.println("등교 시간을 입력해 주세요.");
        return Console.readLine();
    }

}
