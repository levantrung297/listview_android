package com.htnsoft.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Khai bao list view
    ListView listviewmonhoc;

    //Khai bao editext Môn Học
    EditText edtMonHoc;

    //Khai Báo Buttom thêm
    Button btnThem;
    // Khai báo button cập nhật
    Button btnCapNhat;
    //Khai bang mang doi tuong can hien thi
    ArrayList <String> arrayCourse;

    //Khai bao adapter
    ArrayAdapter adapter;

    private  Integer vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa listview
        listviewmonhoc = (ListView) findViewById(R.id.listviewmonhoc);
        //Anh Xa editext Mon Hoc
        edtMonHoc = (EditText) findViewById(R.id.edtMonHoc);
        //Ánh xạ Buttom Thêm Môn Học
        btnThem = (Button) findViewById(R.id.btnThem);
        //Ánh Xạ Button Cập nhật Môn Học
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);

        //Khoi tao mang doi tuong
        arrayCourse = new ArrayList<>();
        //Gan doi tuong vao mang
        arrayCourse.add("Android");
        arrayCourse.add("PHP");
        arrayCourse.add("IOS");
        arrayCourse.add("ASP.NET");
        //Khoi tao adtapter gom 3 tham so
        // Man hinh, loai layout, mang truyen vao
        adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayCourse);
       // gan adapter vao listview
        listviewmonhoc.setAdapter(adapter);

        // Bắt sự kiện vừa click vào
        // Bắt sự kiện trên từng dòng khi nhấn 1 lần
        listviewmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position : Trả về vị trí click trên list view ->0;
                Toast.makeText(MainActivity.this,"" + position + arrayCourse.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        /*
        // Bắt sự kiện chạm và giữ
        listviewmonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Long Click" + position + " " + arrayCourse.get(position),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        */
        //Them du lieu vao listview

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Thêm dữ liệu vào mảng array

                String monhoc = edtMonHoc.getText().toString();
                arrayCourse.add(monhoc);

                //Cập nhật dữ liệu vào adapter
                adapter.notifyDataSetChanged();
            }
        });

        //Cập nhật dữ liệu vào listview

        listviewmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtMonHoc.setText(arrayCourse.get(position));
                vitri = position;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(vitri,edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        //Xóa dữ liệu trên listview
        listviewmonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Bạn đã xóa: "+ arrayCourse.get(position),Toast.LENGTH_SHORT).show();
                arrayCourse.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}
