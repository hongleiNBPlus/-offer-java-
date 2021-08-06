package com;

public class Test {
    public static void main(String[] args) {
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();

        System.out.println(order1 == order1);
    }
}

/**
 * 创建该类的单实例对象
 * 方式：饿汉式
 */
class User{
    //1、创建私有构造器
    private User() {
    }

    //2、创建内部私有静态对象
    private static User user = new User();

    //3创建公有静态方法来返回该类对象
    public static User getInstance(){
        return user;
    }
}


/**
 * 创建该类的单实例对象
 * 方式：懒汉式
 */
class Order{

    //1、创建私有构造器
    private Order(){

    }

    //2、创建私有静态类对象
    private static Order order = null;

    //3、创建静态方法返回该类对象
    public static Order getInstance(){
        if (order == null){
            order = new Order();
        }
        return order;
    }
}
