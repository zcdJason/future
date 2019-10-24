package com.future.disign_model.creator.prototype;

import java.util.Date;

/**
 * @author zcd
 * @date 2019-06-03 22:23
 */
public class MailDeep implements Cloneable
{
    private String name;
    private Integer age;

    private Date birthday;

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    @Override
    public String toString()
    {
        return "MailDeep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}' + super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        /**
         * 实现深克隆
         */
        MailDeep deep = (MailDeep)super.clone();
        deep.birthday = (Date)deep.birthday.clone();
        return deep;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }
}
