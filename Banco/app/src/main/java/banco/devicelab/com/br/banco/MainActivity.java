package banco.devicelab.com.br.banco;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button) findViewById(R.id.main_button_login);
        if (login != null) {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
        }

        Button cadastro = (Button) findViewById(R.id.main_button_cadastro);
        if (cadastro != null) {
            cadastro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                    startActivity(intent);
                }
            });
        }

        Button chaveSeguranca = (Button) findViewById(R.id.main_button_pin);
        if (chaveSeguranca != null) {
            chaveSeguranca.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PinActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
