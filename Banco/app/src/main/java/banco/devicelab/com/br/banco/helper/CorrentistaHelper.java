package banco.devicelab.com.br.banco.helper;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import banco.devicelab.com.br.banco.R;
import banco.devicelab.com.br.banco.modelo.Correntista;

/**
 * Created by lucas on 04/08/2016.
 */
public class CorrentistaHelper {

    final EditText nome;
    final EditText senha;
    final EditText confirmaSenha;
    final EditText email;
    final TextView saldo;
    Correntista correntista;

    public CorrentistaHelper(Activity activity) {
        this.nome = (EditText) activity.findViewById(R.id.formulario_nome);
        this.senha = (EditText) activity.findViewById(R.id.formulario_senha);
        this.confirmaSenha = (EditText) activity.findViewById(R.id.formulario_senha_confirma);
        this.email = (EditText) activity.findViewById(R.id.formulario_email);
        this.saldo = (TextView) activity.findViewById(R.id.formulario_saldo_value);
        correntista = new Correntista();
    }

    public Correntista getCorrentista() {
        correntista.nome = nome.getText().toString();
        correntista.senha = senha.getText().toString();
        correntista.confirmaSenha = confirmaSenha.getText().toString();
        correntista.email = email.getText().toString();
        correntista.saldo = Double.valueOf(saldo.getText().toString());
        return correntista;
    }

//    public void preencheFormulario(Correntista aluno) {
//    }

    public void preencheCadastro(Correntista correntista) {
        this.nome.setText(this.correntista.nome);
        this.senha.setText(this.correntista.senha);
        this.confirmaSenha.setText(this.correntista.confirmaSenha);
        this.email.setText(this.correntista.email);
        this.saldo.setText(this.correntista.saldo.toString());
        this.correntista = this.correntista;
    }
}
