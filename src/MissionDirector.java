public class MissionDirector {

    public Mission moon() {
        return new MissionBuilder()
                .name("Moon One")
                .target("Moon")
                .crew(3)
                .days(14)
                .ship("Lunar")
                .rover(false)
                .radio("Basic Radio")
                .build();
    }

    public Mission mars() {
        return new MissionBuilder()
                .name("Mars One")
                .target("Mars")
                .crew(6)
                .days(300)
                .ship("Ares")
                .rover(true)
                .radio("Deep Space Radio")
                .build();
    }
}
