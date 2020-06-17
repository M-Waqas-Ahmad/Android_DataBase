package pk.talmeez.muhaamad500.studentmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DbHelper db;
    TextView tvSignUp;
    EditText etLoginUserName, etLoginUserPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        db = DbHelper.getInstance(this);
        Log.d("DATABASE", "database created");

        tvSignUp = findViewById(R.id.tvSignUp);
        etLoginUserName = findViewById(R.id.etLoginUserName);
        etLoginUserPass = findViewById(R.id.etLoginUserPassword);
        btnLogin = findViewById(R.id.btnLogin);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSignUpActivity = new Intent(Login.this, SigneUp.class);
                startActivity(goToSignUpActivity);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DATABASE" , "in onclick");
                if (!( etLoginUserName.getText().toString().equals("")) && !( etLoginUserPass.getText().toString().equals(""))) {
                    String user = etLoginUserName.getText().toString();
                    String pass = etLoginUserPass.getText().toString();


                    Log.d("DATABASE" , "in onclick data assigne to variables");
                    boolean loginConfirmed = db.loginValidation(user, pass);

                    if (loginConfirmed) {
                        Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                        Intent goToDashBord = new Intent(Login.this , Dashbord.class);
                        finish();
                        startActivity(goToDashBord);
                    } else {
                        Toast.makeText(Login.this, "User or Password incorrect ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Some fields are missing ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
