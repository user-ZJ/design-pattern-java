public class FactoryMethodPattern {

    public interface Phone {
        void make();
    }

    public class MiPhone implements Phone {
        public MiPhone() {
            this.make();
        }
        @Override
        public void make() {
            System.out.println("make xiaomi phone!");
        }
    }

    public class IPhone implements Phone {
        public IPhone() {
            this.make();
        }
        @Override
        public void make() {
            // TODO Auto-generated method stub
            System.out.println("make iphone!");
        }
    }

    public interface AbstractFactory {
        Phone makePhone();
    }

    public class XiaoMiFactory implements AbstractFactory{
        @Override
        public Phone makePhone() {
            return new MiPhone();
        }
    }
    public class AppleFactory implements AbstractFactory {
        @Override
        public Phone makePhone() {
            return new IPhone();
        }
    }

    public static void main(String[] arg) {
        FactoryMethodPattern fmp = new FactoryMethodPattern();
        AbstractFactory miFactory = fmp.new XiaoMiFactory();
        AbstractFactory appleFactory = fmp.new AppleFactory();
        miFactory.makePhone();            // make xiaomi phone!
        appleFactory.makePhone();        // make iphone!
    }

}
