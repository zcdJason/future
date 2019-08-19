package com.future.akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * @author zcd
  * @date 2019-07-31 15:04
  */
object AkkaDemo  extends App {
  val sys = ActorSystem("demo")
  val talker = sys.actorOf(Props[SimpleTalker], "talker")

  //发送三种不同到消息
  talker ! SimpleGreet("tiger")
  talker ! SimplePrase("new tiger")
  talker ! SimpleCelebrate("tiger", 18)
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
