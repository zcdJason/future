package com.future.SixPrinciple;

/**
 * Created by zcd on 2019-05-21
 *
 * 接口隔离原则
 * 接口尽量小，但是要有限度。一个接口只服务于一个子模块或业务逻辑。
 * 为依赖接口的类定制服务。只提供调用者需要的方法，屏蔽不需要的方法。
 * 了解环境，拒绝盲从。每个项目或产品都有选定的环境因素，环境不同，接口拆分的标准就不同深入了解业务逻辑。
 * 提高内聚，减少对外交互。使接口用最少的方法去完成最多的事情。
 */
public class InterfaceSegregationPrinciple
{
    /**
     * 如学生成绩为例子
     */

    /**
     * 定义成绩输入接口
     */
    interface InputMode
    {
        void insert();
        void delte();
        void modify();
    }

    /**
     * 定义成绩输出接口
     */
    interface OutPutMode
    {
        void display();
        void query();
    }

    class Student implements InputMode, OutPutMode
    {

        @Override
        public void insert()
        {

        }

        @Override
        public void delte()
        {

        }

        @Override
        public void modify()
        {

        }

        @Override
        public void display()
        {

        }

        @Override
        public void query()
        {

        }
    }
}
