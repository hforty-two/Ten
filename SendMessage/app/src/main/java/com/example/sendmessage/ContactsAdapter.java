package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactsAdapter extends ArrayAdapter<Contacts> {

    private int resourceId;
    public ContactsAdapter(Context context, int textViewResourceId, List<Contacts> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Contacts contacts=getItem(position);//获取当前项的Laptop实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView contactsName=(TextView) view.findViewById(R.id.contacts_name);
        TextView contactsPhone=(TextView) view.findViewById(R.id.contacts_phone);
        contactsName.setText(contacts.getName());
        contactsPhone.setText(contacts.getPhone()+" ");
        return view;
    }
}