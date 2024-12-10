package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_NAME_LENGTH = 2;

    private final String name;
    private final List<Station> stations;

    public Line(String name, List<Station> stations) {
        validateName(name);
        this.name = name.trim();
        this.stations = stations;
    }

    public Line(String name) {
        this(name, new ArrayList<>());
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("노선 이름은 2이상이어야합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public boolean containsStation(Station station) {
        return stations.contains(station);
    }

    public void insertStation(Station station, int number) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 존재하는 역입니다.");
        }

        int index = number - 1;

        if (stations.size() < index) {
            throw new IllegalArgumentException("해당 구간에 역을 추가할 수 없습니다.");
        }

        if (stations.size() == index) {
            stations.add(station);
            return;
        }

        stations.add(index, station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}
