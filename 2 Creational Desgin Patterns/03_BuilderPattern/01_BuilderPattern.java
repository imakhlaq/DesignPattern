class House {

    // STEP => 1
    //mandatory attribute
    private String brick;
    private String cement;
    private String sand;

    // STEP => 2
    //optional attribute
    private String paint;
    private String floor;
    private String fridge;

    // STEP => 10
    //constructor that will get HouseBuilder object and using that object you set all the attributes.
    // HouseBuilder object will contain all the mandatory and optional attributes.
    // missing optional attributes will be NULL.
    private House(HouseBuilder houseBuilder) {
        this.brick = houseBuilder.brick;
        this.cement = houseBuilder.cement;
        this.sand = houseBuilder.sand;
        this.floor = houseBuilder.floor;
        this.paint = houseBuilder.paint;
        this.fridge = houseBuilder.fridge;
    }

    // STEP => 3
    public static class HouseBuilder {

        // STEP => 4
        // copy above attributes
        //mandatory attribute
        private String brick;
        private String cement;
        private String sand;

        // STEP => 5
        //optional attribute
        private String paint;
        private String floor;
        private String fridge;

        // STEP => 6
        //constructor with mandatory attribute
        public HouseBuilder(String brick, String cement, String sand) {
            this.brick = brick;
            this.cement = cement;
            this.sand = sand;
        }

        // STEP => 7
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

        // STEP => 8
        public House build() {

            //calling constructor of House with object of HouseBuilder (this refers to object of HouseBuilder)
            return new House(this); // this => HouseBuilder object
        }
        //this method can be called only when the object is created. And this keyword will
        //refer to that HouseBuilder object.
    }
}

class BuilderMain {
    public static void main(String[] args) {

        //building
        House house = new House.HouseBuilder("AKR", "Ambuja", "White").build();

    }
}