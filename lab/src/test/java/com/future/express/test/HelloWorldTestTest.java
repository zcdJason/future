package com.future.express.test;

import com.alibaba.fastjson.JSONObject;
import com.future.rule.HiveParameters;
import com.future.rule.RuleDefine;
import com.future.rule.RuleWrapper;
import com.future.rule.StgTemplateHelper;
import com.future.st.OperatorDomain2;
import com.future.rule.RuleDomain;
import com.future.st.RuleDomain2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by zcd on 2019-05-23
 */
public class HelloWorldTestTest
{

    /**
     * <if(boolexpr1)>subtemplate
     * <elseif(boolexpr2)>subtemplate2
     * ...
     * <elseif(boolexprN)>subtemplateN
     * <else>defaultsubtemplate
     * <endif>
     * @return
     */
    private RuleDomain getRuleDomain(){
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
        return ruleDomain;
    }

    private RuleDomain2 getRuleDomain2(){
        RuleDomain2 ruleDomain = new RuleDomain2();
        List<OperatorDomain2> list = new ArrayList<>();
        OperatorDomain2 operatorDomain = new OperatorDomain2();
        operatorDomain.setColumn("本年度执法量");
        operatorDomain.setOperator(">");
        operatorDomain.setValue("20");

        OperatorDomain2 operatorDomain2 = new OperatorDomain2();
        operatorDomain2.setColumn("本年度执法量");
        operatorDomain2.setOperator("<");
        operatorDomain2.setValue("30");
        list.add(operatorDomain);
        list.add(operatorDomain2);
        ruleDomain.setLabelValue("优秀");
        ruleDomain.setOperatorDomain(list);
        return ruleDomain;
    }

    @Test
    public void testTemplate()
    {
        RuleDomain ruleDomain = getRuleDomain();
        System.out.println(ruleDomain);
        System.out.println(JSONObject.toJSON(ruleDomain));

        //拼接hive-sql if( (a > b && a < c) and (aa> bb and aa< cc)  , v1, v2)
        StringBuffer res = new StringBuffer();
        for(RuleDefine ruleDefine1 : ruleDomain.getRuleDefine()) {
            res.append(ruleDefine1.getColumn());
            res.append(ruleDefine1.getOperator());
            res.append(ruleDefine1.getValue());

            if(ruleDefine1.getLogicOp() != null){
                res.append(" ");
                res.append(ruleDefine1.getLogicOp());
                res.append(" ");
            }

        }

//使用模版占位符

        ST hello = new ST("select <columns>, if(<condition>, <labelValue>, <defaultValue>)");
        hello.add("condition", res.toString());
        hello.add("columns", "字段");
        hello.add("labelValue", ruleDomain.getRuleLabel());
        hello.add("defaultValue", "其它");
        System.out.println(hello.render());
    }

    @Test
    public void testTemplateNew(){
        STGroup stg = new STGroupFile("/Users/zcd/files/NewX/future/lab/src/main/resources/sqlTemplateHive.stg");
        //获取查询模版
        ST st = stg.getInstanceOf("combineSql");

        RuleDomain ruleDomain = getRuleDomain();

        RuleWrapper ruleObj = new RuleWrapper();
        List<RuleDomain> ruleDomainList = new ArrayList<>();
        ruleDomainList.add(ruleDomain);
        ruleDomainList.add(ruleDomain);
        ruleObj.setRuleDomains(ruleDomainList);


        st.add("tableName", "test");
        st.add("conditions", ruleDomain.getRuleDefine());
        List<String> columns = new ArrayList<>();
        columns.add("r1");
        columns.add("r2");
        columns.add("r3");
        st.add("columns", columns);
        System.out.println(st.render());

        /**
         * combineRuleSql(columns,ruleObj,tableName, newColumn)
         * ::=<<
         * <if(columns && tableName)>
         * <if(ruleObj)>
         * SELECT <columns:{column|<column>}; separator=",">
         * case <ruleObj:{rule|when <rule.ruleDefine:{condition | <condition.column> <condition.operator> <condition.value> <condition.logicOp>} ; separator=" "> then <rule.ruleLabel>
         * }; separator=","> else 'undefine' end as <newColumn>
         * FROM <tableName>
         * <endif>
         * <else>
         * SELECT * FROM <tableName>
         * <endif>
         * >>
         */

    }


    public String getStgTemplateSql(RuleWrapper ruleWrapper, HiveParameters hiveParameters){
        STGroup stg = new STGroupFile("/Users/zcd/files/NewX/future/lab/src/main/resources/sqlTemplateHive.stg");
        //获取查询模版
        ST st = stg.getInstanceOf("combineRuleSql");
        st.add("sourceTable", hiveParameters.getSourceTable());
        st.add("targetTable", hiveParameters.getTargetTable());
        st.add("overwrite", hiveParameters.isOverwrite());
        st.add("columns", hiveParameters.getColumns());
        st.add("ruleWrapper", ruleWrapper);
        return st.render();
    }


    @Test
    public void testRuleListNew(){
        RuleWrapper ruleObj = new RuleWrapper();
        RuleDomain ruleDomain = getRuleDomain();
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