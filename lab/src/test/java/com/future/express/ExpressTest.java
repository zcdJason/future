package com.future.express;


import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by zcd on 2019-05-23
 */
class ExpressTest
{

    @Test
    void testOne() throws Exception
    {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a", 1);
        context.put("b", 2);
        String express = "a+b";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
        Assertions.assertEquals(r, 3 + 0);

        DefaultContext<String, Object> row = new DefaultContext<>();
        List<Integer> r1= new ArrayList<>();
        r1.add(1);
        r1.add(2);
        r1.add(3);
        r1.add(4);

        List<Integer> r2= new ArrayList<>();
        r2.add(3);
        r2.add(3);
        r2.add(3);
        r2.add(3);
        r2.add(3);
        row.put("c", r1);
        row.put("d", r2);
        Object obj = runner.execute("c+d", row, null, true, false);
        System.out.println(obj);

    }

    @Test
    public void defineFunctionTest() throws Exception
    {
        final String express = "function add(int a,int b){\n" +
                "  return a+b;\n" +
                "};\n" +
                "\n" +
                "function sub(int a,int b){\n" +
                "  return a - b;\n" +
                "};\n" +
                "\n" +
                "a=10;\n" +
                "return add(a,4) + sub(a,9);";
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
        Assertions.assertEquals(15, r);
    }

    @Test
    public void replaceKeywordTest() throws Exception
    {
        ExpressRunner runner = new ExpressRunner();
        runner.addOperatorWithAlias("如果", "if", null);
        runner.addOperatorWithAlias("则", "then", null);
        runner.addOperatorWithAlias("否则", "else", null);
        DefaultContext<String, Object> context = new DefaultContext<>();
        final String express = "如果(1>2){ return 10;} 否则 {return 5;}";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
        Assertions.assertEquals(5, r);
    }

    @Test
    public void addOperatorTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addOperator("join", new JoinOperator());
        Object r = runner.execute("1 join 2 join 3", context, null, false, false);
        Assertions.assertEquals(Arrays.asList(1,2,3), r);
    }
    @Test
    public void replaceOperatorTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.replaceOperator("+", new JoinOperator());
        Object r = runner.execute("1 + 2 + 3", context, null, false, false);
        Assertions.assertEquals(Arrays.asList(1,2,3), r);
    }
    @Test
    public void addFunctionTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addFunction("join",new JoinOperator());
        Object r = runner.execute("join(1, 2, 3)", context, null, false, false);
        Assertions.assertEquals(Arrays.asList(1,2,3), r);
    }

    /**
     * 宏定义
     */
    @Test
    public void macroTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addMacro("计算平均成绩", "(语文+数学+英语)/3.0");
        runner.addMacro("是否优秀", "计算平均成绩>90");
        IExpressContext<String, Object> context = new DefaultContext<>();
        context.put("语文", 88);
        context.put("数学", 99);
        context.put("英语", 95);
        Boolean result = (Boolean) runner.execute("是否优秀", context, null, false, false);
        Assertions.assertTrue(result);
    }
    /**
     * 绑定java类或者方法
     */
    @Test
    public void bindObjectMethodTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();

        runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs",
                new String[] { "double" }, null);
        runner.addFunctionOfClassMethod("转换为大写", BindObjectMethod.class.getName(),
                "upper", new String[] { "String" }, null);
        runner.addFunctionOfServiceMethod("打印", System.out, "println",new String[] { "String" }, null);
        runner.addFunctionOfServiceMethod("contains", new BindObjectMethod(), "anyContains",
                new Class[] { String.class, String.class }, null);
        String exp = "取绝对值(-100);转换为大写(\"hello world\");打印(\"你好吗？\");contains(\"helloworld\",\"aeiou\")";
        Object r = runner.execute(exp, context, null, false, false);
        System.out.println(r);
    }
}