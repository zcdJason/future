package com.future.disign_model.action.visitor;

/**
 * @author: Cock a doodle doo
 */
public interface Element {
    void accept(Visitor visitor);
    void operator();
}
