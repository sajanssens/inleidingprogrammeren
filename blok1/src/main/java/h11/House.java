package h11;

public class House {

    private Room bedRoom1;
    private Room bedRoom2;

    public House() {
        bedRoom1 = new Room("Papa en mama");
        bedRoom2 = new Room("Kinderen");
    }

    private class Room {
        String name;

        public Room(String name) {
            this.name = name;
        }
    }
}
