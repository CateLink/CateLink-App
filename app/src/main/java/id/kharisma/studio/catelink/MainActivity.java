package id.kharisma.studio.catelink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cardLogin, cardSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengganti warna status bar di spesifik activity start

        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.shadowbrown));

        // Mengganti warna status bar di spesifik activity end

        cardLogin = findViewById(R.id.cardLogin);
        cardSignup = findViewById(R.id.cardSignup);

        // Menghubungkan ke login activity start

        cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Menghubungkan ke login activity end


        // Menghubungkan ke signup activity start

        cardSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        // Menghubungkan ke signup activity end




    }
}