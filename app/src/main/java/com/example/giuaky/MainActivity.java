package com.example.giuaky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.TextView;

import com.example.giuaky.Adapter;
import com.example.giuaky.So;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText edtA ,edtB;
    TextView txtKQ;
    Button BTNtinh;

    ListView lvKQ;
    ArrayList<So> dsKQ;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add();
        addEvents();
    }

    private void addEvents() {


        lvKQ.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dsKQ.remove(position);
                adapter.notifyDataSetChanged();
            }
        });



        BTNtinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float a = Integer.parseInt(edtA.getText().toString());
                float b = Integer.parseInt(edtB.getText().toString());
                float kq = a/b;
                txtKQ.setText((String.valueOf(a))+(String.valueOf("/"))+(String.valueOf(b))+(String.valueOf("="))+(String.valueOf(kq)));



                So so = new So(
                        edtA.getText().toString(),
                        edtB.getText().toString(),
                        txtKQ.getText().toString()
                );

                dsKQ.add(so);
                Adapter.notifyDataSetChanged();
            }
        });
    }

    private void add(){
        edtA =(EditText)findViewById(R.id.edt_textA);
        edtB =(EditText)findViewById(R.id.edt_textB);
        txtKQ =(TextView)findViewById(R.id.txt_kq);
        BTNtinh= (Button)findViewById(R.id.btn_tinh);
//


        lvKQ = (ListView) findViewById(R.id.lv_id);
        dsKQ = new ArrayList<>();
        Adapter = new Adapter(MainActivity.this, R.layout.item_mt,dsKQ);
        lvKQ.setAdapter(Adapter);


    }

}

