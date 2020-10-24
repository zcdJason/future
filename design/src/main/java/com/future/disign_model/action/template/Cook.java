package com.future.disign_model.action.template;

/**
 * @author: Cock a doodle doo
 */
public abstract class Cook {
    public abstract void oil();

    public abstract void egg();

    public boolean hook(){
        return true;
    };

    public void cook() {
        this.oil();
        this.egg();
        if(hook()){
            System.out.println("hook");
        }
    }
}
