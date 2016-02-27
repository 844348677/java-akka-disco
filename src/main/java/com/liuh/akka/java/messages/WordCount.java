package com.liuh.akka.java.messages;

/**
 * Created by liuh on 2016/2/27.
 */
public class WordCount {

    private String word;  //单词本身
    private Integer count; //单词计数

    public WordCount(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {

        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
