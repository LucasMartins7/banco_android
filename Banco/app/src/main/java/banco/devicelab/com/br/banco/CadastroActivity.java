package banco.devicelab.com.br.banco;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import banco.devicelab.com.br.banco.dao.CorrentistaDAO;
import banco.devicelab.com.br.banco.helper.CorrentistaHelper;
import banco.devicelab.com.br.banco.modelo.Correntista;

public class CadastroActivity extends AppCompatActivity {

    private CorrentistaHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        SeekBarUpdate();

        helper = new CorrentistaHelper(this);

        Intent intent = getIntent();
        Correntista correntista = (Correntista) intent.getSerializableExtra("correntista");
        if (correntista != null) {
            helper.preencheCadastro(correntista);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_cartoes, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Correntista correntista = helper.getCorrentista();
                CorrentistaDAO dao = new CorrentistaDAO(this);

//                if(correntista != null) {
//                        dao.altera(correntista);
//                } else {
//                    dao.insere(correntista);
//                }

                dao.insere(correntista);
                dao.close();

                Toast.makeText(CadastroActivity.this, "Correntista " + correntista.nome + " salvo!",
                        Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void SeekBarUpdate() {
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
