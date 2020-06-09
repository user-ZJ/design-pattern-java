public class SimpleFactoryPattern {
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

    public Phone makePhone(String phoneType) {
        if(phoneType.equalsIgnoreCase("MiPhone")){
            return new MiPhone();
        }
        else if(phoneType.equalsIgnoreCase("iPhone")) {
            return new IPhone();
        }
        return null;
    }

    public static void main(String[] arg) {
        SimpleFactoryPattern factory = new SimpleFactoryPattern();
        Phone miPhone = factory.makePhone("MiPhone");            // make xiaomi phone!
        IPhone iPhone = (IPhone)factory.makePhone("iPhone");    // make iphone!
    }

}
