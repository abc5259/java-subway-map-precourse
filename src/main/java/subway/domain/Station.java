package subway.domain;

import java.util.Objects;

public class Station {
    private static final int MIN_NAME_LENGTH = 2;

    private String name;

    public Station(String name) {
        validateName(name);
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 역 이름은 2이상이어야합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Station station = (Station) o;
        return Objects.equals(getName(), station.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
