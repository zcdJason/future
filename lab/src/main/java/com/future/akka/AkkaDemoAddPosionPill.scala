package com.future.akka

import akka.actor.{Actor, ActorSystem, PoisonPill, Props, Terminated}
import com.future.akka.AkkaDemo.talker

/**
  * @author zcd
  * @date 2019-07-31 15:04
  */
object AkkaDemo  extends App {
  val sys = ActorSystem("demo")
  val talker = sys.actorOf(Props[BetterMaster], "master")
}

//声明三种消息类型
case class SimpleGreet(name: String)
case class SimplePrase(name: String)
case class SimpleCelebrate(name: String , age:Int)

class SimpleTalker extends Actor{
  //接收使用模式匹配消息类型来处理
  override def receive: Receive = {
    case SimpleGreet(name) => println(s"name println: $name")
    case SimplePrase(name) => println(s"name println: $name")
    case SimpleCelebrate(name, age) => println(s"name println:$name, $age ")
  }
}


class BetterMaster extends Actor{
val talker = context.actorOf(Props[SimpleTalker], "slaver")
  override def preStart{
    context.watch(talker)
    //发送三种不同到消息
    talker ! SimpleGreet("tiger")
    talker ! SimplePrase("new tiger")
    talker ! SimpleCelebrate("tiger", 18)
    //发送一个毒丸，告诉actor已经结束了。因此后面发送的消息将不会被传递
    talker ! PoisonPill
    talker ! SimpleGreet("extend messge")
  }

  override def receive: Receive = {
    case Terminated(`talker`) => context.system.terminate()
  }
}
