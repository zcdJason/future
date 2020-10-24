package com.future.disign_model.action.Memento;

/**
 * @author: Cock a doodle doo
 */
public class Memento {
    private final String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        state = state;
    }

    public static void main(String[] args) {
        Memento m = new Memento("t");
        m.setState("sdfd");
        System.out.println(m.state);
    }
}
