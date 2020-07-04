import java.util.Date;

public class MediatorPattern {
    public class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(String name){
            this.name  = name;
        }

        public void sendMessage(String message){
            ChatRoom.showMessage(this,message);
        }
    }

    public static class ChatRoom {
        public static void showMessage(User user, String message){
            System.out.println(new Date().toString()
                    + " [" + user.getName() +"] : " + message);
        }
    }

    public static void main(String [] args){
        MediatorPattern mp = new MediatorPattern();
        User robert = mp.new User("Robert");
        User john = mp.new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
