package com.future.callback.example2;

public class Worker implements AnswerRes {

    public void doHomeWork(String work)
    {
        /**
         * let roommate do homework and give him pointer
         */
        RoomMate roomMate = new RoomMate();
        roomMate.doHomeWork(work, this);
    }


    @Override
    public void callBack(String answer) {
        System.out.println(answer + " put on the email!");
    }
}
