package com.future.disign_model.ResponsibilityChain;

/**
 * @author zcd
 * @date 2019-06-11 11:03
 */
public class Test
{
    /**
     * 假设一个场景
     * @param args
     */
    public static void main(String[] args)
    {
        /*组装责任链*/
        Handler h1 = new ManagerHandler();
        Handler h2 = new DeptHandler();
        h1.setSuccessor(h2);

        String res = h1.handlerRequest("zhansan", 200d);
        System.out.println(res);
        String res1 = h1.handlerRequest("lisi", 500d);
        System.out.println(res1);
        String res2 = h1.handlerRequest("wanger", 600d);
        System.out.println(res2);
    }
}
