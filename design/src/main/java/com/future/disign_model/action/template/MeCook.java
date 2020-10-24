package com.future.disign_model.action.template;

/**
 * @author: Cock a doodle doo
 */
public class MeCook extends Cook {
    @Override
    public void oil() {
        System.out.println("me oil");
    }

    @Override
    public void egg() {
        System.out.println("me egg");
    }

    @Override
    public boolean hook() {
        return false;
    }
}
