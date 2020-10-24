package com.future.data.structure.classInit;

import com.future.data.structure.classInit.Base;

/**
 * @author: Cock a doodle doo
 */
public class Derved extends Base {
    public int num = 10;

//    重写方法
    @Override
    public int lookup() {
        return num;
    }
}
