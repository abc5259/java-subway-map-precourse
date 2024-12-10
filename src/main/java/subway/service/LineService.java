package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineService {

    private final StationService stationService;

    public LineService(StationService stationService) {
        this.stationService = stationService;
    }

    public void addLine(Line line) {
        stationService.validateExistStations(line.getStations());
        LineRepository.addLine(line);
    }
}
