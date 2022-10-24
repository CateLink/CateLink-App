package id.kharisma.studio.catelink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText lget_username, lget_password;

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
        lget_username = findViewById(R.id.edtlg_username);
        lget_password = findViewById(R.id.edtlg_password);

        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lget_username.getText().toString().equalsIgnoreCase() &&
                        lget_password.getText().toString().equalsIgnoreCase()) {
                    startActivity(new Intent(LoginActivity.this, .class));
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,
                            "Username atau Password Anda Salah", Toast.LENGTH_LONG).show();
                }
            }
        });*/

    }
}