package com.future.callback.example1;

import org.apache.catalina.webresources.ClasspathURLStreamHandler;

public class Shop {
    private String contactMsg = "";

    public String sell(String someThing, CommonCustomer commonCustomer) throws InterruptedException {
        System.out.println("shop sell....");
        if (someThing.equals("tiger")) {
            System.out.println("don't have,please try again later! do you want leave some contact message ?");
            //如果没有货，留下联系方式，方便通知客户，至于什么联系方式由客户提供
            String cellPhone = commonCustomer.callBack("get leave msg: ");
            System.out.println("I know your contact info: " + cellPhone);
            contactMsg = cellPhone;
            Thread.sleep(3000);
            System.out.println("shop had goods, boss call number:" + contactMsg);
        }

        // 返回买的东西
        return someThing;
    }
}
