package com.future.disign_model.action.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Cock a doodle doo
 * 定义当中所提到的对象结构，对象结构是一个抽象表述，它内部管理了元素集合，并且可以迭代这些元素提供访问者访问
 */
public class ObsStructure {
    private final List<Element> elements = new ArrayList<>();

    public ObsStructure() {
    }

    //迭代元素提供给访问者
    public void play(Visitor visitor){
        for(Element element : elements)
            element.accept(visitor);
    }

    //添加元素
    public void add(Element element){
        elements.add(element);
    }

    public static void main(String[] args) {

        ObsStructure os = new ObsStructure();
        //元素交与对象结构保管
        ElementDC elementDC = new ElementDC();
        ElementLB elementLB = new ElementLB();
        ElementCC elementCC = new ElementCC();
        os.add(elementDC);
        os.add(elementLB);
        os.add(elementCC);

        //新建不通的访问者
//        Visitor visitorA = new VisitorA();
        Visitor visitorB = new VisitorB();

//        os.play(visitorA);
        os.play(visitorB);
    }
}
