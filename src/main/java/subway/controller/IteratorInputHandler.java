package subway.controller;


import subway.view.Command;
import subway.view.InputView;
import subway.view.Menu;

public class IteratorInputHandler {

    private static final int MAX_MENU_NUMBER = 4;

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }

    public SubwayRequest inputSubwayRequest() {
        Menu menu = inputMenuNumber();
        if (menu.isNotExistCommand()) {
            return new SubwayRequest(menu, Command.NONE);
        }
        Command command = inputCommand(menu);
        return new SubwayRequest(menu, command);
    }

    private Menu inputMenuNumber() {
        return iteratorInputTemplate.execute(
                inputView::inputMenu,
                Menu::findMenu
        );
    }

    private Command inputCommand(Menu menu) {
        return iteratorInputTemplate.execute(
                () -> inputView.inputCommand(menu),
                (value) -> {
                    Command command = Command.findCommand(value);
                    if (!menu.isContainCommand(command)) {
                        throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
                    }
                    return command;
                }
        );
    }
}
