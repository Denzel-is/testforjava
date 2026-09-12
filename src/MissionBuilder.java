public class MissionBuilder {

    String name;
    String target;
    int crew;
    int days;
    String ship;
    boolean rover;
    String radio;

    public MissionBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MissionBuilder target(String target) {
        this.target = target;
        return this;
    }

    public MissionBuilder crew(int crew) {
        this.crew = crew;
        return this;
    }

    public MissionBuilder days(int days) {
        this.days = days;
        return this;
    }

    public MissionBuilder ship(String ship) {
        this.ship = ship;
        return this;
    }

    public MissionBuilder rover(boolean rover) {
        this.rover = rover;
        return this;
    }

    public MissionBuilder radio(String radio) {
        this.radio = radio;
        return this;
    }

    public Mission build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Mission name is required");
        }
        if (target == null || target.isEmpty()) {
            throw new IllegalArgumentException("Mission target is required");
        }
        if (crew <= 0) {
            throw new IllegalArgumentException("Crew must be greater than 0");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than 0");
        }
        return new Mission(this);
    }
}
