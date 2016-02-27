package com.liuh.akka.java;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.liuh.akka.java.actor.MasterActor;

/**
 * Created by liuh on 2016/2/27.
 */
public class HelloAkka {
    public static void main(String[] args) throws Exception{

        ActorSystem _system = ActorSystem.create("HelloAkka");

        //ActorRef master = _system.actorOf(new Props(MasterActor.class),"master");


    }
}
