package subway.init;

import java.util.Arrays;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayInit {

    //교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역
    public void init() {
        StationRepository.addStations(
                Arrays.asList(
                        new Station("교대역"),
                        new Station("강남역"),
                        new Station("역삼역"),
                        new Station("남부터미널역"),
                        new Station("양재역"),
                        new Station("양재시민의숲역"),
                        new Station("매봉역")
                )
        );

        LineRepository.addLines(
                Arrays.asList(
                        new Line("2호선", Arrays.asList(
                                new Station("교대역"),
                                new Station("강남역"),
                                new Station("역삼역"))
                        ),
                        new Line("3호선", Arrays.asList(
                                new Station("교대역"),
                                new Station("남부터미널역"),
                                new Station("양재역"),
                                new Station("매봉역"))
                        ),
                        new Line("신분당선", Arrays.asList(
                                new Station("강남역"),
                                new Station("양재역"),
                                new Station("양재시민의숲역"))
                        )
                )
        );
    }
}
