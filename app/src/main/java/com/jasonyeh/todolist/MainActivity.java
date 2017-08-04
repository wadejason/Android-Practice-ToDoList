package com.jasonyeh.todolist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jasonyeh.todolist.models.Todo;
import com.jasonyeh.todolist.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Fab clicked", Toast.LENGTH_LONG).show();
            }
        });

        setupUI(mockData());
    }

    private void setupUI(@NonNull List<Todo> todos) {
        ListView listView = (ListView) findViewById(R.id.main_list_view);
        listView.setAdapter(new TodoListConverter(this, todos));
    }

// crappy_list_refactored
//    private void setupUI(@NonNull List<Todo> todos) {
//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.crappy_list);
//        linearLayout.removeAllViews();
//
//        TodoListConverter converter = new TodoListConverter(this, todos);
//
//        for (int i = 0; i < todos.size(); ++i) {
//            View view = converter.getView(i);
//            linearLayout.addView(view);
//        }
//    }

    // crappy_list
//    private void setupUI(@NonNull List<Todo> todos) {
//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.crappy_list);
//        linearLayout.removeAllViews();
//
//        for (Todo todo : todos) {
//            View view = getListItemView(todo);
//            linearLayout.addView(view);
//        }
//    }
//
//    @NonNull
//    private View getListItemView(@NonNull Todo todo) {
//        View view = getLayoutInflater().inflate(R.layout.main_list_item, null);
//        ((TextView) view.findViewById(R.id.main_list_item_text)).setText(todo.text);
//        return view;
//    }

    @NonNull
    private List<Todo> mockData() {
        // Lazy Load
        List<Todo> list = new ArrayList<>();
        for (int i = 0; i < 1000; ++i) {
            list.add(new Todo("todo " + i, DateUtils.stringToDate("2017 8 21 0:00")));
        }
        return list;
    }
}
