package subway;

import subway.controller.IteratorInputHandler;
import subway.controller.IteratorInputTemplate;
import subway.controller.SubwayController;
import subway.init.SubwayInit;
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
        SubwayController subwayController = new SubwayController(inputView, outputView, iteratorInputHandler);
        subwayController.process();
    }
}
