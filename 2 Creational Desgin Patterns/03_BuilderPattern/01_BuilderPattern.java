class House {

    //mandatory attribute
    String brick;
    String cement;
    String sand;

    //optional attribute
    String paint;
    String floor;
    String fridge;


    public static class HouseBuilder {

        // copy above attributes
        //mandatory attribute
        String brick;
        String cement;
        String sand;

        //optional attribute
        String paint;
        String floor;
        String fridge;

        //constructor with mandatory attribute
        public HouseBuilder(String brick, String cement, String sand) {
            this.brick = brick;
            this.cement = cement;
            this.sand = sand;
        }

        //setters for setting optional properties
        // returning this because so we can chain the method's
        public HouseBuilder setPaint(String paint) {
            this.paint = paint;
            return this;
        }

        public HouseBuilder setFloor(String floor) {
            this.floor = floor;
            return this;
        }

        public HouseBuilder setFridge(String fridge) {
            this.fridge = fridge;
            return this;
        }

        public House build() {

            return new House();
        }
    }
}