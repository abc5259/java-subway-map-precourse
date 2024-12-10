package subway.init;

import java.util.List;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayInit {

    //교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역
    public void init() {
        StationRepository.addStations(
                List.of(
                        new Station("교대역"),
                        new Station("강남역"),
                        new Station("역삼역"),
                        new Station("남부터미널역"),
                        new Station("양재역"),
                        new Station("양재시민의숲역"),
                        new Station("매봉역")
                )
        );
    }
}
