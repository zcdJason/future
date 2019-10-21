package com.future.callback.example2;

public class Student implements AnswerRes {
//    /**
//     * 学生自己做作业
//     * @param homework
//     * @return
//     */
//    public String  doHomeWork(String homework)
//    {
//        System.out.println("homework: " + homework);
//        String answer = "";
//        if(homework.equals("1+1"))
//        {
//             answer = "2";
//            return answer;
//        }else
//        {
//            System.out.println("I don't know!");
//            return answer;
//        }
//    }

//    /**
//     * 学生有作业，但是打游戏去了，作业给室友（爱学习的） 的做，做好以后告诉我答案就行
//     * @param homework
//     * @return
//     */
//    public String  doHomeWork(String homework)
//    {
//        RoomMate roomMate = new RoomMate();
//       return roomMate.doHomeWork(homework);
//    }

    /**
     * 学生有作业，但是打游戏去了，作业给室友（爱学习的） 的做，做好以后,直接写到我的作业本，不需要我自己拿到答案以后再写一片
     * @param homework
     * @return
     */
    public void  doHomeWork(String homework)
    {
        RoomMate roomMate = new RoomMate();
        roomMate.doHomeWork(homework,this);
    }

    @Override
    public void callBack(String answer) {
        System.out.println(answer + " put on desktop");
    }
}
