package subway.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final String INPUT_MENU_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_ADD_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_REMOVE_STATION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String INPUT_LINE_NAME_MESSAGE = "## 노선을 입력하세요.";
    private static final String INPUT_UNBOUND_STATION_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_DOWNWARD_STATION_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    public String inputMenu() {
        System.out.println();
        System.out.println(INPUT_MENU_MESSAGE);
        return readLine();
    }

    public String inputCommand(Menu menu) {
        System.out.println();
        System.out.println(menu.getCommandMessage());
        System.out.println();
        System.out.println(INPUT_MENU_MESSAGE);
        return readLine();
    }

    public String inputAddStation() {
        System.out.println();
        System.out.println(INPUT_ADD_STATION_MESSAGE);
        return readLine();
    }

    public String inputRemoveStation() {
        System.out.println();
        System.out.println(INPUT_REMOVE_STATION_MESSAGE);
        return readLine();
    }

    public String inputLineName() {
        System.out.println();
        System.out.println(INPUT_LINE_NAME_MESSAGE);
        return readLine();
    }

    public String inputUpboundStation() {
        System.out.println();
        System.out.println(INPUT_UNBOUND_STATION_MESSAGE);
        return readLine();
    }

    public String inputDownboundStation() {
        System.out.println();
        System.out.println(INPUT_DOWNWARD_STATION_MESSAGE);
        return readLine();
    }

    private String readLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
