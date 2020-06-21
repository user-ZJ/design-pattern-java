import java.util.HashMap;

public class FlyweightPattern {
    public interface Shape {
        void draw();
    }
    public class Circle implements Shape {
        private String color;
        private int x;
        private int y;
        private int radius;

        public Circle(String color){
            this.color = color;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        @Override
        public void draw() {
            System.out.println("Circle: Draw() [Color : " + color
                    +", x : " + x +", y :" + y +", radius :" + radius);
        }
    }
    //创建一个工厂，生成基于给定信息的实体类的对象。
    public class ShapeFactory {
        private final HashMap<String, Shape> circleMap = new HashMap<>();

        public Shape getCircle(String color) {
            Circle circle = (Circle)circleMap.get(color);

            if(circle == null) {
                circle = new Circle(color);
                circleMap.put(color, circle);
                System.out.println("Creating circle of color : " + color);
            }
            return circle;
        }
    }

    private static final String colors[] =  { "Red", "Green", "Blue", "White", "Black" };
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }

    public static void main(String [] args){
        FlyweightPattern fp = new FlyweightPattern();
        ShapeFactory sf = fp.new ShapeFactory();
            for(int i=0; i < 20; ++i) {
                Circle circle = (Circle)sf.getCircle(getRandomColor());
                circle.setX(getRandomX());
                circle.setY(getRandomY());
                circle.setRadius(100);
                circle.draw();

        }
    }
}
