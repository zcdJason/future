package com.future.disign_model.action.ResponsibilityChain;

/**
 * @author zcd
 * @date 2019-06-11 11:05
 */
public abstract class Handler
{
    private Handler successor = null;

    public Handler getSuccessor()
    {
        return successor;
    }

    public void setSuccessor(Handler successor)
    {
        this.successor = successor;
    }

    public abstract String handlerRequest(String user, Double fee);
}
