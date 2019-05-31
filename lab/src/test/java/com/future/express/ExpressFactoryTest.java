package com.future.express;

import com.future.express.model.ExpressModel;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zcd on 2019-05-23
 */
class ExpressFactoryTest
{

    @Test
    void transform() throws Exception
    {
        String express = "row.a + row.b";
        String express2 = "if (row.a > row.b) {return 1;} else {return 0;}";
//        String express3 = "case when row.a > row.b then  1 else  0";
        Map<String, Object> row = new HashMap<>();
        row.put("a", 1);
        row.put("b", 1);
        row.put("c", 2);
        row.put("d", 2);
        ExpressModel expressModel = new ExpressModel(express2, row);
        System.out.println(expressModel);

        Object obj = ExpressFactory.transform(expressModel);
        System.out.println(obj);
    }
}