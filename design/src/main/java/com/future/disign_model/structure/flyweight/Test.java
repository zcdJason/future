package com.future.disign_model.structure.flyweight;

/**
 * @author zcd
 * @date 2019-06-11 09:03
 *
 *享元模式flyweight （拳击比赛中的最轻量级）反应模式的运用
 * 享元模式采用一个共享来避免大量拥有相同内容对象的开销。这种开销最常见、最直观的就是内存的损耗。
 * 享元对象能做到共享的关键是区分内蕴状态(Internal State)和外蕴状态(External State)
 *
 * 优点/缺点
 * 享元模式的优点在于它大幅度地降低内存中对象的数量。但是，它做到这一点所付出的代价也是很高的：
 * 享元模式使得系统更加复杂。为了使对象可以共享，需要将一些状态外部化，这使得程序的逻辑复杂化。
 * 享元模式将享元对象的状态外部化，而读取外部状态使得运行时间稍微变长
 */
public class Test
{

    private  static final String departMent[] = {"RD", "QA", "PM"};
    public static void main(String[] args)
    {
        String  abc = "abc";
        String bcd = "abc";
        System.out.println(abc == bcd);
        for(int i = 0 ;i <= 10; i++)
        {
            String department = departMent[(int) (Math.random() * departMent.length)];

        }
    }
}
