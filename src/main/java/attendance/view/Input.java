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

    public static String askChangeCrewName() {
        System.out.println("출석을 수정하려는 크루의 닉네임을 입력해 주세요.");
        return Console.readLine();
    }

    public static String askChangeCrewDay() {
        System.out.println("수정하려는 날짜(일)를 입력해 주세요.");
        return Console.readLine();
    }

    public static String askChangeCrewTime() {
        System.out.println("언제로 변경하겠습니까?");
        return Console.readLine();
    }
}
