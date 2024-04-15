package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.generator.RandomLineGenerator;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new RandomLineGenerator());
        ladderController.play();
    }
}
