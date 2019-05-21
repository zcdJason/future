package com.future.SixPrinciple;

/**
 * Created by zcd on 2019-05-21
 * <p>
 * 迪米特原则（最少知道原则 Demeter principle）
 * <p>
 * 从依赖者的角度来说，只依赖应该依赖的对象。
 * 从被依赖者的角度说，只暴露应该暴露的方法。
 * <p>
 * 优点：
 * 降低了类之间的耦合度，提高了模块的相对独立性。
 * 由于亲合度降低，从而提高了类的可复用率和系统的扩展性。
 * <p>
 * 注意：
 * 但是，过度使用迪米特法则会使系统产生大量的中介类，从而增加系统的复杂性，使模块之间的通信效率降低。
 * 所以，在釆用迪米特法则时需要反复权衡，确保高内聚和低耦合的同时，保证系统的结构清晰
 */
public class LeastKnowledgePrinciple
{
    public static void main(String[] args)
    {
        Agent a1 = new Agent("test-agent");
        CarFactory c1 = new CarFactory("bmw");
        Custermer cr = new Custermer("zhang");

        a1.setCarFactory(c1);
        a1.setCustermer(cr);
        a1.sellCar();
    }
}

/**
 * 卖汽车例子
 * 汽车厂家---》代理商--》客户
 */

class CarFactory
{
    private String name;

    CarFactory(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void buildFactory()
    {
        System.out.println("factory build car");
    }

}

class Agent
{
    private String name;

    private CarFactory carFactory;

    private Custermer custermer;

    public CarFactory getCarFactory()
    {
        return carFactory;
    }

    public void setCarFactory(CarFactory carFactory)
    {
        this.carFactory = carFactory;
    }

    public Custermer getCustermer()
    {
        return custermer;
    }

    public void setCustermer(Custermer custermer)
    {
        this.custermer = custermer;
    }

    Agent(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void sellCar()
    {
        System.out.println("car-factory:" + carFactory.getName() + " sell to: " + custermer.getName());
    }
}

class Custermer
{
    private String name;

    Custermer(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void buyCar()
    {
        System.out.printf("客户买车");
    }
}
