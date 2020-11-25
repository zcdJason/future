package com.future.express;


import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import org.junit.Test;

import java.util.*;

/**
 * Created by zcd on 2019-05-23
 */
public class ExpressTest
{

    @Test
    public void testOne() throws Exception
    {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();//值
        context.put("a", 1);
        context.put("b", 2);
        String express = "a+b"; //表达式
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);

        DefaultContext<String, Object> row = new DefaultContext<>();
        row.put("c", 1);
        row.put("d", 2);
        Object obj = runner.execute("c-d", row, null, true, false);
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
                "a=100;\n" +
                "return add(a,4) + sub(a,9);";
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a", 10);
        System.out.println(context);
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }

    @Test
    public void replaceKeywordTest() throws Exception
    {
        ExpressRunner runner = new ExpressRunner();
        runner.addOperatorWithAlias("如果", "if", null);
        runner.addOperatorWithAlias("则", "then", null);
        runner.addOperatorWithAlias("否则", "else", null);
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("分数", 15);
        final String express = "如果(分数>=10 && 分数<20){ return \"low\";}";
        final String express1 = "如果(分数>=20 && 分数<30){ return \"medium\";}";
        final String express2 = "如果(分数>=30 && 分数<40){ return \"high\";}";
        final String express3 = "如果(分数>=40 && 分数<50){ return \"very-high\";}";
        List<String> expressList = new ArrayList<>();
        expressList.add(express);
        expressList.add(express1);
        expressList.add(express2);
        expressList.add(express3);

        Object r = null;
        for(String exp: expressList)
        {
             r = runner.execute(exp, context, null, true, false);
            if(r != null)
            {
                break;
            }
        }

        System.out.println(r);
    }

    @Test
    public void addOperatorTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addOperator("join", new JoinOperator());
        Object r = runner.execute("1 join 2 join 3", context, null, false, false);
    }
    @Test
    public void replaceOperatorTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.replaceOperator("+", new JoinOperator());
        Object r = runner.execute("1 + 2 + 3", context, null, false, false);
//        Assertions.assertEquals(Arrays.asList(1,2,3), r);
    }
    @Test
    public void addFunctionTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addFunction("join",new JoinOperator());
        Object r = runner.execute("join(1, 2, 3)", context, null, false, false);
//        Assertions.assertEquals(Arrays.asList(1,2,3), r);
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
//        Assertions.assertTrue(result);
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