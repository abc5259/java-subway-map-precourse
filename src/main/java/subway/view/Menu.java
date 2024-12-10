package subway.view;

import static subway.view.Command.ADD;
import static subway.view.Command.BACK;
import static subway.view.Command.INFO;
import static subway.view.Command.REMOVE;

import java.util.Arrays;
import java.util.List;

public enum Menu {
    STATION("1",
            "## 역 관리 화면\n"
                    + "1. 역 등록\n"
                    + "2. 역 삭제\n"
                    + "3. 역 조회\n"
                    + "B. 돌아가기",
            List.of(ADD, REMOVE, INFO, BACK)),
    LINE("2",
            "## 노선 관리 화면\n"
                    + "1. 노선 등록\n"
                    + "2. 노선 삭제\n"
                    + "3. 노선 조회\n"
                    + "B. 돌아가기",
            List.of(ADD, REMOVE, INFO, BACK)),
    SECTION("3",
            "## 구간 관리 화면\n"
                    + "1. 구간 등록\n"
                    + "2. 구간 삭제\n"
                    + "B. 돌아가기",
            List.of(ADD, REMOVE, BACK)),
    MAP("4",
            null,
            null),
    QUIT("Q",
            null,
            null);

    private final String symbol;
    private final String commandMessage;
    private final List<Command> commands;

    Menu(String symbol, String commandMessage, List<Command> commands) {
        this.symbol = symbol;
        this.commandMessage = commandMessage;
        this.commands = commands;
    }

    public String getCommandMessage() {
        return commandMessage;
    }

    public boolean isContainCommand(Command command) {
        return commands.contains(command);
    }

    public boolean isNotExistCommand() {
        return commands == null;
    }

    public static Menu findMenu(String symbol) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."));
    }
}
