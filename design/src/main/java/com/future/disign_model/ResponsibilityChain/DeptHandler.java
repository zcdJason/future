package com.future.disign_model.ResponsibilityChain;

/**
 * @author zcd
 * @date 2019-06-11 13:44
 */
public class DeptHandler extends Handler
{
    @Override
    public String handlerRequest(String user, Double fee)
    {
        String res = "";
        if(fee < 1000)
        {
            res = String.format("预算在1000以内，部门经理处理， 用户：%s",user);
        }else
        {
            if(getSuccessor()!= null)
            {
                res = "大于1000 无权处理，需要上级批准！，交与上级";
                getSuccessor().handlerRequest(user, fee);
            }
        }
        return  res;
    }
}
