package com.future.rule;

import java.util.List;

/**
 * @author Cock-a-doodle-doo!
 */
public class RuleWrapper {
    /**领域规则列表*/
    private List<RuleDomain> ruleDomains;
    /**新的列名称*/
    private String resColumn;

    public List<RuleDomain> getRuleDomains() {
        return ruleDomains;
    }

    public void setRuleDomains(List<RuleDomain> ruleDomains) {
        this.ruleDomains = ruleDomains;
    }

    public String getResColumn() {
        return resColumn;
    }

    public void setResColumn(String resColumn) {
        this.resColumn = resColumn;
    }

    @Override
    public String toString() {
        return "RuleWrapper{" +
            "ruleDomains=" + ruleDomains +
            ", resColumn='" + resColumn + '\'' +
            '}';
    }
}
