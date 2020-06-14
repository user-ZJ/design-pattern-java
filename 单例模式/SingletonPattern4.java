/*
双检锁/双重校验锁（DCL，即 double-checked locking）
这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
getInstance() 的性能对应用程序很关键。
 */
public class SingletonPattern4 {
    private volatile static SingletonPattern4 singleton;
    private SingletonPattern4 (){}
    public static SingletonPattern4 getSingleton() {
        if (singleton == null) {
            synchronized (SingletonPattern4.class) {
                if (singleton == null) {
                    singleton = new SingletonPattern4();
                }
            }
        }
        return singleton;
    }
}
