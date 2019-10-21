package com.future.callback.example1;

public class Customer implements CommonCustomer{
    private String cellPhone = "111111";

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void buy(String goods)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Shop shop = new Shop();
                try {
                    String res = shop.sell(goods, Customer.this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("我临时有事情出去了,你有货就邮寄给我吧");
    }

    @Override
    public String callBack(String contactMsg) {
        return cellPhone;
    }
}
