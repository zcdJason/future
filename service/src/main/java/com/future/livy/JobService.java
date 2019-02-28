package com.future.livy;

/**
 * created by zcd on 2019/2/28
 * @version 1.0
 */
public interface JobService<T> {

    /**
     * submit a job
     * @param jobProtocol
     * @return
     */
    long submitJob(T jobProtocol);

    /**
     * get batch job state
     * @param jobId
     * @return
     */
    String getJobState(Long jobId);


    /**
     * get job return message
     * @param jobId
     * @return
     */
    String getJobMsg(Long jobId);
}
