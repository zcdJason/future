package com.future.reflect;

import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class DemoExtend extends TestReflect<Demo<Integer>, DemoEntity> {
    public static void main(String[] args) {
        new DemoExtend().test();
    }

    public  void test()
    {
//        Demo<String> demo = new Demo();
//        DemoEntity demoEntity = new DemoEntity("test", "test", "t");
//        DemoEntity demoEntity1 = new DemoEntity("test", "test", "t");
//        DemoEntity demoEntity2 = new DemoEntity("test", "test", "t");
//        DemoEntity demoEntity3 = new DemoEntity("test", "test", "t");
//        List<DemoEntity> res = new ArrayList<>();
//        res.add(demoEntity);
//        res.add(demoEntity1);
//        res.add(demoEntity2);
//        res.add(demoEntity3);

        DemoEntity demoEntity = new DemoEntity("test", "test", "1");
        DemoEntity demoEntity1 = new DemoEntity("test", "test", "2");
        DemoEntity demoEntity2 = new DemoEntity("test", "test", "3");
        DemoEntity demoEntity3 = new DemoEntity("test", "test", "4");
        List<DemoEntity> res = new ArrayList<>();
        res.add(demoEntity);
        res.add(demoEntity1);
        res.add(demoEntity2);
        res.add(demoEntity3);

        List<Demo<Integer>> resss = bean2VoListInner(new TypeReference<Demo<Integer>>(){}, res);
        System.out.println(resss);
    }
}
