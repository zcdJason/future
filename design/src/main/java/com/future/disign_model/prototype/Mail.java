package com.future.disign_model.prototype;

/**
 * @author zcd
 * @date 2019-06-03 21:57
 */
public class Mail implements Cloneable
{
    private  String  name;
    private String address;
    private String context;

    @Override
    public String toString()
    {
        return "Mail{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", context='" + context + '\'' +
                '}' + super.toString();
    }

    /**
     * 要使用原型模式，就要重写object 的克隆方法
     * @return
     */
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getContext()
    {
        return context;
    }

    public void setContext(String context)
    {
        this.context = context;
    }
}
