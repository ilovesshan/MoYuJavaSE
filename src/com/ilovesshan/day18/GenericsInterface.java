package com.ilovesshan.day18;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */
public class GenericsInterface {
    public static void main(String[] args) {
        MapperName<User> mapperName = new MapperName<>();
        User user = mapperName.returnThis(new User("ilovesshan", "@ilovesshan123456"));
        System.out.println(user.getName());


        // 传入的泛型类型是 User 在匿名内部类中 会进行自动类型的推断
        new Compare<User>() {

            @Override
            // User 类型是自动推断的
            public Integer compare(User t1, User t2) {
                return null;
            }
        };
    }
}


interface Compare<T> {
    Integer compare(T t1, T t2);
}


interface Mapper<T> {
    T returnThis(T t);
}

class MapperName<T> implements Mapper<T> {

    @Override
    public T returnThis(T t) {
        return t;
    }
}


class User {
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
