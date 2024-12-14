package attendance.model;

import static attendance.view.Exception.INVALID_INPUT;

import attendance.util.Calendar;
import attendance.util.Reader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Crews {
    private List<Crew> crews = new ArrayList<>();

    public Crews() {
        initCrews();
        setupCrews();
    }

    private void initCrews() {
        Reader reader = new Reader();
        List<List<String>> resource = reader.readResource("attendances.csv");

        for (List<String> row : resource) {
            crews.add(new Crew(row));
        }
    }

//    //.equals(LocalDate.of

    /// /                        (Calendar.checkTodayYear(), Calendar.checkTodayMonth(), day)) / &&
    /// crew.getName().equals(name)
//    private boolean checkCrewAttendInfo(int day) {
//        return crews.stream()
//                .anyMatch(crew -> crew.getDate().equals(LocalDate.of
//                        (Calendar.checkTodayYear(), Calendar.checkTodayMonth(), day)));
//    }
    private void setupCrews() {
        List<Crew> crewsCopy = new ArrayList<>();
        crewsCopy.addAll(crews);
        for (Crew crew : crews) {
            for (int day = 1; day < Calendar.checkToday().getDayOfMonth(); day++) {
                if (crew.getDate().equals(LocalDate.of
                        (Calendar.checkTodayYear(), Calendar.checkTodayMonth(), day))) {
                    continue;
                }
                crewsCopy.addLast(new Crew(crew.getName()));
            }
        }
        crewsCopy.removeAll(crews);

        crews.addAll(crewsCopy);
    }

    public void updateCrewTime(String name, String time) {
        try {
            LocalTime clockTime = LocalTime.parse(time);
            Crew id = findCrew(name);
            Crew.changeTime(id, clockTime);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public void checkAttend(String name) {
        Crew crew = findCrew(name);
        if (Calendar.checkTodayDayOfWeek().equals("월")) {
            Crew.checkMonday(crew);
        }
        Crew.checkOtherDay(crew);
    }

    public Crew findCrew(String name) {
        Crew id = crews.stream()
                .filter(crew -> crew.getName().equals(name))
                .findAny()
                .orElse(null);
        return id;
    }

    public List<Crew> getCrews() {
        return crews;
    }
}
