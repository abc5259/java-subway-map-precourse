package subway.controller;


import java.util.ArrayList;
import java.util.Arrays;
import subway.converter.StringToIntConverter;
import subway.domain.Line;
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

    public Line inputLine() {
        String lineName = inputLineName();
        Station upboundStation = inputUpboundStation();
        Station downwardStation = inputDownwardStation();
        return new Line(lineName, new ArrayList<>(Arrays.asList(upboundStation, downwardStation)));
    }

    public Line inputRemoveLine() {
        return iteratorInputTemplate.execute(
                inputView::inputRemoveLine,
                Line::new
        );
    }

    public String inputLineName() {
        return iteratorInputTemplate.execute(
                inputView::inputLineName,
                name -> {
                    if (name == null || name.isBlank()) {
                        throw new IllegalArgumentException("이름을 입력하세요.");
                    }
                    return name;
                }
        );
    }

    private Station inputUpboundStation() {
        return iteratorInputTemplate.execute(
                inputView::inputUpboundStation,
                Station::new
        );
    }

    private Station inputDownwardStation() {
        return iteratorInputTemplate.execute(
                inputView::inputDownboundStation,
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

    public String inputStationName() {
        return iteratorInputTemplate.execute(
                inputView::inputStationName,
                name -> {
                    if (name == null || name.isBlank()) {
                        throw new IllegalArgumentException("이름을 입력하세요.");
                    }
                    return name;
                }
        );
    }

    public int inputLineStationNumber() {
        return iteratorInputTemplate.execute(
                inputView::inputLineStationNumber,
                new StringToIntConverter()
        );
    }
}
