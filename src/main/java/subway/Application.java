package subway;

import subway.controller.IteratorInputHandler;
import subway.controller.IteratorInputTemplate;
import subway.controller.SubwayController;
import subway.init.SubwayInit;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        SubwayInit subwayInit = new SubwayInit();
        subwayInit.init();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        IteratorInputTemplate iteratorInputTemplate = new IteratorInputTemplate(outputView);
        IteratorInputHandler iteratorInputHandler = new IteratorInputHandler(inputView, iteratorInputTemplate);
        StationService stationService = new StationService();
        LineService lineService = new LineService(stationService);
        SubwayController subwayController = new SubwayController(outputView, iteratorInputHandler, stationService,
                lineService);
        subwayController.process();
    }
}
