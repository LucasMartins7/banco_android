package banco.devicelab.com.br.banco.helper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import banco.devicelab.com.br.banco.R;

/**
 * Created by lucas on 03/08/2016.
 */
public class SeekBarHelper extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        SeekBar seekBar = (SeekBar) findViewById(R.id.formulario_saldo_bar);
        seekBar.setMax(10000);
        final TextView seekBarValue = (TextView) findViewById(R.id.formulario_saldo_value);
        seekBarValue.setText("0");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
