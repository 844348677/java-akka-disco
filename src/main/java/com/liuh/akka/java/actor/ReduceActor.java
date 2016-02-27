package com.liuh.akka.java.actor;

import akka.actor.ActorRef;

/**
 * Created by liuh on 2016/2/27.
 */
public class ReduceActor {

    private ActorRef aggregateActor = null;

    public ReduceActor(ActorRef aggregateActor) {
        this.aggregateActor = aggregateActor;
    }

    public void onReceive(Object message) throws Exception{
        if(message)
    }
}
