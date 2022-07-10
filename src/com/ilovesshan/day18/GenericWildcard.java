package com.ilovesshan.day18;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */
public class GenericWildcard {
    public static void main(String[] args) {
        Test test = new Test();

        // 传入 任意类型
        test.inputAny(new AInterfaceImpl<Object>());
        test.inputAny(new AInterfaceImpl<AA>());
        test.inputAny(new AInterfaceImpl<BB>());
        test.inputAny(new AInterfaceImpl<CC>());
        test.inputAny(new AInterfaceImpl<Integer>());
        test.inputAny(new AInterfaceImpl<User>());



        // 传入 BB或者BB的子类

        // 错误
        //test.inputExtends(new AInterfaceImpl<AA>());

        // ok
        test.inputExtends(new AInterfaceImpl<BB>());
        test.inputExtends(new AInterfaceImpl<CC>());

        // 传入 BB或BB的父类

        // 错误
        // test.inputSuper(new AInterfaceImpl<CC>());

        // ok
        test.inputSuper(new AInterfaceImpl<Object>());
        test.inputSuper(new AInterfaceImpl<AA>());
        test.inputSuper(new AInterfaceImpl<BB>());


    }
}

class Test {
    // 传入 任意类型
    void inputAny(AInterface<?> aInterface) {
    }

    // 传入 BB或者BB的子类
    void inputExtends(AInterface<? extends BB> aInterface) {
    }


    // 传入 BB或BB的父类
    void inputSuper(AInterface<? super BB> aInterface) {
    }
}


class AA {
}

class BB extends AA {
}

class CC extends BB {
}

interface AInterface<T> {
}

class AInterfaceImpl<T> implements AInterface<T> {
}
