//package com.future.akka
//
//import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
//
///**
//  * @author zcd
//  * @date 2019-07-31 16:45
//  */
//object StudentSimulatorApp extends App{
//  //init actor system ,name as "StudentSimulatorApp"
//  val actorSystem = ActorSystem("StudentSimulatorApp")
//
//  // 构建一个 TeacherActor 的 actor ref
//  val actorRef= actorSystem.actorOf(Props[TeacherActor])
//
//  //send a message to teacher actor
//  actorRef ! QuoteRequest("request1")
//
////  Thread.sleep(2000)
//
//  //close actor system or else jvm running
////  actorSystem.terminate()
//}
//
//case class QuoteRequest(name: String)
//
//class TeacherActor extends Actor with ActorLogging{
//
//
//
//  override def receive: Receive = {
//    case QuoteRequest(name) => println(s"receive name $name");
//  }
//}
