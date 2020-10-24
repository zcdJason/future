package com.future.disign_model.action.Memento;

/**
 * @author: Cock a doodle doo
 */
public class Manager {
    private Memento memento;

    //恢复备忘
    public Memento restoreMemento() {
        return memento;
    }

    //存储备忘
    public void storeMemento(Memento memento){
        this.memento = memento;
    }
}
