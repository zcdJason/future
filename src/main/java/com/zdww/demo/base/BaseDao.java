package com.zdww.demo.base;

import java.util.List;

/**
 * @author zcd
 * @date 2019-07-23 22:31
 */
public interface BaseDao<T extends BaseModel> {

    List<T> selectAll();

    int delete(String id);

    T select(String id);

    int insert(T record);

    int update(T record);
}