package com.example.todod06k14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvTodos;
    private ArrayAdapter<String> adapter;
    private List<String> dataSource;
    private TodoDialog todoDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTodos = findViewById(R.id.lv_todos);
        // Kiem tra xem listview da hoat dong hay chua?
        dataSource = new ArrayList<>();
        dataSource.add("1. Hoc bai");
        dataSource.add("2. Di cho");
        // Tao adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSource);
        // Set Adapter cho listview
        lvTodos.setAdapter(adapter);

        // Lang nghe su kien nhan giua
        lvTodos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dataSource.remove(position);
                adapter.notifyDataSetChanged();// render lai listview
                Toast.makeText(MainActivity.this, "Xoa thanh cong",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    public void showDialog(View view) {
        // Tao va hien thi dialg todo
        if(todoDialog == null){
            todoDialog = new TodoDialog(this) {
                @Override
                public void getTodo(String todo) {
                    // Them vao datasource -> bao cho adapter du lieu thay doi
                    dataSource.add(todo);
                    adapter.notifyDataSetChanged();
                }
            };
            todoDialog.setCancelable(false);
        }
        todoDialog.show();
    }
}