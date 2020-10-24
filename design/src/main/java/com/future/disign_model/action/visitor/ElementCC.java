package com.future.disign_model.action.visitor;

/**
 * @author: Cock a doodle doo
 */
public class ElementCC implements Element {
    @Override
    public void accept(Visitor visitor) {
        //接受访问者，访问者开始访问元素
        visitor.visitor(this);
    }

    @Override
    public void operator() {
        System.out.println("曹操大招");
    }
}
