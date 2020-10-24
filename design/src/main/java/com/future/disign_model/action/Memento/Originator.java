package com.future.disign_model.action.Memento;

/**
 * @author: Cock a doodle doo
 */
public class Originator {
    private String state;

    public Memento createMemento(){
        return  new Memento(state);
    }
    public void restoreMemento(Memento memento){
        this.state = memento.getState();
    }
}
