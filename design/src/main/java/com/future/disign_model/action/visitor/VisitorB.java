package com.future.disign_model.action.visitor;

/**
 * @author: Cock a doodle doo
 * 访问者聚合元素的动作
 */
public class VisitorB extends Visitor {

    @Override
    public void visitor(ElementLB elementLB) {
        System.out.println("B访问英雄：吕布");
        elementLB.operator();
    }

    @Override
    public void visitor(ElementCC elementCC) {
        System.out.println("B访问英雄：曹操");
        elementCC.operator();
    }
}
