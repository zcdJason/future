package com.future.callback.example3;

public class SuperStudent {
    public String doWork(String job, WorkCallBack workCallBack)
    {
        System.out.println("SuperStudent: I get job ->" + job);
        System.out.println("SuperStudent: I know everything");
        if(job.equals("炒股"))
        {
            workCallBack.callBack("买优质A股");
            return "SuperStudent-answer";

        }else{
            workCallBack.callBack("SuperStudent-answer");
            return "SuperStudent-answer";
        }

    }
}
