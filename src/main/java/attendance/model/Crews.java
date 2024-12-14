package attendance.model;

import static attendance.view.Exception.INVALID_INPUT;

import attendance.util.Reader;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Crews {
    private List<Crew> crews = new ArrayList<>();

    public Crews() {
        initCrews();
    }

    private void initCrews() {
        Reader reader = new Reader();
        List<List<String>> resource = reader.readResource("attendances.csv");

        for (List<String> row : resource) {
            crews.add(new Crew(row));
        }
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

    private Crew findCrew(String name) {
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
