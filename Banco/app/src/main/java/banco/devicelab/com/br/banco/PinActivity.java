package banco.devicelab.com.br.banco;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PinActivity extends AppCompatActivity {

    private Button pinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);


        geraPin();


        pinButton = (Button) findViewById(R.id.button_novo_pin);
        pinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geraPin();
            }
        });

    }

    private void geraPin() {
        final int min = 0;
        final int max = 99999999;
        Random random = new Random();
        Integer pin = random.nextInt((max - min) + 1) + min;
        String numeroFormatado = String.format("%08d", pin);
        TextView pinText = (TextView) findViewById(R.id.token);
        pinText.setText(numeroFormatado);
    }
}
