package com.liuh.akka.java.actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.UntypedActorFactory;

/**
 * Created by liuh on 2016/2/27.
 */
public class MasterActor extends UntypedActor {

    private ActorRef mapActor = getContext().actorOf(
            new Props(new UntypedActorFactory(){
                public UntypedActor create(){
                    //return new MapActor();
                }
            })
    );


    @Override
    public void onReceive(Object message) throws Exception {

    }
}
