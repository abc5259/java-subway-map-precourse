package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public void addStation(Station station) {
        StationRepository.addStation(station);
    }

    public void removeStation(Station station) {
        validateRemoveStation(station);
        StationRepository.removeStation(station);
    }

    public List<Station> findAllStations() {
        return StationRepository.stations();
    }

    private void validateRemoveStation(Station station) {
        List<Line> lines = LineRepository.lines().stream()
                .filter(line -> line.containsStation(station))
                .collect(Collectors.toUnmodifiableList());

        if (!lines.isEmpty()) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }

    public void validateExistStations(List<Station> stations) {
        if (!StationRepository.existStations(stations)) {
            throw new IllegalArgumentException("존재하지 않는 역입니다.");
        }
    }
}
