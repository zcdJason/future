package com.future.livy;

/**
 * created by zcd on 2019/2/28
 */
public interface LivySession {
    /**
     * Creates a new interactive Scala, Python, or R shell in the cluster.
     * @param sessionId
     * @return
     */
    String getSession(int sessionId);

    /**
     * Returns the state of session
     * @param sessionId
     * @return
     */
    String getSessionState(int sessionId);

    /**
     * Kills the Session job.
     * @param sessionId
     * @return
     */
    boolean deleteSession(int sessionId);

    /**
     * Gets the log lines from this session.
     * @param sessionId
     * @return
     */
    String getSessionLog(int sessionId);

    /**
     * Returns all the statements in a session.
     * @param sessionId
     * @return
     */
    String getSessionStatements(int sessionId);

    /**
     * Returns all the active interactive sessions.
     * @param from
     * @param size
     * @return
     */
    String listSessions(int from , int size);

    /**
     * Runs a statement in a session.
     * @param sessionId
     */
    void postStatements(int sessionId);

    /**
     * Returns a specified statement in a session.
     * @param sessionId
     * @param statementId
     */
    void getStatementsRes(int sessionId, int statementId);

    /**
     * Cancel the specified statement in this session.
     * @param sessionId
     * @param statementId
     */
    void cancelStatements(int sessionId, int statementId);

    /**
     * Returns all the active batch sessions.
     */
    void getBatches();

    /**
     * The created Batch object.
     */
    void postBatches();

    /**
     * Returns the batch session information.
     */
    void getBatches(int batchId);

    /**
     * Returns the state of batch session
     */
    void getBatchesState(int batchId);

    /**
     * Kills the Batch job.
     * @param batchId
     */
    void cancelBatchJob(int batchId);

    /**
     * Gets the log lines from this batch.
     */
    void getBatchLog(int batchId);
}
