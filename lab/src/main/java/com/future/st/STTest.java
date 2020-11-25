package com.future.st;


import java.util.LinkedList;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcd
 * @date 2019-07-24 11:31
 */
public class STTest
{
    /**
     * 测试模版参数替换功能
     * 测试org.stringtemplate.v4 ST功能
     * STGroup
     * import org.stringtemplate.v4.ST;
     * import org.stringtemplate.v4.STGroup;
     * import org.stringtemplate.v4.STGroupFile;
     */
    public static void main(String[] args)
    {
        ST hello = new ST("hello , <name>");
        hello.add("name", "world");
        System.out.println(hello.render());

        STGroup stg = new STGroupFile("/Users/zcd/files/NewX/future/lab/src/main/resources/sqlTemplate.stg");

        //获取查询模版
        ST st = stg.getInstanceOf("querySql");

        st.add("nativeQuery", true);

        //分组名称
//        List<String> groupsList = new ArrayList<>();
//        groupsList.add("c1");
//        groupsList.add("c2");
//        st.add("groups", groupsList);

        //聚合函数
        List<Aggregator>  aggregators = new ArrayList<>();
        Aggregator  a1 = new Aggregator("c1", "max");
        Aggregator  a2 = new Aggregator("c2", "count");
        Aggregator  a3 = new Aggregator("c3", "min");
        aggregators.add(a1);
        aggregators.add(a2);
        aggregators.add(a3);

//        List<String>  aggregators = new ArrayList<>();
//        aggregators.add("max(c1)");
//        aggregators.add("min(c2)");

        st.add("aggregators", aggregators);

        st.add("filters", null);

        List<Order> orders = new ArrayList<>();
        Order o1 = new Order("c1", "desc");
        Order o2 = new Order("c2", "asc");
        orders.add(o1);
        orders.add(o2);
        st.add("orders", orders);

//        st.add("keywordPrefix", "prefix");
//        st.add("keywordSuffix", "suffix");

        st.add("sql", "select c1 as ccc, c2 as cc from test as t where c1 = 1 and c2=5");
        System.out.println(st.render());


        ST querySt = stg.getInstanceOf("createTable");
        querySt.add("tableName", "test");

        List<Fields> fields = new ArrayList<>();
        Fields field = new Fields();
        field.setName("name");
        field.setType("String");
        field.setComment("姓名");

        Fields field2 = new Fields();
        field2.setName("age");
        field2.setType("int");
        field2.setComment("年龄");

        fields.add(field);
        fields.add(field2);

        querySt.add("fields", fields);

        fields.forEach(x-> System.out.println(x.getName() + x.getType()+ x.getComment()));
        System.out.println(querySt.render());
    }
}

class Fields{
    @NotBlank(message = "column name cannot be empty!")
    private String name;
    private String type;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Aggregator{
    @NotBlank(message = "Invalid aggregator column")
    private String column;

    private String func;

    public Aggregator() {
    }

    public Aggregator(String column, String func) {
        this.column = column;
        this.func = func;
    }

    public String getColumn()
    {
        return column;
    }

    public void setColumn(String column)
    {
        this.column = column;
    }

    public String getFunc()
    {
        return func;
    }

    public void setFunc(String func)
    {
        this.func = func;
    }
}

class Order {
    @NotBlank(message = "Invalid order column")
    private String column;

    private String direction = "ASC";

    public Order(String column, String direction) {
        this.column = column;
        this.direction = direction;
    }

    public Order() {
    }

    public String getColumn()
    {
        return column;
    }

    public void setColumn(String column)
    {
        this.column = column;
    }

    public String getDirection()
    {
        return direction;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }
}
