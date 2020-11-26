package com.future.rule;

import java.util.List;

/**
 * @author Cock-a-doodle-doo!
 */
public class RuleWrapper {
    /*领域规则列表*/
    private List<RuleDomain> ruleDomains;
    /*新的列名称*/
    private String newColumn;

    public List<RuleDomain> getRuleDomains() {
        return ruleDomains;
    }

    public void setRuleDomains(List<RuleDomain> ruleDomains) {
        this.ruleDomains = ruleDomains;
    }

    public String getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(String newColumn) {
        this.newColumn = newColumn;
    }

    @Override
    public String toString() {
        return "RuleWrapped{" +
            "ruleDomains=" + ruleDomains +
            ", newColumn='" + newColumn + '\'' +
            '}';
    }
}
