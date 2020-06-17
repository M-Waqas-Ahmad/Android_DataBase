package pk.talmeez.muhaamad500.studentmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentRecycleViewDataDisp extends AppCompatActivity {

    TextView tvStdRvTittle ;
    RecyclerView rvStudent;


    List<StudenModule> studentData = new ArrayList<>();
    StudentRecycleViewAdapter myadapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        studentData = DbHelper.getInstance(getApplicationContext()).getAllStudents();
        setContentView(R.layout.student_recycle_view_data_disp_activity);
        tvStdRvTittle = findViewById(R.id.tvStdRvTittle);
        rvStudent = findViewById(R.id.rvStudents);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        myadapter = new StudentRecycleViewAdapter(studentData);

        rvStudent.setLayoutManager(layoutManager);
        rvStudent.setAdapter(myadapter);



    }
}
