package nextstep.ladder.controller;

import nextstep.ladder.domain.generator.LineGenerator;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.result.LadderResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {
    private final LineGenerator lineGenerator;

    public LadderController(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public void play() {
        Users users = new Users(InputView.inputUserNames());
        int ladderHeight = InputView.inputLadderHeight();

        ResultView.viewResult(new LadderResult(users, new Ladder(makeLines(users, ladderHeight))));
    }

    private List<Line> makeLines(Users users, int ladderHeight) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(lineGenerator.lineGenerate(users.getUserCount())));
        }
        return lines;
    }
}
