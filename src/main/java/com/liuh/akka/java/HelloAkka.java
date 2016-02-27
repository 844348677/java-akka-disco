package com.liuh.akka.java;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.liuh.akka.java.actor.MasterActor;
import com.liuh.akka.java.messages.Result;

/**
 * Created by liuh on 2016/2/27.
 */
public class HelloAkka {
    public static void main(String[] args) throws Exception{

        ActorSystem _system = ActorSystem.create("HelloAkka");

        ActorRef master = _system.actorOf(new Props(MasterActor.class),"master");

        master.tell("hi hi hi");
        master.tell("hello hello hello hello");
        master.tell("liuh");

        Thread.sleep(5000);

        master.tell(new Result());

        Thread.sleep(5000);

        _system.shutdown();


    }
}
