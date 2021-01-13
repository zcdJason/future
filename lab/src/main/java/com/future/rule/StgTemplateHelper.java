package com.future.rule;

import java.util.ArrayList;
import java.util.List;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * @author Cock-a-doodle-doo!
 */
public class StgTemplateHelper {

    private STGroup stg;

    private StgTemplateHelper() {
    }

    enum SingletonEnum {
        INSTANCE;
        private final StgTemplateHelper stgTemplateHelper;

        SingletonEnum() {
            stgTemplateHelper = new StgTemplateHelper();
        }

        public StgTemplateHelper getInstance() {
            return stgTemplateHelper;
        }
    }

    public static StgTemplateHelper getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    public void init(String stgTemplatePath) {
        stg = new STGroupFile(stgTemplatePath);
    }

    public String getStgTemplateSql(RuleWrapper ruleWrapper, HiveParameters hiveParameters) {
        ST st = stg.getInstanceOf("combineRuleSql");
        st.add("sourceTable", hiveParameters.getSourceTable());
        st.add("targetTable", hiveParameters.getTargetTable());
        st.add("overwrite", hiveParameters.isOverwrite());
        st.add("partitionName", hiveParameters.getPartitionName());
        st.add("partitionValue", hiveParameters.getPartitionValue());
        st.add("columns", hiveParameters.getColumns());
        st.add("ruleWrapper", ruleWrapper);
        return st.render();
    }

    public static void main(String[] args) {
        /**
         *          <dependency>
         *             <groupId>org.antlr</groupId>
         *             <artifactId>ST4</artifactId>
         *             <version>4.0.8</version>
         *         </dependency>
         */
        RuleWrapper ruleObj = new RuleWrapper();

        RuleDomain ruleDomain = new RuleDomain();
        List<RuleDefine> list = new ArrayList<>();
        RuleDefine ruleDefine = new RuleDefine();
        ruleDefine.setColumn("本年度执法量");
        ruleDefine.setOperator(">");
        ruleDefine.setValue("20");
        ruleDefine.setExpression("本年度执法量 > 200"); //使用表达式字符串
        ruleDefine.setLogicOp("and");

        RuleDefine ruleDefine2 = new RuleDefine();
        ruleDefine2.setColumn("本年度执法量");
        ruleDefine2.setOperator("<");
        ruleDefine2.setValue("30");
        list.add(ruleDefine);
        list.add(ruleDefine2);
        ruleDomain.setRuleLabel("优秀");
        ruleDomain.setRuleDefine(list);

        List<RuleDomain> ruleDomainList = new ArrayList<>();
        ruleDomainList.add(ruleDomain);
        ruleDomainList.add(ruleDomain);
        ruleObj.setRuleDomains(ruleDomainList);
        ruleObj.setResColumn("new-index");

        HiveParameters hiveParameters = new HiveParameters();
        List<String> columns = new ArrayList<>();
        columns.add("r1");
        columns.add("r2");
        columns.add("r3");
        hiveParameters.setColumns(columns);
        hiveParameters.setOverwrite(false);
        hiveParameters.setPartitionName("datetime");
        hiveParameters.setPartitionValue("2020-10-25");
        hiveParameters.setSourceTable("sourceTable");
        hiveParameters.setTargetTable("targetTable");

        StgTemplateHelper instance = StgTemplateHelper.getInstance();
        instance.init("/Users/zcd/files/NewX/future/lab/src/main/resources/sqlTemplateHive.stg");
        String sql = instance.getStgTemplateSql(ruleObj, hiveParameters);
        System.out.println(sql);

    }
}
