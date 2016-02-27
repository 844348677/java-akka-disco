package com.liuh.akka.java.messages;

import java.util.List;

/**
 * Created by liuh on 2016/2/27.
 */
public class MapData {

    private List<WordCount> dataList; //用来MapActor 处理完数据存储在MapData中的

    public List<WordCount> getDataList() {
        return dataList;
    }

    public void setDataList(List<WordCount> dataList) {
        this.dataList = dataList;
    }
}
