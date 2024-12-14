package attendance.controller;

import attendance.model.Crew;
import attendance.model.Crews;
import attendance.model.Option;
import attendance.util.Validator;
import attendance.view.Input;
import attendance.view.Output;
import java.time.LocalTime;

public class Controller {
    public void start() {
        Crews crews = new Crews();

        while (true) {
            Output.printGreetings();
            Option option = new Option(Input.askOption());

            if (option.getOption().equals("1")) {
                Validator.validateClass();
                String name = Input.askAttendCheckName();
                Validator.validateCrewName(crews, name);
                String clockTime = Input.askAttendCheckTime();
                Validator.validateTimeFormat(clockTime);
                crews.updateCrewTime(name, clockTime);
                crews.checkAttend(name);
                Output.printCrewStatus(name, crews);
            }

            if (option.getOption().equals("2")) {
                String name = Input.askChangeCrewName();
                Validator.validateCrewName(crews, name);
                String day = Input.askChangeCrewDay();
                String time = Input.askChangeCrewTime();
                Validator.validateTimeFormat(time);
                Crew id = crews.findCrewDate(name, Integer.parseInt(day));
                Crew.changeTime(id, LocalTime.parse(time));
            }

            if (option.getOption().equals("3")) {
                String name = Input.askAttendCheckName();
                Validator.validateCrewName(crews, name);
                Output.printCrewAttendStatus(name, crews);
            }

            if (option.getOption().equals("4")) {
                Output.printCrewResult(crews);
            }

            if (option.equals("Q")) {
                break;
            }
        }
    }
}
