package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";
    private static final String STATION_OUTPUT_HEADER = "## 역 목록";
    private static final String STATION_FORMAT = "[INFO] %s%n";
    private static final String LINE_OUTPUT_HEADER = "## 노선 목록";
    private static final String LINE_FORMAT = "[INFO] %s%n";

    private static final String MENU_LIST = "## 메인 화면\n"
            + "1. 역 관리\n"
            + "2. 노선 관리\n"
            + "3. 구간 관리\n"
            + "4. 지하철 노선도 출력\n"
            + "Q. 종료";

    public void printMenuList() {
        System.out.println(MENU_LIST);
    }

    public void printStations(List<Station> stations) {
        System.out.println(STATION_OUTPUT_HEADER);
        stations.forEach(station -> System.out.printf(STATION_FORMAT, station.getName()));
        System.out.println();
    }

    public void printAddStationMessage() {
        printEmptyLine();
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
        printEmptyLine();
    }

    public void printRemoveStationMessage() {
        printEmptyLine();
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
        printEmptyLine();
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }

    public void printAddLineMessage() {
        printEmptyLine();
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
        printEmptyLine();
    }

    public void printRemoveLineMessage() {
        printEmptyLine();
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
        printEmptyLine();
    }

    public void printLines(List<Line> lines) {
        System.out.println(LINE_OUTPUT_HEADER);
        lines.forEach(line -> System.out.printf(LINE_FORMAT, line.getName()));
        printEmptyLine();
    }

    public void printAddLineStation() {
        printEmptyLine();
        System.out.println("[INFO] 구간이 등록되었습니다.");
        printEmptyLine();
    }

    public void printRemoveLineStation() {
        printEmptyLine();
        System.out.println("[INFO] 구간이 삭제되었습니다.");
        printEmptyLine();
    }

    public void printMap(List<Line> lines) {
        System.out.println("## 지하철 노선도");
        lines.forEach(line -> {
            System.out.printf(LINE_FORMAT, line.getName());
            System.out.println("[INFO] ---");
            line.getStations().forEach(station -> System.out.printf(STATION_FORMAT, station.getName()));
            printEmptyLine();
        });
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
