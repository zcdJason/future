package com.future.disign_model.SimpleFactory;


/**
 * Created by zcd on 2019-05-21
 */
public class CpuFactory
{
    /**
     * 工厂方法 构造cpu
     */

    public Cpu builder(PcType pcType)
    {
        Cpu cpu = null;
        if (pcType == PcType.amd)
        {
            cpu = new AmdCpu();
        } else if (pcType == PcType.inter)
        {
            cpu = new InterCpu();
        }

        return cpu;
    }

}
