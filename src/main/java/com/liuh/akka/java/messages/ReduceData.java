package com.liuh.akka.java.messages;

import java.util.HashMap;

/**
 * Created by liuh on 2016/2/27.
 */
public class ReduceData {

    private HashMap<String,Integer> reduceDataList;  //localreduce combaner  对map产生的数据进行本地的统计 产生统计数据，integer是次数

    public HashMap<String, Integer> getReduceDataList() {
        return reduceDataList;
    }

    public void setReduceDataList(HashMap<String, Integer> reduceDataList) {
        this.reduceDataList = reduceDataList;
    }
}
