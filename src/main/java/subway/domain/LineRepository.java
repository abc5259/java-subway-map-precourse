package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException("이미 존재하는 노선입니다.");
        }
        lines.add(line);
    }

    public static void addLines(List<Line> line) {
        lines.addAll(line);
    }

    public static void deleteLine(Line line) {
        lines.remove(line);
    }

    public static Line findLineByName(String name) {
        return lines.stream()
                .filter(line -> line.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 노선이 존재하지 않습니다."));
    }
}
