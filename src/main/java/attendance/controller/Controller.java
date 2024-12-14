package attendance.controller;

import attendance.model.Crews;
import attendance.model.Option;
import attendance.util.Validator;
import attendance.view.Input;
import attendance.view.Output;

public class Controller {
    public void start() {

        // TODO 데이터 초기화
        Crews crews = new Crews();
//        while (true){
//            String reply = null;
//            if (reply.equals("Q"))
//                break;
//        }

        Output.printGreetings();
        Option option = new Option(Input.askOption());

//        for (Crew crew : crews.getCrews()) {
//            System.out.println(crew.getName());
//            System.out.println(crew.getTime());
//        }

        // TODO 1
        if (option.getOption().equals("1")) {
            String name = Input.askAttendCheckName();
            Validator.validateCrewName(crews, name);
            String clockTime = Input.askAttendCheckTime();
            Validator.validateTimeFormat(clockTime);
            crews.updateCrewTime(name, clockTime);
//            Output.
        }

    }
}
