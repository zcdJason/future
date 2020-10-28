package com.future.thinkInJava5.functionCode;

/**
 * @author Cock-a-doodle-doo!
 */
// functional/Strategize.java

interface Strategy {

    String approach(String msg);
}

class Soft implements Strategy {

    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated {

      static String twice(String msg) {
        return msg + " " + msg;
    }
}

class Unrelated2 {

    static String twiceTest(int msg) {
        return msg + " " + msg;
    }
}

public class Strategize {

    Strategy strategy;
    String msg;

    Strategize(String msg) {
        strategy = new Soft(); // [1] 默认策略
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
            new Strategy() { // [2] 匿名内部类 传统做法：我们通过在方法中创建包含所需行为的对象，然后将该对象传递给我们想要控制的方法来完成此操作
                public String approach(String msg) {
                    return msg.toUpperCase() + "!";
                }
            },

            //方法引用和 Lambda 表达式的出现让我们可以在需要时传递功能
            msg -> msg.substring(0, 5), // [3] Lambda 表达式，其参数和函数体被箭头 -> 分隔开。箭头右侧是从 Lambda 返回的表达式。它与单独定义类和采用匿名内部类是等价的
            Unrelated::twice, // [4] 方法引用，它以 :: 为特征。 :: 的左边是类或对象的名称， :: 的右边是方法的名称，但是没有参数列表
        };

        Strategize s = new Strategize("Hello there");
        s.communicate(); //通信，沟通

        for (Strategy newStrategy : strategies) {
            //每次调用 communicate() 都会产生不同的行为，具体取决于此刻正在使用的策略代码对象。我们传递的是行为，而并不仅仅是数据
            s.changeStrategy(newStrategy); // [5] 修改路由方式
            s.communicate(); // [6]
        }
    }
}

