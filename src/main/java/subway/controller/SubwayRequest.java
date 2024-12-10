package subway.controller;

import subway.view.Command;
import subway.view.Menu;

public class SubwayRequest {
    private Menu menu;
    private Command command;

    public SubwayRequest(Menu menu, Command command) {
        this.menu = menu;
        this.command = command;
    }

    public Menu getMenu() {
        return menu;
    }

    public Command getCommand() {
        return command;
    }
}
