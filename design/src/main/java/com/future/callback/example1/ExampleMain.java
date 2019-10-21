package com.future.callback.example1;

public class ExampleMain {
    /**
     * 你到一个商店买东西，刚好你要的东西没有货，于是你在店员那里留下了你的电话，
     * 过了几天店里有货了，店员就打了你的电话，然后你接到电话后就到店里去取了货。
     * 在这个例子里，你的电话号码就叫回调函数，你把电话留给店员就叫登记回调函数，
     * 店里后来有货了叫做触发了回调关联的事件，店员给你打电话叫做调用回调函数，你到店里去取货叫做响应回调事件。
     * @param args
     */
    public static void main(String[] args) {
        Customer customer = new Customer();
       customer.buy("sweet");
       customer.buy("tiger");
    }
}
