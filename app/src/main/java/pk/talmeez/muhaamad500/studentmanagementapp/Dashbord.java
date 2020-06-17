package pk.talmeez.muhaamad500.studentmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashbord extends AppCompatActivity {

    ImageView ivSlide ;
    TextView tvWelcomeText ;
    Button btnShowStudentData , btnAddNewStudent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashbord_activity);
        ivSlide = findViewById(R.id.ivSlide);
        tvWelcomeText = findViewById(R.id.tvWelcomeText);
        btnShowStudentData = findViewById(R.id.btnShowStudent);
        btnAddNewStudent = findViewById(R.id.btnAddNewStd);


        btnShowStudentData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRecyclerViewActivity = new Intent(Dashbord.this , StudentRecycleViewDataDisp.class);
                startActivity(goToRecyclerViewActivity);
            }
        });

        btnAddNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DASHBOARD" , "add new student btn clicked");
                Intent goToAddNewStudentActivity = new Intent(Dashbord.this , AddNewStudent.class);
                Log.d("DASHBOARD" , "going from dash board to add student activity");

                startActivity(goToAddNewStudentActivity);

                Log.d("DASHBOARD" , "gone to new student activity");
            }
        });
    }
}
