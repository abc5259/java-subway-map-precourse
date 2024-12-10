package subway.service;

import java.util.List;
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

    public void removeLine(Line line) {
        if (!LineRepository.lines().contains(line)) {
            throw new IllegalArgumentException("존재하지 않는 노선입니다.");
        }
        LineRepository.deleteLine(line);
    }

    public List<Line> findAllLines() {
        return LineRepository.lines();
    }
}
