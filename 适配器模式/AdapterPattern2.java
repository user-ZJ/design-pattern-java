/**
 * 类适配器,adapter继承adaptee
 */
public class AdapterPattern2 {
    public interface AC{
        int outputAC();
    }
    public class AC110 implements AC{
        public final int output = 110;
        @Override
        public int outputAC() {
            return output;
        }
    }
    public class AC220 implements AC{
        public final int output = 220;
        @Override
        public int outputAC() {
            return output;
        }
    }

    public interface DC5Adapter {
        boolean support(AC ac);
        int outputDC5V(AC ac);
    }

    public class ChinaPowerAdapter implements DC5Adapter{
        public static final int voltage = 220;
        @Override
        public boolean support(AC ac) {
            return voltage == ac.outputAC();
        }
        @Override
        public int outputDC5V(AC ac) {
            int adapterInput = ac.outputAC();
            int adapterOutput = adapterInput / 44;
            System.out.println("使用ChinaPowerAdapter变压适配器，输入AC:" + adapterInput + "V" + "，输出DC:" + adapterOutput + "V");
            return adapterOutput;
        }
    }

    public class JapanPowerAdapter implements DC5Adapter {
        public static final int voltage = 110;
        @Override
        public boolean support(AC ac) {
            return (voltage == ac.outputAC());
        }
        @Override
        public int outputDC5V(AC ac) {
            int adapterInput = ac.outputAC();
            //变压器...
            int adapterOutput = adapterInput / 22;
            System.out.println("使用JapanPowerAdapter变压适配器，输入AC:" + adapterInput + "V" + "，输出DC:" + adapterOutput + "V");
            return adapterOutput;
        }
    }

    public static void main(String [] args){
        AdapterPattern2 ap1 = new AdapterPattern2();
        AC chinaAC = ap1.new AC220();
        ChinaPowerAdapter adapter = ap1.new ChinaPowerAdapter();
        adapter.outputDC5V(chinaAC);
    }

}
