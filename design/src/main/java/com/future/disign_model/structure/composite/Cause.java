package com.future.disign_model.structure.composite;

/**
 * @author zcd
 * @date 2019-06-12 22:59
 */
public class Cause extends CatalogComponent
{
    /**
     * 课程有名称和价格
     */
    private String name="$$$$$$";
    private double price=0.000;

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
        StringBuffer sb = new StringBuffer();
        sb.append("course name");
        sb.append(name);
        sb.append("price: ");
        sb.append(price);
        System.out.println(sb.toString());
    }
}
