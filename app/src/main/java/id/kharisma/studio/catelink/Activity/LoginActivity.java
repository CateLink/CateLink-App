package id.kharisma.studio.catelink.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import id.kharisma.studio.catelink.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText lget_email, lget_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Custom image for action bar
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_actionbar_image, null);
        actionBar.setCustomView(view);
        // Custom image for action bar

        btnLogin = findViewById(R.id.btn_login);
        lget_email = findViewById(R.id.edtlg_email);
        lget_password = findViewById(R.id.edtlg_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Inisialisasi data ke dalam Var
                String Email = lget_email.getText().toString();
                String Pass = lget_password.getText().toString();

                if (cek_Lgn(Email, Pass) == true) {
                    LogAcc(Email, Pass); // Masuk menggunakan akun pd database
                }
            }

        });
    }


    //Memastikan pengisian data sdh sesuai ketentuan
    public boolean cek_Lgn(String Email, String Pass) {

        //Memberikan tanda dan mengarahkan pada data yang belum di isi
        if (Pass.isEmpty()) {
            lget_password.setError("Password Required");
            lget_password.requestFocus();
        }
        if (Email.isEmpty()) {
            lget_email.setError("Email Required");
            lget_email.requestFocus();
        }

        // Mengecek apabila ada yang belum diisi
        if (Email.isEmpty() || Pass.isEmpty()) {
            return false;
        } else {
            // Memastikan email berformat email
            if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                lget_email.setError("Email is invalid");
                Toast.makeText(LoginActivity.this,
                        "Email tidak sesuai", Toast.LENGTH_LONG).show();
                return false;
            }
            // Memastikan kata sandi tidak kurang dari 6 karakter
            if (Pass.length() < 6) {
                lget_password.setError("Password is invalid");
                Toast.makeText(LoginActivity.this,
                        "Kata sandi belum sampai 6 karakter", Toast.LENGTH_LONG).show();
                return false;
            } else {
                return true;
            }
        }
    }

    // Masuk akun Database
    public void LogAcc(String Email, String Pass) {

        FirebaseAuth firebaseauth = FirebaseAuth.getInstance();

        firebaseauth.signInWithEmailAndPassword(Email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult()!=null){
                    // Berhasil Login
                    startActivity(new Intent(LoginActivity.this, Home_catemenuActivity.class));
                    finish();
                } else {
                    // Gagal Login
                    Toast.makeText(LoginActivity.this,
                            task.getException().getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            }

        });

    }

}