/*
枚举
这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化
 */
public enum SingletonPattern6 {
    INSTANCE;
    public void doSomething() {
        System.out.println("doSomething");
    }
    /*
    public static void main(String[] args) {
        SingletonPattern6.INSTANCE.doSomething();
    }
    */
}

