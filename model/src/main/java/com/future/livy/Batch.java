package com.future.livy;

import java.util.List;
import java.util.Map;

/**
 * @author : zcd
 * @date : 2019/2/28 12:10
 */
public class Batch {
    /**
     * id The session id
     */
    private int id;

    /**
     * The application id of this session
     */
    private String appId;

    /**
     * The detailed application info	Map of key=val
     */
    private Map<String, String> appInfo;

    /**
     * The log lines
     */
    private List<String> log;

    /**
     * The batch state
     */
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Map<String, String> getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(Map<String, String> appInfo) {
        this.appInfo = appInfo;
    }

    public List<String> getLog() {
        return log;
    }

    public void setLog(List<String> log) {
        this.log = log;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
