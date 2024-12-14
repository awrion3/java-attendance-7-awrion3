package attendance.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrewsTest {
    @DisplayName("기능 테스트: 크루들 초기화 확인")
    @Test
    void check_init_execution() {
        Crews crews = new Crews();

        assertFalse(crews.getCrews().isEmpty());
    }
}
