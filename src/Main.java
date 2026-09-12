public class Main {

    public static void main(String[] args) {
        MissionDirector director = new MissionDirector();

        Mission m1 = director.moon();
        Mission m2 = director.mars();

        System.out.println("--- Director Missions ---");
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        Mission custom = new MissionBuilder()
                .name("Venus Probe")
                .target("Venus")
                .crew(2)
                .days(180)
                .ship("Atlas")
                .rover(false)
                .radio("Standard Radio")
                .build();

        System.out.println("--- Custom Mission ---");
        System.out.println(custom);
    }
}
