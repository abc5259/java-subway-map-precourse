package subway.controller;

import static subway.view.Command.ADD;
import static subway.view.Command.BACK;
import static subway.view.Command.INFO;
import static subway.view.Command.NONE;
import static subway.view.Command.REMOVE;

import java.util.List;
import subway.domain.Station;
import subway.service.StationService;
import subway.view.Command;
import subway.view.Menu;
import subway.view.OutputView;

public class SubwayController {

    private final OutputView outputView;
    private final IteratorInputHandler iteratorInputHandler;
    private final StationService stationService;

    public SubwayController(OutputView outputView,
                            IteratorInputHandler iteratorInputHandler,
                            StationService stationService) {
        this.outputView = outputView;
        this.iteratorInputHandler = iteratorInputHandler;
        this.stationService = stationService;
    }

    public void process() {

        Menu menu;
        do {
            outputView.printMenuList();
            menu = iteratorInputHandler.inputMenuNumber();
            iteratorExecuteRequest(menu);
        } while (menu != Menu.QUIT);
    }

    private void iteratorExecuteRequest(Menu menu) {
        while (true) {
            try {
                executeRequest(menu);
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private void executeRequest(Menu menu) {
        if (menu.isNotExistCommand()) {
            executeCommand(new SubwayRequest(menu, NONE));
            return;
        }
        Command command = iteratorInputHandler.inputCommand(menu);
        if (command == BACK) {
            return;
        }
        executeCommand(new SubwayRequest(menu, command));
    }

    private void executeCommand(SubwayRequest subwayRequest) {
        if (subwayRequest.getMenu() == Menu.STATION) {
            processStation(subwayRequest.getCommand());
        }

        if (subwayRequest.getMenu() == Menu.QUIT) {
            return;
        }
    }

    public void processStation(Command command) {
        if (command == ADD) {
            Station station = iteratorInputHandler.inputAddStation();
            stationService.addStation(station);
            return;
        }

        if (command == REMOVE) {
            Station station = iteratorInputHandler.inputRemoveStation();
            stationService.removeStation(station);
            return;
        }

        if (command == INFO) {
            List<Station> allStations = stationService.findAllStations();
            outputView.printStations(allStations);
        }
    }
}
