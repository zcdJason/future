package com.future.bootstrap.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author zcd
 * @date 2019-05-31 16:59
 */
@RestController
@RequestMapping(value = "/webservice")
public class ModelRemoteApiInvoke
{

    //    @RequestMapping(value = "/job_execute.do", method = {RequestMethod.POST,RequestMethod.GET})
    @RequestMapping(value = "/job_execute.do", produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.POST,RequestMethod.GET})
    public String executeJob(@RequestBody FeiLongExeJobVo feiLongExeJobVo)
    {
        System.out.println(feiLongExeJobVo.toString());
        FeiLongExeResVo feiLongExeResVo = new FeiLongExeResVo();
        feiLongExeResVo.setExecutionId("test0001");
        feiLongExeResVo.setMsg("success");
        feiLongExeResVo.setResult("good");
        return JsonUtil.toString(feiLongExeResVo);
    }
}
