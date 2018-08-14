package com.example.minhd.hsumanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ControlActivity extends AppCompatActivity {

    RecyclerView rvFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        initializeActivity();

    }

    private void initializeActivity(){
        rvFunction=(RecyclerView)findViewById(R.id.rv_function);
        rvFunction.setHasFixedSize(true);

        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        rvFunction.setLayoutManager(layoutManager);

        ArrayList<DataFunction> dataFunctions=new ArrayList<>();
        dataFunctions.add(new DataFunction(R.drawable.ic_calendar,"Thời khóa biểu"));
        dataFunctions.add(new DataFunction(R.drawable.ic_exam,"Xem điểm"));
        dataFunctions.add(new DataFunction(R.drawable.ic_calendarcheck,"Chuyên cần"));
        dataFunctions.add(new DataFunction(R.drawable.ic_timer,"Lịch thi"));
        dataFunctions.add(new DataFunction(R.drawable.ic_test,"Điểm danh trực tuyến"));
        dataFunctions.add(new DataFunction(R.drawable.ic_money,"Học phí"));
        dataFunctions.add(new DataFunction(R.drawable.ic_bell,"Thông báo"));
        dataFunctions.add(new DataFunction(R.drawable.ic_piggy_bank,"Tài khoản Photo"));
        dataFunctions.add(new DataFunction(R.drawable.ic_edit,"Khảo sát"));
        dataFunctions.add(new DataFunction(R.drawable.ic_call,"Liên hệ"));
        dataFunctions.add(new DataFunction(R.drawable.ic_question,"Giới thiệu"));
        dataFunctions.add(new DataFunction(R.drawable.ic_logout,"Thoát"));

        FunctionAdapter functionAdapter=new FunctionAdapter(dataFunctions,this);
        rvFunction.setAdapter(functionAdapter);
    }
}
