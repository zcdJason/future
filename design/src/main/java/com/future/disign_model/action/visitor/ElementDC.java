package com.future.disign_model.action.visitor;

/**
 * @author: Cock a doodle doo
 */
public class ElementDC implements Element {
    @Override
    public void accept(Visitor visitor) {
        //接受访问者，访问者开始访问元素
        visitor.visitor(this);
    }

    @Override
    public void operator() {
        System.out.println("貂蝉大招");
    }

    public void skill(){
        System.out.println("貂蝉特殊技能");
    }
}
