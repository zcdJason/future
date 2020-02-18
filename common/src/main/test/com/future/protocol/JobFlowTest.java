package com.future.protocol;


import com.future.base.Base;
import com.future.dataModel.*;
import com.future.utils.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcd  2020/2/18 14:53
 */

public class JobFlowTest extends Base {

    @Test
    public void test(){
        JobFlow jobFlow = new JobFlow();
        jobFlow.setCron("*/30 * * * * ?");

        EtlProtocolNode etlProtocolNode = new EtlProtocolNode();
        Context context = new Context();
        context.setFlowId(1);
        context.setJobId(1);
        context.setNodeId(1222);
        context.setPreviousNodeId(1223);
        context.setFlowId(1);
        context.setNextNodeId(1224);
        etlProtocolNode.setContext(context);
        etlProtocolNode.setDealType(DealType.datax);
        etlProtocolNode.setExecEngine(ExecEngine.DbSelf);
        DataSet ds = new DataSet();
                ds.setDsType(DataSetType.file);
                ds.setMetaInfo(new MetaInfo());
        StoreInfo storeInfo = new StoreInfo();
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileType(FileType.csv);
        fileInfo.setPath("localhost");
        storeInfo.setFileInfo(fileInfo);
        storeInfo.setStoreEngine(StoreEngine.hdfs);
        storeInfo.setStoreGranularity(StoreGranularity.increment);

                ds.setStoreInfo(storeInfo);
        etlProtocolNode.setIn(ds);
        etlProtocolNode.setOut(ds);
        EtlStrategy etlStrategy = new EtlStrategy();
        etlStrategy.setContent("select * from demo");
        etlStrategy.setCron("");
        etlProtocolNode.setSt(etlStrategy);
        List<EtlProtocolNode> etlProtocolNodeList = new ArrayList<>();
        etlProtocolNodeList.add(etlProtocolNode);

        jobFlow.setEtlProtocolList(etlProtocolNodeList);
        jobFlow.setFlowId(1L);
        log.info(JsonUtil.toString(jobFlow));
    }
}