package com.future.st;

import java.util.List;

/**
 * @author Cock-a-doodle-doo!
 */
public class RuleDomain2 {
    private String labelValue; //标签值
    private List<OperatorDomain2> operatorDomain;
    private List<String> logicOp;

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    public List<OperatorDomain2> getOperatorDomain() {
        return operatorDomain;
    }

    public void setOperatorDomain(List<OperatorDomain2> operatorDomain) {
        this.operatorDomain = operatorDomain;
    }

    public List<String> getLogicOp() {
        return logicOp;
    }

    public void setLogicOp(List<String> logicOp) {
        this.logicOp = logicOp;
    }

    @Override
    public String toString() {
        return "RuleDomain2{" +
            "labelValue='" + labelValue + '\'' +
            ", operatorDomain=" + operatorDomain +
            ", logicOp=" + logicOp +
            '}';
    }
}
