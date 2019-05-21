package com.future.disign_model.SimpleFactory;

/**
 * Created by zcd on 2019-05-21
 */
public class PCWorker
{

    public static void main(String[] args)
    {
        String pcInfo = new PCWorker().makePC(PcType.amd);
        System.out.println(pcInfo);
    }

    /**
     * pc 组装工人
     */
    public String makePC(PcType pcType)
    {
        Pc pc = parePareHardware(pcType);
        return String.format("input pcType %s, get pc boardType = %s, get pc cpu-Type = %s", pcType, pc.getBoard().getBoardType(), pc.getCpu().getCpuType());
    }

    private Pc parePareHardware(PcType pcType)
    {
        Pc pc = new Pc();
        Board board = new BoardFactory().builder(pcType);
        Cpu cpu = new CpuFactory().builder(pcType);
        board.installCpu();
        cpu.cal();
        pc.setBoard(board);
        pc.setCpu(cpu);
        return pc;
    }
}
