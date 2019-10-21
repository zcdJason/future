package com.future.callback.example2;

public class RoomMate {
    public void  doHomeWork(String homework, AnswerRes answerPosition)
    {
        System.out.println("homework: " + homework);
        String answer = "";
        if(homework.equals("1+1"))
        {
            answer = "2";
        }else
        {
            System.out.println("I don't know!");
        }

        //将答案写到学生提供的地方
        answerPosition.callBack(answer);
    }
}
