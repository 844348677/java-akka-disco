package com.liuh.akka.java.actor;

import akka.actor.*;
import com.liuh.akka.java.messages.Result;

/**
 * Created by liuh on 2016/2/27.
 */
public class MasterActor extends UntypedActor {

    private ActorRef aggregateActor = getContext().actorOf(
            new Props(AggregateActor.class),"aggregate");

    private ActorRef reduceActor = getContext().actorOf(
            new Props(new UntypedActorFactory(){
                public UntypedActor create(){
                    return new MapActor(aggregateActor);
                }
            }),"reduce");

    private ActorRef mapActor = getContext().actorOf(
            new Props(new UntypedActorFactory(){

                @Override
                public Actor create() {
                    return new MapActor(reduceActor);
                }
            }),"map");


    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof  String){
            mapActor.tell(message);
            System.out.println("发送的string类型数据");
        }else if(message instanceof Result){
            aggregateActor.tell(message);
        }else {
            unhandled(message);
        }
    }
}
