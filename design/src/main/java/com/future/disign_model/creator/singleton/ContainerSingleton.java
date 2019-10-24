package com.future.disign_model.creator.singleton;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zcd on 2019-05-23
 *
 * 容器存单例，使用场景是单例对象比较多，使用容器管理
 */
public class ContainerSingleton
{
    private ContainerSingleton(){};
    private static Map<String, Object> singleMap = new HashMap<String, Object>();
    public static void putInstance(String key, Object instance)
    {
        if(!StringUtils.isEmpty(key) && instance != null)
        {
            if(!singleMap.containsKey(key))
            {
                singleMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key)
    {
        return singleMap.get(key);
    }
}
