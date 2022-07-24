package com.ilovesshan.day22;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/24
 * @description:
 */
public class SingleTon {
    static SingleTon mSingleTon = new SingleTon();

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        return mSingleTon;
    }
}

class SingleTon1 {
    static SingleTon1 mSingleTon;

    private SingleTon1() {
    }

    public static SingleTon1 getInstance() {
        if (mSingleTon == null) {
            mSingleTon = new SingleTon1();
        }
        return mSingleTon;
    }
}


class SingleTon2 {
    private SingleTon2() {
    }

    public static SingleTon2 getInstance() {
        return SingleTon2InnerHolder.mSingleTon;
    }

    static class SingleTon2InnerHolder {
        static SingleTon2 mSingleTon = new SingleTon2();
    }
}


class SingleTon3 {
    private SingleTon3() {
    }

    public static SingleTon3 getInstance() {
        return SingleTon3InnerHolder.INSTANCE.mSingleTon3;
    }

    enum SingleTon3InnerHolder {
        INSTANCE;
        private final SingleTon3 mSingleTon3;

        SingleTon3InnerHolder() {
            mSingleTon3 = new SingleTon3();
        }
    }
}


class SingleTon4 {
    static SingleTon4 mSingleTon;

    private SingleTon4() {
    }

    public static SingleTon4 getInstance() {
        if (mSingleTon == null) {
            synchronized (SingleTon4.class) {
                if (mSingleTon == null) {
                    mSingleTon = new SingleTon4();
                }
            }
        }
        return mSingleTon;
    }
}
