package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.result.LadderResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String BLANK = "     ";
    private static final String CONNECT_LINE = "-----";
    private static final String STRIPE = "|";

    public static void viewResult(LadderResult ladderResult) {
        StringBuilder resultBuilder = new StringBuilder()
                .append(RESULT_MESSAGE)
                .append(LINE_SEPARATOR)
                .append(LINE_SEPARATOR);

        ladderResult.getUserNames().forEach(userName -> resultBuilder.append(userName).append(BLANK));
        resultBuilder.append(LINE_SEPARATOR);
        resultBuilder.append(printLadder(ladderResult.getLines()));

        System.out.println(resultBuilder);
    }

    private static String printLadder(List<Line> lines) {
        return lines.stream()
                .map(line -> printLine(line))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private static String printLine(Line line) {
        return line.connectedStatus().stream()
                .map(point -> printPoint(point))
                .collect(Collectors.joining(STRIPE, BLANK + STRIPE, STRIPE));
    }

    private static String printPoint(Point point) {
        return point.isConnect() ? CONNECT_LINE : BLANK;
    }
}
