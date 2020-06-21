public class BridgePattern {
    public abstract class Shape {
        Color color;
        public void setColor(Color color) {
            this.color = color;
        }

        public abstract void draw();
    }
    public class Circle extends Shape{
        public void draw() {
            color.bepaint("圆形");
        }
    }
    public class Rectangle extends Shape{

        public void draw() {
            color.bepaint("长方形");
        }

    }
    public class Square extends Shape{

        public void draw() {
            color.bepaint("正方形");
        }

    }

    public interface Color {
        public void bepaint(String shape);
    }
    public class White implements Color{
        public void bepaint(String shape) {
            System.out.println("白色的" + shape);
        }
    }
    public class Gray implements Color{

        public void bepaint(String shape) {
            System.out.println("灰色的" + shape);
        }
    }
    public class Black implements Color{

        public void bepaint(String shape) {
            System.out.println("黑色的" + shape);
        }
    }

    public static void main(String [] args){
        BridgePattern bp = new BridgePattern();
        //白色
        Color white = bp.new White();
        //正方形
        Shape square = bp.new Square();
        //白色的正方形
        square.setColor(white);
        square.draw();

        //长方形
        Shape rectange = bp.new Rectangle();
        rectange.setColor(white);
        rectange.draw();
    }
}
