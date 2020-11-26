package com.future.rule;

/**
 * @author Cock-a-doodle-doo!
 */
public class RuleDefine {

    /**列名称*/
    private String column;
    /**操作符号*/
    private String operator;
    /**设置的值*/
    private String value;
    /**表达式，如果定义了表达式，则不用解析 （column、operator、value）字段 两者选择其一，优先表达式*/
    private String expression;
    /**逻辑操作符号 与或非 and or not*/
    private String logicOp;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLogicOp() {
        return logicOp;
    }

    public void setLogicOp(String logicOp) {
        this.logicOp = logicOp;
    }

    @Override
    public String toString() {
        return "OperatorDomain{" +
            "column='" + column + '\'' +
            ", operator='" + operator + '\'' +
            ", value='" + value + '\'' +
            ", express='" + expression + '\'' +
            ", logicOp='" + logicOp + '\'' +
            '}';
    }
}
