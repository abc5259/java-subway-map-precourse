package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;
    private final IteratorInputHandler iteratorInputHandler;

    public SubwayController(InputView inputView, OutputView outputView, IteratorInputHandler iteratorInputHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.iteratorInputHandler = iteratorInputHandler;
    }

    public void process() {
        outputView.printMenuList();
        SubwayRequest subwayRequest = iteratorInputHandler.inputSubwayRequest();

    }
}
