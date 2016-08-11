package banco.devicelab.com.br.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import banco.devicelab.com.br.banco.modelo.Correntista;

/**
 * Created by lucas on 03/08/2016.
 */
public class CorrentistaDAO extends SQLiteOpenHelper{
    public CorrentistaDAO(Context context) {
        super(context, "Banco", null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Correntista(" +
                "id INTEGER PRIMARY KEY," +
                "nome TEXT NOT NULL," +
                "senha TEXT,"+
                "email TEXT,"+
                "saldo NUMBER);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Correntista";
        db.execSQL(sql);
        onCreate(db);
    }


    public void insere(Correntista correntista) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getValuesCorrentista(correntista);

        db.insert("Correntista", null, dados);
    }

//    public void altera(Correntista correntista) {
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues dados = getValuesCorrentista(correntista);
//
//        String[] params = {correntista.id.toString()};
//        db.update("correntistas", dados, "id = ?", params);
//    }

    @NonNull
    private ContentValues getValuesCorrentista(Correntista correntista) {
        ContentValues dados = new ContentValues();
        dados.put("nome", correntista.nome);
        dados.put("senha", correntista.senha);
        dados.put("email", correntista.email);
        dados.put("saldo", correntista.saldo);
        return dados;
    }
}
