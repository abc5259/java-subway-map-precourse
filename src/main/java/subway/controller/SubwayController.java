package subway.controller;

import static subway.view.Command.ADD;
import static subway.view.Command.BACK;
import static subway.view.Command.REMOVE;

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

        SubwayRequest subwayRequest;
        do {
            outputView.printMenuList();
            subwayRequest = iteratorInputHandler.inputSubwayRequest();
            if (subwayRequest.getCommand() == BACK) {
                continue;
            }
            executeCommand(subwayRequest);
        } while (subwayRequest.getMenu() != Menu.QUIT);
    }

    private void executeCommand(SubwayRequest subwayRequest) {
        if (subwayRequest.getMenu() == Menu.STATION) {
            processStation(subwayRequest.getCommand());
        }
    }

    public void processStation(Command command) {
        if (command == ADD) {
            Station station = iteratorInputHandler.inputAddStation();
            stationService.addStation(station);
            return;
        }

        if (command == REMOVE) {

        }
    }
}
