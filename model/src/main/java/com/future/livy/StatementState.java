package com.future.livy;

/**
 * @author zcd
 */
public enum  StatementState {
    /**
     * waiting	Statement is enqueued but execution hasn't started
     * running	Statement is currently running
     * available	Statement has a response ready
     * error	Statement failed
     * cancelling	Statement is being cancelling
     * cancelled	Statement is cancelled
     */
    waiting,running,available, error, cancelling, cancelled
}
