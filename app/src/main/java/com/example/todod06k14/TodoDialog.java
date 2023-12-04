package com.example.todod06k14;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

public abstract class TodoDialog extends Dialog {

    private TextView tvCancel;
    private Button btnYes;
    private EditText edtTodo;

    public abstract void getTodo(String todo);

    public TodoDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_todo);
        tvCancel = findViewById(R.id.tv_cancel);
        btnYes = findViewById(R.id.btn_yes);
        edtTodo = findViewById(R.id.edt_dialog_todo);

        // Bat su kien onclick
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lay du lieu tu EditText
                String todo = edtTodo.getText().toString();

                // Gui du lieu ve MainActivity
                getTodo(todo);
                // An dialog
                dismiss();
            }
        });
    }

    @Override
    public void dismiss() {
        super.dismiss();
        edtTodo.setText("");
    }
}
