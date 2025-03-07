package attendance.util;

import static attendance.common.Constant.DELIMITER_COMMA;
import static attendance.view.Exception.INVALID_FILE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public List<List<String>> readResource(String fileName) {
        try (InputStream resource = getClass()
                .getClassLoader()
                .getResourceAsStream(fileName)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            return convertResource(reader);
        } catch (IOException e) {
            throw new IllegalStateException(INVALID_FILE);
        }
    }

    private List<List<String>> convertResource(BufferedReader reader) throws IOException {
        List<List<String>> result = new ArrayList<>();
        validateFile(reader.readLine());
        String line;
        while ((line = reader.readLine()) != null) {
            List<String> row = Arrays.asList(line.split(DELIMITER_COMMA));
            result.add(row);
        }
        return result;
    }

    private void validateFile(String firstLine) {
        if (firstLine == null) {
            throw new IllegalStateException(INVALID_FILE);
        }
    }
}
