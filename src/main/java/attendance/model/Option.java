package attendance.model;

import attendance.util.Validator;

public class Option {
    private String option;

    public Option(String input) {
        Validator.validatePattern(input);
        option = input;
    }

    public String getOption() {
        return option;
    }
}
