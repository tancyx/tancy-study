package com.tancy.desiginPattern.singleton;

public class LazySingletonSync {

    private static volatile LazySingletonSync lazySingletonSync=null;

    private LazySingletonSync() {
    }

    public static LazySingletonSync getInstance(){

        if (lazySingletonSync==null) {
            synchronized (LazySingletonSync.class) {
                if (lazySingletonSync == null)
                    lazySingletonSync = new LazySingletonSync();
            }
        }
        return lazySingletonSync;
    }

}
