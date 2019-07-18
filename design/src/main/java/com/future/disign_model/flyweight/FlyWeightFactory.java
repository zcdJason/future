package com.future.disign_model.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcd
 * @date 2019-06-11 09:51
 */
public class FlyWeightFactory
{
    private static final Map<String, FlyWeight> cache = new HashMap<>();

    public FlyWeight factory(String state)
    {
        FlyWeight flyWeight = cache.get(state);
        if(flyWeight == null)
        {
            flyWeight = new ConcreteFlyWeight(state);
            cache.put(state, flyWeight);
        }
        return flyWeight;
    }
}
