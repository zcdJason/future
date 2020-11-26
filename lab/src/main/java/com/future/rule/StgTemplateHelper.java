package com.future.rule;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * @author Cock-a-doodle-doo!
 */
public class StgTemplateHelper {
    private  STGroup stg;
    private StgTemplateHelper(){}
    enum SingletonEnum{
        INSTANCE;
        private final StgTemplateHelper stgTemplateHelper;
        SingletonEnum(){
            stgTemplateHelper=new StgTemplateHelper();
        }
        public StgTemplateHelper getInstance(){
            return stgTemplateHelper;
        }
    }
    public static StgTemplateHelper getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }

    public void init(String stgTemplatePath){
        stg = new STGroupFile(stgTemplatePath);
    }

    public String getStgTemplateSql(RuleWrapper ruleWrapper, HiveParameters hiveParameters){
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
}
