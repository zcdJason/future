package com.future.disign_model.action.ResponsibilityChain;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Executor;

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

        Thread t = new Thread();
        t.start();
        t.run();
        String res1 = h1.handlerRequest("lisi", 500d);
        System.out.println(res1);

        String res2 = h1.handlerRequest("wanger", 1000d);
        System.out.println(res2);
    }
}
