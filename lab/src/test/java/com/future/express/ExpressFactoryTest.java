package com.future.express;

import cn.hutool.core.date.DateUtil;
import com.future.express.model.ExpressModel;
import org.junit.Test;

import java.util.*;

/**
 * Created by zcd on 2019-05-23
 */
public  class ExpressFactoryTest
{
    @Test
    public void test()
    {
        List<String> test = new ArrayList<>();
        test.add("test");
        test.add("tiger");
        System.out.println(test.remove(0));
    }

    @Test
    public void testTime()
    {
        Date date = DateUtil.date();
        //获得年的部分
        int year = DateUtil.year(DateUtil.date());
        //获得月份，从0开始计数
        int month = DateUtil.month(date);
        System.out.println(date);
        System.out.println(year);
        System.out.println(month);

    }

    @Test
    public  void transform() throws Exception
    {
//        String express = "row.a + row.b + params.x";
//        String express2 = "if ((row.a + row.b) > params.x ) {return 1;} else {return 0;}";
//        String express1 = "if (row.scores > params.lower && row.scores <=params.upper) {return \"low\";}";
////        String express3 = "case when row.a > row.b then  1 else  0";
//        Map<String, Object> row = new HashMap<>();
//        row.put("a", 1);
//        row.put("b", 1);
//        row.put("c", 2);
//        row.put("d", 2);
//        row.put("scores", 15);
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("lower",10);
//        params.put("upper",20);
//        ExpressModel expressModel = new ExpressModel(express1, row, params);
//        System.out.println(expressModel);
//
//        Object obj = ExpressFactory.transform(expressModel);
//        System.out.println(obj);



        String express1 = "if (row.scores > 10 && row.scores <= 20) {return \"low\";};" +
                "if (row.scores > 20 && row.scores <= 30) {return \"medium\";};" +
                "if (row.scores > 30 && row.scores <= 40) {return \"high\";};" +
                "if (row.scores > 40 && row.scores <= 50) {return \"very-high\";};";
//        String express3 = "case when row.a > row.b then  1 else  0";
        Map<String, Object> row = new HashMap<>();
        row.put("a", 1);
        row.put("b", 1);
        row.put("c", 2);
        row.put("d", 2);
        row.put("scores", 33);

        Map<String, Object> params = new HashMap<>();
        params.put("lower",10);
        params.put("upper",20);
        ExpressModel expressModel = new ExpressModel(express1, row, params);
        System.out.println(expressModel);

        Object obj = ExpressFactory.transform(expressModel);
        System.out.println(obj);
    }
}