package nextstep.ladder;


import nextstep.ladder.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class UserTest {
    @ParameterizedTest
    @NullAndEmptySource
    void userEmptyTest(String name) {
        Assertions.assertThatThrownBy(() -> new User(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 유저명 입니다");
    }
}