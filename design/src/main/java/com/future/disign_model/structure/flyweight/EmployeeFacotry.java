package com.future.disign_model.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcd
 * @date 2019-06-12 22:04
 */
public class EmployeeFacotry
{
    /**
     * 要注意线程安全问题,是否需要保证线程安全根据具体业务场景分析
     */
    private static final Map<String, Employee>  employCache = new HashMap<>();

    public static Employee getManager(String department)
    {
        Manager manager = (Manager) employCache.get(department);
        if(manager == null)
        {
            manager = new Manager(department);
            employCache.put(department, manager);
            System.out.println("create department: " + department);
        }
        return manager;
    }

}
