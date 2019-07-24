package com.future.st;


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
//        ST hello = new ST("hello , <name>");
//        hello.add("name", "world");
//        System.out.println(hello.render());

        STGroup stg = new STGroupFile("/Users/zcd/files/NewX/future/lab/src/main/resources/sqlTemplate.stg");
        ST st = stg.getInstanceOf("querySql");

        st.add("nativeQuery", false);

        List<String> groupsList = new ArrayList<>();
        groupsList.add("c1");
        groupsList.add("c2");
        st.add("groups", groupsList);

        List<Aggregator>  aggregators = new ArrayList<>();
        Aggregator  a1 = new Aggregator("c1", "max");
        Aggregator  a2 = new Aggregator("c2", "count");
        aggregators.add(a1);
        aggregators.add(a2);

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
        st.add("keywordPrefix", "prefix");
        st.add("keywordSuffix", "suffix");

        st.add("sql", "select c1, c2 from test where c1 = 1 and c2=5");
        System.out.println(st.render());
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
