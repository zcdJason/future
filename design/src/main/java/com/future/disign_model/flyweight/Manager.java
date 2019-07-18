package com.future.disign_model.flyweight;

/**
 * @author zcd
 * @date 2019-06-12 22:04
 */
public class Manager implements Employee
{
    @Override
    public void report()
    {
        System.out.println(reportContent);
    }

    private String title = "部门经理"; //内部状态
    private String department; //外部状态
    private String reportContent;

    public String getReportContent()
    {
        return reportContent;
    }

    public void setReportContent(String reportContent)
    {
        this.reportContent = reportContent;
    }

    public Manager(String department)
    {
        this.department = department;
    }
}
