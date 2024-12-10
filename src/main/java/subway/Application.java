package subway;

import subway.controller.IteratorInputHandler;
import subway.controller.IteratorInputTemplate;
import subway.controller.SubwayController;
import subway.init.SubwayInit;
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
        SubwayController subwayController = new SubwayController(outputView, iteratorInputHandler, stationService);
        subwayController.process();
    }
}
