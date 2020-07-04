public class StatePattern {
    public interface State {
        public void doAction(Context context);
    }

    public class StartState implements State {
        public void doAction(Context context) {
            System.out.println("Player is in start state");
            context.setState(this);
        }
        public String toString(){
            return "Start State";
        }
    }

    public class StopState implements State {
        public void doAction(Context context) {
            System.out.println("Player is in stop state");
            context.setState(this);
        }
        public String toString(){
            return "Stop State";
        }
    }

    public class Context {
        private State state;
        public Context(){
            state = null;
        }
        public void setState(State state){
            this.state = state;
        }
        public State getState(){
            return state;
        }
    }

    public static void main(String [] args){
        StatePattern sp = new StatePattern();
        Context context = sp.new Context();

        StartState startState = sp.new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = sp.new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
