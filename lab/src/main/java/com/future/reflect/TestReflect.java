package com.future.reflect;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.TypeUtil;
import com.alibaba.fastjson.TypeReference;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class TestReflect<Vo, T> {

    @SuppressWarnings("unchecked")
    public List<Vo> bean2VoListInner(TypeReference<Vo> typeReference, List<T> list) {
        Class<Vo> rowType = (Class<Vo>) TypeUtil.getClass(typeReference.getType());
        return bean2VoList(rowType, list);
    }

    public List<Vo> bean2VoList(Class<Vo> cls, List<T> list) {
        List<Vo> resultList = new ArrayList<Vo>();
        if (!CollUtil.isEmpty(list)) {
            for (T t : list) {
                Vo v = ReflectUtil.newInstance(cls);
                resultList.add(entityToVo(v, t));
            }
        }
        return resultList;
    }

    public Vo entityToVo(Vo vo, T t) {

        if (null == vo) {
            return null;
        }

        try {
            //不在同一个包中会出现找不到类
//			String voClassName = vo.getClass().getName();
//			String entityClassName = voClassName.substring(0,voClassName.length() - 2);
//			Object target = Class.forName(entityClassName).newInstance();
            BeanUtil.copyProperties(t, vo);
            return vo;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
