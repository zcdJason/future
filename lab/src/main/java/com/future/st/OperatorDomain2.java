package com.future.st;

/**
 * @author Cock-a-doodle-doo!
 */
public class OperatorDomain2 {
    private String column;
    private String operator; // 比较操作符号
    private String value;

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

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OperatorDomain{" +
            "column='" + column + '\'' +
            ", operator='" + operator + '\'' +
            ", value='" + value + '\'' +
            '}';
    }
}
