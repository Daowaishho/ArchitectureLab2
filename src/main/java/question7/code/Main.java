package question7.code;

public class Main {
    public static void main(String[] args){
        EagerSingletonVirtualUserGenerator E1, E2;
        E1 = EagerSingletonVirtualUserGenerator.getInstance();
        E2 = EagerSingletonVirtualUserGenerator.getInstance();
        System.out.println("恶汉式单例测试结果"+ (E1 == E2));

        LazyLoadVirtualUserGenerator L1, L2;
        L1 = LazyLoadVirtualUserGenerator.getInstance();
        L2 = LazyLoadVirtualUserGenerator.getInstance();
        System.out.println("双重检测锁单例测试结果"+ (L1 == L2));

        IoDHVirtualUserGenerator I1, I2;
        I1 = IoDHVirtualUserGenerator.getInstance();
        I2 = IoDHVirtualUserGenerator.getInstance();
        System.out.println("IoDH测试结果"+ (I1 == I2));
    }
}

class EagerSingletonVirtualUserGenerator {
    private static EagerSingletonVirtualUserGenerator instance = new EagerSingletonVirtualUserGenerator();

    private EagerSingletonVirtualUserGenerator() {}

    synchronized public static EagerSingletonVirtualUserGenerator getInstance() {
        return instance;
    }
}

class LazyLoadVirtualUserGenerator {
    private volatile static LazyLoadVirtualUserGenerator instance = null;

    private LazyLoadVirtualUserGenerator() {}

    public static LazyLoadVirtualUserGenerator getInstance() {
        if (instance == null) {
            synchronized (LazyLoadVirtualUserGenerator.class) {
                if (instance == null) {
                    instance = new LazyLoadVirtualUserGenerator();
                }
            }
        }
        return instance;
    }
}

class IoDHVirtualUserGenerator {
    private IoDHVirtualUserGenerator() {}

    private static class HolderClass {
        private final static  IoDHVirtualUserGenerator instance = new IoDHVirtualUserGenerator();
    }

    public static IoDHVirtualUserGenerator getInstance() {
        return HolderClass.instance;
    }
}