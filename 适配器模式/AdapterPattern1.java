/**
 * 对象适配器：adaptee是adapter的成员
 */
public class AdapterPattern1 {
    public interface AC{
        int outputDC5V();
    }
    public class AC110Adaptee implements AC{
        public static final int voltage = 110;
        @Override
        public int outputDC5V() {
            System.out.println("使用JapanPowerAdapter变压适配器，输入AC:" + voltage + "V" );
            return voltage;
        }
    }
    public class AC220Adaptee implements AC{
        public static final int voltage = 220;
        @Override
        public int outputDC5V() {
            System.out.println("使用ChinaPowerAdapter变压适配器，输入AC:" + voltage + "V" );
            return voltage;
        }
    }

    public class ChinaPowerAdapter implements AC{
        AC ac;
        public ChinaPowerAdapter(AC adaptee) {
            ac = adaptee;
        }
        @Override
        public int outputDC5V() {
            return ac.outputDC5V();
        }
    }

    public class JapanPowerAdapter implements AC{
        AC ac;
        public JapanPowerAdapter(AC adaptee){
            ac = adaptee;
        }
        @Override
        public int outputDC5V() {
            return ac.outputDC5V();
        }
    }

    public static void main(String [] args){
        AdapterPattern1 ap1 = new AdapterPattern1();
        AC ac220 = ap1.new AC220Adaptee();
        ChinaPowerAdapter adapter = ap1.new ChinaPowerAdapter(ac220);
        adapter.outputDC5V();
    }

}
