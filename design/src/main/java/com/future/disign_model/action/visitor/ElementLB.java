package com.future.disign_model.action.visitor;

/**
 * @author: Cock a doodle doo
 */
public class ElementLB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    @Override
    public void operator() {
        System.out.println("吕布大招");
    }
}
