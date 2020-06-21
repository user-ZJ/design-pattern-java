public class DecoratorPattern {
    public interface Shape {
        void draw();
    }
    public class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Shape: Rectangle");
        }
    }
    public class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Shape: Circle");
        }
    }
    //创建实现了 Shape 接口的抽象装饰类
    public abstract class ShapeDecorator implements Shape {
        protected Shape decoratedShape;
        public ShapeDecorator(Shape decoratedShape){
            this.decoratedShape = decoratedShape;
        }
        @Override
        public void draw(){
            decoratedShape.draw();
        }
    }
    //创建扩展了 ShapeDecorator 类的实体装饰类。
    public class RedShapeDecorator extends ShapeDecorator {
        public RedShapeDecorator(Shape decoratedShape) {
            super(decoratedShape);
        }
        @Override
        public void draw() {
            decoratedShape.draw();
            setRedBorder(decoratedShape);
        }

        private void setRedBorder(Shape decoratedShape){
            System.out.println("Border Color: Red");
        }
    }

    public static void main(String [] args){
        DecoratorPattern dp = new DecoratorPattern();
        Shape circle = dp.new Circle();
        ShapeDecorator redCircle = dp.new RedShapeDecorator(dp.new Circle());
        ShapeDecorator redRectangle = dp.new RedShapeDecorator(dp.new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
