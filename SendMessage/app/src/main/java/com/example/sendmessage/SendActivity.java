package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class SendActivity extends AppCompatActivity {

    private List<Msg> msgList=new ArrayList<>();
    private Button send;
    private EditText inputText;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        initView();//初始化UI控件
        initdata();//初始化数据
        Button button=(Button) findViewById(R.id.photo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SendActivity.this,PhotoActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initView(){
        inputText=(EditText) findViewById(R.id.input_text);
        send=(Button) findViewById(R.id.send);
        msgRecyclerView=(RecyclerView) findViewById(R.id.msg_recycler_view);
    }
    private void initdata(){
        initmessage();//初始化信息
        LinearLayoutManager layoutManager=new LinearLayoutManager(SendActivity.this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
    }
    private void initmessage(){
        Msg msg1=new Msg("你好",Msg.TYPE_RECEIVE);
        msgList.add(msg1);
        Msg msg2=new Msg("我很好你呢？",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3=new Msg("我也不错。",Msg.TYPE_RECEIVE);
        msgList.add(msg3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    //如果字符串不为空，则创建Msg对象
                    Msg msg=new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);//当有新消息是刷新RecyclerView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size()-1);//将RecyclerView定位在最后一行
                    inputText.setText("");//清空输入框的内容
                    inputText.requestFocus();//输入光标回到输入框中
                }
            }
        });
    }
}