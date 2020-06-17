package pk.talmeez.muhaamad500.studentmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigneUp extends AppCompatActivity {

    EditText etFirstName , etSeconName ,etEmail , etUserName ,etPassword;
    Button btnSignUp;
    UserLogingModule user ;
    DbHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        db = DbHelper.getInstance(this);
        etFirstName = findViewById(R.id.etUserFirstName);
        etSeconName = findViewById(R.id.etUserSecondName);
        etEmail = findViewById(R.id.etUserEmail);
        etUserName = findViewById(R.id.etLoginUserName);
        etPassword = findViewById(R.id.etLoginPassword);

        btnSignUp = findViewById(R.id.btnSignUp);
        user = new UserLogingModule();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(etFirstName.getText().toString().equals("") || etSeconName.getText().toString().equals("") ||
                    etUserName.getText().toString().equals("") || etEmail.getText().toString().equals("") ||
                    etPassword.getText().toString().equals("")){
                   Toast.makeText(SigneUp.this  ,"Some Fields are empty" ,Toast.LENGTH_SHORT).show();
               }else{
                   user.setFirstName(etFirstName.getText().toString());
                   user.setSecondName(etSeconName.getText().toString());
                   user.setEmail(etEmail.getText().toString());
                   user.setUserName(etUserName.getText().toString());
                   user.setPassword(etPassword.getText().toString());
                   boolean insertionformation = db.insertUserLoginData(user);
                   if(insertionformation == true){
                       Toast.makeText(SigneUp.this , "SignUp Successfully" ,Toast.LENGTH_SHORT).show();
                       etFirstName.setText("");
                       etSeconName.setText("");
                       etEmail.setText("");
                       etUserName.setText("");
                       etPassword.setText("");
                       Intent goToLoginActivity = new Intent(SigneUp.this , Login.class);
                       startActivity(goToLoginActivity);

                   }else{
                       Toast.makeText(SigneUp.this , " SignUp Failed" , Toast.LENGTH_SHORT).show();
                   }

               }

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
