package id.kharisma.studio.catelink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private Button btnSignup;
    private EditText sget_email, sget_username, sget_notelpon,sget_password;


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

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = sget_email.getText().toString();
                String Username = sget_username.getText().toString();
                String Notelpon = sget_notelpon.getText().toString();
                String Pass = sget_password.getText().toString();

                if (Email.equals("") || Username.equals("") || Notelpon.equals("") || Pass.equals("")) {
                    Toast.makeText(SignupActivity.this,
                            "Data yang anda masukkan belum lengkap", Toast.LENGTH_LONG).show();
                }

                //Untuk simpan data ke Database

            }
        });

    }
}