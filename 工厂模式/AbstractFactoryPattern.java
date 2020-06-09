public class AbstractFactoryPattern {
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

    public interface PC {
        void make();
    }
    public class MiPC implements PC {
        public MiPC() {
            this.make();
        }
        @Override
        public void make() {
            // TODO Auto-generated method stub
            System.out.println("make xiaomi PC!");
        }
    }
    public class MAC implements PC {
        public MAC() {
            this.make();
        }
        @Override
        public void make() {
            // TODO Auto-generated method stub
            System.out.println("make MAC!");
        }
    }

    public interface AbstractFactory {
        Phone makePhone();
        PC makePC();
    }

    public class XiaoMiFactory implements AbstractFactory {
        @Override
        public Phone makePhone() {
            return new MiPhone();
        }
        @Override
        public PC makePC() {
            return new MiPC();
        }
    }
    public class AppleFactory implements AbstractFactory {
        @Override
        public Phone makePhone() {
            return new IPhone();
        }
        @Override
        public PC makePC() {
            return new MAC();
        }
    }

    public static void main(String[] arg) {
        AbstractFactoryPattern fmp = new AbstractFactoryPattern();
        AbstractFactory miFactory = fmp.new XiaoMiFactory();
        AbstractFactory appleFactory = fmp.new AppleFactory();
        miFactory.makePhone();            // make xiaomi phone!
        miFactory.makePC();
        appleFactory.makePhone();        // make iphone!
        appleFactory.makePC();
    }
}
