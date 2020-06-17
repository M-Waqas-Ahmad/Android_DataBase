package pk.talmeez.muhaamad500.studentmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class AddNewStudent extends AppCompatActivity {

    TextView tvStudentAddTittle;
    EditText etStdRno, etStdName, etStdFatherName, etStdTotalFee;
    Button btnAddNewStudentRecord;
    String rno;
    StudenModule s;

    DbHelper db;
    private static Random rollNumber = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_student_activity);
        tvStudentAddTittle = findViewById(R.id.tvAddStudentTittle);
        etStdRno = findViewById(R.id.etStdRno);
        etStdName = findViewById(R.id.etStdName);
        etStdFatherName = findViewById(R.id.etStdFatherName);
        etStdTotalFee = findViewById(R.id.etStdTotalFee);
        btnAddNewStudentRecord = findViewById(R.id.btnAddStudentRecord);
        db = DbHelper.getInstance(AddNewStudent.this);
        s = new StudenModule();
        Log.d("Add New Student ", "in new student activity");


        rno = rollNumberGenerator();


        Log.d("DASHBOARD", "Roll number generated");
        etStdRno.setText(rno);
        Log.d("DASHBOARD", "Rno has been set to editText");
        etStdRno.setEnabled(false);
        Log.d("DASHBOARD", "rNo et is now disable");

        btnAddNewStudentRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(etStdName.getText().toString().equals("")) && !(etStdFatherName.getText().toString().equals("")) && !(etStdTotalFee).getText().toString().equals("")) {

                    s.setStdRollNumber(rno);
                    s.setStdName(etStdName.getText().toString());
                    s.setStdFatherName(etStdFatherName.getText().toString());
                    s.setStdTotalFee(Float.parseFloat(etStdTotalFee.getText().toString()));

                    boolean recordAdded = db.insertStudentData(s);
                    if (recordAdded) {
                        Toast.makeText(AddNewStudent.this, "New Record added", Toast.LENGTH_SHORT).show();
                        rno = rollNumberGenerator();
                        etStdRno.setText(rno);
                        etStdRno.setEnabled(false);
                        etStdName.setText("");
                        etStdFatherName.setText("");
                        etStdTotalFee.setText("");
                    } else {
                        Toast.makeText(AddNewStudent.this, "Failed to add record", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddNewStudent.this, "Some fields are missing", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public String rollNumberGenerator() {
        String rno;
        boolean rnoConfirmed;
        do {
            rno = "CAS-" + rollNumber.nextInt(2000);
            rnoConfirmed = db.studentRollNumberValidator(rno);
        } while (!(rnoConfirmed));

        return rno;


    }
}

