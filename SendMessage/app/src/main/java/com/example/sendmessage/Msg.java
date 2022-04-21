package com.example.sendmessage;

public class Msg {
    //这是type类型的值
    public static final int TYPE_RECEIVE=0;//表示收到的一条信息
    public static final int TYPE_SEND=1;//表示发出的一条信息
    //content表示消息的内容，type表示消息的类型
    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
