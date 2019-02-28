package com.future.livy;

/**
 * @author zcd
 */
public class Statement {
    private Integer id;
    private String code;
    private StatementState state;
    private StatementOutput output;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StatementState getState() {
        return state;
    }

    public void setState(StatementState state) {
        this.state = state;
    }

    public StatementOutput getOutput() {
        return output;
    }

    public void setOutput(StatementOutput output) {
        this.output = output;
    }
}
