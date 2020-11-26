package com.future.rule;

import java.util.List;
import javax.validation.constraints.NotBlank;

/**
 * @author Cock-a-doodle-doo!
 */
public class RuleDomain {
    /**标签*/
    @NotBlank(message = "ruleLabel cannot be empty!")
    private String ruleLabel;
    /**规则定义*/
    private List<RuleDefine> ruleDefine;
    public String getRuleLabel() {
        return ruleLabel;
    }

    public void setRuleLabel(String ruleLabel) {
        this.ruleLabel = ruleLabel;
    }

    public List<RuleDefine> getRuleDefine() {
        return ruleDefine;
    }

    public void setRuleDefine(List<RuleDefine> ruleDefine) {
        this.ruleDefine = ruleDefine;
    }

    @Override
    public String toString() {
        return "RuleDomain{" +
            "ruleLabel='" + ruleLabel + '\'' +
            ", ruleDefine=" + ruleDefine +
            '}';
    }
}
