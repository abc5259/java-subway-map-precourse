package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public void addStation(Station station) {
        StationRepository.addStation(station);
    }
}
