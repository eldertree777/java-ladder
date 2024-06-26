package nextstep.ladder.domain.user;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;
    private static final String INVALID_USERS_MESSAGE = "존재하지 않는 유저들의 객체 생성을 시도합니다";

    public Users(List<User> users) {
        if (users.isEmpty()) {
            throw new IllegalArgumentException(INVALID_USERS_MESSAGE);
        }

        this.users = users;
    }

    public Users(String... userNames) {
        this(Arrays.stream(userNames)
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public int getUserCount() {
        return users.size();
    }

    public List<String> getUserNames() {
        return Collections.unmodifiableList(
                users.stream()
                        .map(user -> user.getUserName())
                        .collect(Collectors.toList())
        );
    }
}
