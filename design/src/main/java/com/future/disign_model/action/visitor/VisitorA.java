package com.future.disign_model.action.visitor;

/**
 * @author: Cock a doodle doo
 */
public class VisitorA extends Visitor {

    @Override
    public void visitor(ElementLB elementLB) {
        System.out.println("A访问英雄：吕布");
        elementLB.operator();
    }

    @Override
    public void visitor(ElementDC elementDC) {
        System.out.println("A访问英雄：貂蝉");
        elementDC.operator();
        elementDC.skill();
    }
}
