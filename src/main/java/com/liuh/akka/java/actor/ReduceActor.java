package com.liuh.akka.java.actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.liuh.akka.java.messages.MapData;
import com.liuh.akka.java.messages.ReduceData;
import com.liuh.akka.java.messages.WordCount;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liuh on 2016/2/27.
 */
public class ReduceActor  extends UntypedActor{

    private ActorRef aggregateActor = null;

    public ReduceActor(ActorRef aggregateActor) {
        this.aggregateActor = aggregateActor;
    }

    @Override
    public void onReceive(Object message) throws Exception{
        if(message instanceof MapData){
            System.out.println("reduceReceive");
            MapData mapData = (MapData) message;

            ReduceData reduceData = reduce(mapData.getDataList()); //获取里面的数据进行reduce操作

            aggregateActor.tell(reduceData);
            System.out.println(reduceData.getReduceDataList());
        }else
            unhandled(message);
    }

    private ReduceData reduce(List<WordCount> dataList){
        HashMap<String,Integer> reducedMap = new HashMap<String, Integer>();
        for(WordCount wordCount : dataList){
            if(reducedMap.containsKey(wordCount.getWord())){
                Integer value = (Integer) reducedMap.get(wordCount.getWord());
                value ++;
                reducedMap.put(wordCount.getWord(),value);
            }else{
                reducedMap.put(wordCount.getWord(),Integer.valueOf(1));
            }
        }
        return new ReduceData(reducedMap);
    }


}
