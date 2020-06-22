package com.block.employee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.block.employee.R;
import com.block.employee.model.Employee;

import java.util.ArrayList;

// 2. 상속.
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    // 3. 멤버변수 선언
    Context context;
    ArrayList<Employee> employeeArrayList;

    // 4. 생성자
    public RecyclerViewAdapter(Context context, ArrayList<Employee> employeeArrayList) {
        this.context = context;
        this.employeeArrayList = employeeArrayList;
    }

    // 5. 오버라이딩 함수 구현 - RecyclerViewAdapter.ViewHolder 로 함수 리턴값 변경
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_row, parent, false);
        return new ViewHolder(view);
    }

    // 6. RecyclerViewAdapter.ViewHolder 로 함수 파라미터 변경
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        // 어레이리스트에 저정된 데이터를 화면과 연결 : bind
        Employee employee = employeeArrayList.get(position);
        String name = employee.getName();
        int age = employee.getAge();
        int salary = employee.getSalary();

        holder.txtName.setText(name);
        holder.txtAge.setText("나이 : "+age + "세");
        holder.txtSalary.setText("연봉 : $" + salary);

    }

    // 7. 아이템갯수 리턴하는 메소드 구현
    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

    // 1. 뷰홀더 클래스 먼저 만든다.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtAge;
        public TextView txtSalary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtSalary = itemView.findViewById(R.id.txtSalary);
        }
    }

}








