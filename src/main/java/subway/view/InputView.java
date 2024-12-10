package subway.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final String INPUT_MENU_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_ADD_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";

    public String inputMenu() {
        System.out.println(INPUT_MENU_MESSAGE);
        return readLine();
    }

    public String inputCommand(Menu menu) {
        System.out.println();
        System.out.println(menu.getCommandMessage());
        return readLine();
    }

    public String inputAddStation() {
        System.out.println(INPUT_ADD_STATION_MESSAGE);
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
