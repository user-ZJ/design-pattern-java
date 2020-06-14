public class BuilderPattern {
    //产品类
    public class Bike {
        private String frame;
        private String seat;
        private String tire;

        public String getFrame() {
            return frame;
        }
        public void setFrame(String frame) {
            this.frame = frame;
        }
        public String getSeat() {
            return seat;
        }
        public void setSeat(String seat) {
            this.seat = seat;
        }
        public String getTire() {
            return tire;
        }
        public void setTire(String tire) {
            this.tire = tire;
        }
    }
    //Builder类
    public abstract class Builder {
        abstract void buildFrame();
        abstract void buildSeat();
        abstract void buildTire();
        abstract Bike createBike();
    }
    //ConcreteBuilder类
    public class MobikeBuilder extends Builder{
        private Bike mBike = new Bike();
        @Override
        void buildFrame() {
            mBike.setFrame("frameA");
        }
        @Override
        void buildSeat() {
            mBike.setSeat("seatA");
        }
        @Override
        void buildTire() {
            mBike.setTire("tireA");
        }
        @Override
        Bike createBike() {
            return mBike;
        }
    }
    public class OfoBuilder extends Builder{
        private Bike mBike = new Bike();
        @Override
        void buildFrame() {
            mBike.setFrame("frameB");
        }
        @Override
        void buildSeat() {
            mBike.setSeat("seatB");
        }
        @Override
        void buildTire() {
            mBike.setTire("tireB");
        }
        @Override
        Bike createBike() {
            return mBike;
        }
    }
    //指挥者类
    public class Director {
        private Builder mBuilder = null;
        public Director(Builder builder) {
            mBuilder = builder;
        }
        public Bike build() {
            mBuilder.buildFrame();
            mBuilder.buildSeat();
            mBuilder.buildTire();
            return mBuilder.createBike();
        }
    }
    public static void main(String [] args){
        BuilderPattern bp = new BuilderPattern();
        Director director = bp.new Director(bp.new MobikeBuilder());
        Bike bike = director.build();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
        System.out.println(bike.getTire());
    }

}
