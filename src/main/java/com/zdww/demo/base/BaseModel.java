package com.zdww.demo.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zcd
 * @date 2019-07-23 22:32
 */
public class BaseModel implements Serializable
{
    /**
     * ID
     */
    private String id;
    /**
     * 是否有效
     */
    private Boolean valid;
    /**
     * 由谁创建
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改者
     */
    private String updateBy;
    /**
     * 最后修改时间
     */
    private Date updateTime;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Boolean getValid() {
        return valid;
    }
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getUpdateBy() {
        return updateBy;
    }
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
