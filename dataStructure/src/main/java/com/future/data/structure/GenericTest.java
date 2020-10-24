package com.future.data.structure;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author: Cock a doodle doo
 * 泛型测试
 */
public class GenericTest {
        public static void main(String[] args) {

            /**不指定泛型的时候*/
            int i = GenericTest.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
            Number f = GenericTest.add(1, 1.2); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
            Object o = GenericTest.add(1, "asd"); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

            /**指定泛型的时候*/
            int a = GenericTest.<Integer>add(1, 2); //指定了Integer，所以只能为Integer类型或者其子类
            //int b = Test1.<Integer>add(1, 2.2); //编译错误，指定了Integer，不能为Float
            Number c = GenericTest.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float


            ArrayList list = new ArrayList();
            list.add(1);
            list.add("121");
            list.add(new Date());
            for(int k= 0; k< list.size(); k++){
                System.out.println("-----------");
                System.out.println(list.get(k));
            }
        }
        
        //这是一个简单的泛型方法
        public static <T> T add(T x,T y){
            return y;
        }

}
