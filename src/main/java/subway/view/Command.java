package subway.view;

import java.util.Arrays;

public enum Command {
    ADD("1"), REMOVE("2"), INFO("3"), BACK("B"), NONE(null);

    private final String symbol;

    Command(String symbol) {
        this.symbol = symbol;
    }

    public static Command findCommand(String symbol) {
        return Arrays.stream(Command.values())
                .filter(command -> command.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."));
    }
}
