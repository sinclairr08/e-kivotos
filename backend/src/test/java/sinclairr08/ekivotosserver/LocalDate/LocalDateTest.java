package sinclairr08.ekivotosserver.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalDateTest {
    @Test
    public void testLocalDate() {
        LocalDate today = LocalDate.now();
        LocalDate local = LocalDate.parse("2023-05-05");

        assertThat(today.toEpochDay()).isGreaterThanOrEqualTo(19482);
        assertThat(local.toEpochDay()).isEqualTo(19482);
    }
}
