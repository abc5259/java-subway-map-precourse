package subway.controller;


import subway.domain.Station;
import subway.view.Command;
import subway.view.InputView;
import subway.view.Menu;

public class IteratorInputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }

    public Station inputAddStation() {
        return iteratorInputTemplate.execute(
                inputView::inputAddStation,
                Station::new
        );
    }

    public Station inputRemoveStation() {
        return iteratorInputTemplate.execute(
                inputView::inputRemoveStation,
                Station::new
        );
    }

    public Menu inputMenuNumber() {
        return iteratorInputTemplate.execute(
                inputView::inputMenu,
                Menu::findMenu
        );
    }

    public Command inputCommand(Menu menu) {
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
