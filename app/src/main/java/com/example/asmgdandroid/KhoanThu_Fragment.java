package com.example.asmgdandroid;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asmgdandroid.database.DB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class KhoanThu_Fragment extends Fragment {
    private DB db;
    private Cursor cursor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.khoanthu_fragment,container,false);

        db=new DB(getContext());


        final Calendar calendar=Calendar.getInstance();

        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               long a= db.insert("Bây giờ là :"+calendar.getTimeInMillis());
                Log.e("POSION",a+"");

            }
        });

        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getDB();
            }
        });








        return view;
    }


    private void getDB(){
        cursor=db.getData();
        if (cursor!=null && cursor.moveToFirst()){

            do {
                //id là 0 còn khoanthu la 1
                String a=cursor.getString(1);
                Toast.makeText(getContext(), a, Toast.LENGTH_SHORT).show();
                Log.e("Data",a+"");
            }while (cursor.moveToNext());

        }
        else {
            Toast.makeText(getContext(), "NOT NULL", Toast.LENGTH_SHORT).show();
        }
    }
}
