package nextstep.ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PointTest {

    @ParameterizedTest(name = "포인트의 상태를 반환하는 기능 테스트")
    @ValueSource(booleans = {true, false})
    void getPointStatus(boolean value) {
        Point falsePoint = Point.of(value);
        Assertions.assertThat(falsePoint.isConnect()).isEqualTo(value);
    }
}
