package com.future.disign_model.action.ResponsibilityChain;

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
                return getSuccessor().handlerRequest(user, fee);
            }else
            {
                res = "大于1000且未指定上级部门无权处理，请指定上级部门！";
            }
        }
        return  res;
    }
}
