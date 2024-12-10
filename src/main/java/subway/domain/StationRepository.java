package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 등록된 역입니다.");
        }
        stations.add(station);
    }

    public static void removeStation(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException("등록되지 않은 역입니다.");
        }
        stations.remove(station);
    }

    public static void addStations(List<Station> station) {
        stations.addAll(station);
    }

    public static boolean existStations(List<Station> station) {
        return stations.containsAll(station);
    }
}
