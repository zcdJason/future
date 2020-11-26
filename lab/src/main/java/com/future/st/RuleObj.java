package com.future.st;

import com.future.rule.RuleDomain;
import java.util.List;

/**
 * @author Cock-a-doodle-doo!
 */
public class RuleObj {

    private List<RuleDomain> ruleDomains;
    private String newColumn;

    public String getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(String newColumn) {
        this.newColumn = newColumn;
    }

    public List<RuleDomain> getRuleDomains() {
        return ruleDomains;
    }

    public void setRuleDomains(List<RuleDomain> ruleDomains) {
        this.ruleDomains = ruleDomains;
    }

    @Override
    public String toString() {
        return "RuleList{" +
            "ruleDomains=" + ruleDomains +
            ", newColumn='" + newColumn + '\'' +
            '}';
    }
}
