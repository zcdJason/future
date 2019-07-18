package com.future.disign_model.ResponsibilityChain;

/**
 * @author zcd
 * @date 2019-06-11 13:44
 */
public class ManagerHandler extends Handler
{
    @Override
    public String handlerRequest(String user, Double fee)
    {
        String res = "";
        if(fee < 500)
        {
            res = String.format("预算在500以内，项目经理处理， 用户：%s",user);
        }else
        {
            if(getSuccessor()!= null)
            {
                res = "大于500 无权处理，需要上级批准！，交与上级";
                getSuccessor().handlerRequest(user, fee);
            }
        }
        return  res;
    }
}
