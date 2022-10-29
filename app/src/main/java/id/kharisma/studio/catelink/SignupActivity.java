package id.kharisma.studio.catelink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private Button btnSignup;
    private EditText sget_email, sget_username, sget_notelpon, sget_password;
    private RadioButton rb_male, rb_female, rb_others;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Custom image for action bar
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_actionbar_image, null);
        actionBar.setCustomView(view);
        // Custom image for action bar

        btnSignup = findViewById(R.id.btn_signup);
        sget_email = findViewById(R.id.edtsg_email);
        sget_username = findViewById(R.id.edtsg_username);
        sget_notelpon = findViewById(R.id.edtsg_notelpon);
        sget_password = findViewById(R.id.edtsg_password);
        rb_male = findViewById(R.id.btn_male);
        rb_female = findViewById(R.id.btn_female);
        rb_others = findViewById(R.id.btn_others);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = sget_email.getText().toString();
                String Username = sget_username.getText().toString();
                String Notelpon = sget_notelpon.getText().toString();
                String Pass = sget_password.getText().toString();
                String JenisKelamin;

                JenisKelamin = onRadioButtonClicked();

                if (cek_Sgn(Email, Username, Notelpon, Pass, JenisKelamin) == true) {
                    createAcc(Email, Username, Notelpon, Pass, JenisKelamin);
                }

            }
        });
    }

    // Memastikan pengisian data sesuai ketentuan
    public boolean cek_Sgn (String Email, String Username, String Notelpon, String Pass, String
            JenisKelamin){

        return true;
    }

    // Menambahkan akun pada database
    public void createAcc (String Email, String Username, String Notelpon, String Pass, String
            JenisKelamin){

        FirebaseAuth firebaseauth = FirebaseAuth.getInstance();

        firebaseauth.createUserWithEmailAndPassword(Email, Pass).addOnCompleteListener(
                SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Akun berhasil dibuat
                            firebaseauth.getCurrentUser().sendEmailVerification(); // Mengirim notif ke email
                            firebaseauth.signOut(); // Keluar dr akun

                            // Menuju hal home
                            startActivity(new Intent(SignupActivity.this, Home_catemenuActivity.class));
                            finish();
                        } else {
                            // Akun gagal dibuat
                            Toast.makeText(SignupActivity.this,
                                    task.getException().getLocalizedMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }

    public String onRadioButtonClicked() {
        // Is the button now checked?
        String nilai = null;

        if (rb_male.isChecked()) {
            nilai = "Pria";
        }
        if (rb_female.isChecked()) {
            nilai = "Wanita";
        }
        if (rb_others.isChecked()) {
            nilai = "Lainnya";
        }
        return nilai;
    }
}
