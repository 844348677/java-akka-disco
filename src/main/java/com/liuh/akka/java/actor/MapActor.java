package com.liuh.akka.java.actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.liuh.akka.java.messages.MapData;
import com.liuh.akka.java.messages.WordCount;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by liuh on 2016/2/27.
 */
public class MapActor extends UntypedActor {

    private ActorRef reduceActor = null;

    String[] STOP_WORDS = {"a","is"};

    private List<String> STOP_WORDS_LIST = Arrays.asList(STOP_WORDS);

    public ActorRef getReduceActor() {
        return reduceActor;
    }

    public void setReduceActor(ActorRef reduceActor) {
        this.reduceActor = reduceActor;
    }

    public MapActor(ActorRef reduceActor) {
        this.reduceActor = reduceActor;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof String){
            String work = (String) message;

            MapData data = evaluateExpression(work);  //用下面的方法来解决一行语句

            reduceActor.tell(data);

        }else
            unhandled(message);
    }

    private MapData evaluateExpression(String line){
        List<WordCount> dataList = new ArrayList<WordCount>();
        StringTokenizer parser = new StringTokenizer(line);
        while(parser.hasMoreTokens()){
            String word = parser.nextToken().toLowerCase();
            if(!STOP_WORDS_LIST.contains(word)){
                dataList.add(new WordCount(word,Integer.valueOf(1)));
            }
        }
        return new MapData(dataList);
    }
}
