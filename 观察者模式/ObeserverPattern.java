import java.util.ArrayList;
import java.util.List;

public class ObeserverPattern {

    public class Subject {
        private List<Observer> observers = new ArrayList<Observer>();
        private int state;
        public int getState() {
            return state;
        }
        public void setState(int state) {
            this.state = state;
            notifyAllObservers();
        }
        public void attach(Observer observer){
            observers.add(observer);
        }
        public void notifyAllObservers(){
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }

    public abstract class Observer {
        protected Subject subject;
        public abstract void update();
    }

    public class BinaryObserver extends Observer{
        public BinaryObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }
        @Override
        public void update() {
            System.out.println( "Binary String: "+ Integer.toBinaryString(subject.getState()));
        }
    }

    public class OctalObserver extends Observer{
        public OctalObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }
        @Override
        public void update() {
            System.out.println( "Octal String: "+ Integer.toOctalString( subject.getState() ) );
        }
    }

    public class HexaObserver extends Observer{
        public HexaObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }
        @Override
        public void update() {
            System.out.println( "Hex String: "+ Integer.toHexString( subject.getState() ).toUpperCase() );
        }
    }

    public static void main(String [] args){
        ObeserverPattern op = new ObeserverPattern();
        Subject subject = op.new Subject();
        op.new HexaObserver(subject);
        op.new OctalObserver(subject);
        op.new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }

}
