创建型模式:提供创建对象的机制， 增加已有代码的灵活性和可复用性。
结构型模式:介绍如何将对象和类组装成较大的结构， 并同时保持结构的灵活和高效。
行为模式:负责对象间的高效沟通和职责委派。

####创建型【5】
#####单例模式 http://www.cnblogs.com/java-my-life/archive/2012/03/31/2425631.html
#####原型模式 http://www.cnblogs.com/java-my-life/archive/2012/04/11/2439387.html

//当一个类的构造函数参数个数超过4个，而且这些参数有些是可选的参数，考虑使用构造者模式
#####建造者模式  http://www.cnblogs.com/java-my-life/archive/2012/04/07/2433939.html
#####工厂方法 http://www.cnblogs.com/java-my-life/archive/2012/03/25/2416227.html
#####抽象工厂模式 http://www.cnblogs.com/java-my-life/archive/2012/03/28/2418836.html

#####结构型【7】
[组代享桥装适外]
#####组合模式 http://blog.csdn.net/jason0539/article/details/22642281
#####代理模式 http://www.cnblogs.com/java-my-life/archive/2012/04/23/2466712.html
//享-共享，元-元素，就是共享技术
#####享元模式 http://www.cnblogs.com/java-my-life/archive/2012/04/26/2468499.html
#####桥接模式 http://blog.csdn.net/jason0539/article/details/22568865
#####装饰者模式（装饰模式又名包装(Wrapper)模式） http://www.cnblogs.com/java-my-life/archive/2012/04/20/2455726.html
#####适配器模式 http://www.cnblogs.com/java-my-life/archive/2012/04/13/2442795.html
#####外观模式 http://blog.csdn.net/jason0539/article/details/22775311

#####行为型【11】
//击鼓传花，责任链，联想新入职审核，更加不同的流程节点，将责任交给不同权限的审核人
#####责任链模式 http://blog.csdn.net/zhouyong0/article/details/7909456
#####命令模式 http://www.cnblogs.com/java-my-life/archive/2012/06/01/2526972.html
#####解释器模式 http://www.cnblogs.com/java-my-life/archive/2012/06/19/2552617.html
#####迭代模式 http://www.cnblogs.com/java-my-life/archive/2012/05/22/2511506.html
#####中介者模式 http://blog.csdn.net/chenhuade85/article/details/8141831

//给用户提供了一种可以恢复状态的机制，用户能够方便的回到某个历史的状态
//缺点：消耗资源，如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存
#####备忘录模式 http://www.cnblogs.com/java-my-life/archive/2012/06/06/2534942.html


#####观察者模式 http://www.cnblogs.com/java-my-life/archive/2012/05/16/2502279.html
//根据节点状态转换处理行为
//模式角色有三类：Context 上下文，抽象状态（State）， 具体状态实现类；根据不通的状态使用不同的行为
#####状态模式 http://www.cnblogs.com/java-my-life/archive/2012/06/08/2538146.html

#####策略模式 http://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html

//一个抽象类公开定义了执行它的方法的方式/模板。
//它的子类可以按需要重写方法实现,但调用将以抽象类中定义的方式进行。这种类型的设计模式属于行为型模式。
#####模板方法模式 http://www.cnblogs.com/java-my-life/archive/2012/05/14/2495235.html


#####访问者模式 http://www.cnblogs.com/java-my-life/archive/2012/06/14/2545381.html