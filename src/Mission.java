public class Mission {

    private String name;
    private String target;
    private int crew;
    private int days;
    private String ship;
    private boolean rover;
    private String radio;

    public Mission(MissionBuilder builder) {
        this.name = builder.name;
        this.target = builder.target;
        this.crew = builder.crew;
        this.days = builder.days;
        this.ship = builder.ship;
        this.rover = builder.rover;
        this.radio = builder.radio;
    }

    public String toString() {
        return "Mission: " + name +
               "\n  Target: " + target +
               "\n  Crew: " + crew +
               "\n  Days: " + days +
               "\n  Ship: " + ship +
               "\n  Rover: " + rover +
               "\n  Radio: " + radio;
    }
}
