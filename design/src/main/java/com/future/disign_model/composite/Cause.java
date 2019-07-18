package com.future.disign_model.composite;

/**
 * @author zcd
 * @date 2019-06-12 22:59
 */
public class Cause extends CatalogComponent
{
    /**
     * 课程有名称和价格
     */
    private String name;
    private double price;

    public Cause(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    @Override
    public String  getName(CatalogComponent catalogComponent)
    {
        return this.name;
    }

    @Override
    public Double getPrice(CatalogComponent catalogComponent)
    {
        return this.price;
    }

    @Override
    public void print()
    {
        System.out.println("course name: " + name + " price: " + price);
    }
}
