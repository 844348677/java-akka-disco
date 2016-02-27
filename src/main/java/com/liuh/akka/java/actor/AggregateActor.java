package com.liuh.akka.java.actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.liuh.akka.java.messages.ReduceData;
import com.liuh.akka.java.messages.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuh on 2016/2/27.
 */
public class AggregateActor extends UntypedActor {
    private Map<String,Integer> finalReducedMap = new HashMap<String,Integer>();

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof ReduceData){
            ReduceData reduceData = (ReduceData) message;
            aggregateInMemoryReduce(reduceData.getReduceDataList());
        }else if(message instanceof Result){
            System.out.println(finalReducedMap.toString());

        }else
            unhandled(message);
    }

    private void aggregateInMemoryReduce(Map<String,Integer> reducedList){
        Integer count = null;
        for(String key : reducedList.keySet()){
            if(finalReducedMap.containsKey(key)){
                count = reducedList.get(key) + finalReducedMap.get(key);
                finalReducedMap.put(key,count);
            }else{
                finalReducedMap.put(key,reducedList.get(key));
            }
        }
    }

}
