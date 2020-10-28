package com.future.thinkInJava5.concurrent.CompletableFutureTest;

import com.future.thinkInJava5.onjava.Nap;

/**
 * 这是一个有限状态机，一个微不足道的机器，
 * 因为它没有分支......它只是从头到尾遍历一条路径。
 * work() 方法将机器从一个状态移动到下一个状态，并且需要 100 毫秒才能完成“工作”。
 *
 * @author Cock-a-doodle-doo!
 */
// concurrent/Machina.java
public class Machina {

    public enum State {
        START, ONE, TWO, THREE, END;

        State step() {
            if (equals(END)) {
                return END;
            }
            return values()[ordinal() + 1];
        }
    }

    private State state = State.START;
    private final int id;

    public Machina(int id) {/**/
        this.id = id;
    }

    public static Machina work(Machina m) {
        if (!m.state.equals(State.END)) {
            new Nap(1.1);
            m.state = m.state.step();
        }
        System.out.println(m);
        return m;
    }

    @Override
    public String toString() {
        return "Machina" + id + ": " + (state.equals(State.END) ? "complete" : state);
    }
}

