package com.example.receita;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class MyDataBaseHelper extends SQLiteOpenHelper {

    private String dbName;
    private String dbPath;
    Context mcontext;


    public MyDataBaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
        this.mcontext = context;
        this.dbName = name;

        this.dbPath = "/data/data/" + "com.example.receita" + "/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CheckDb() {
        SQLiteDatabase checkDb = null;
        String filePath = dbPath + dbName;

        try {
            checkDb = SQLiteDatabase.openDatabase(filePath, null, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkDb != null) {
            Toast.makeText(mcontext, "Database already exists!", Toast.LENGTH_LONG).show();
        } else {
            CopyDataBase();
        }
    }

        public void CopyDataBase() {
            this.getReadableDatabase();

            try {
                InputStream ios = mcontext.getAssets().open(dbName);
                OutputStream os = new FileOutputStream(dbPath + dbName);

                byte[] buffer = new byte[1024];

                int len;

                while ((len = ios.read(buffer)) > 0) {
                    os.write(buffer, 0, len);
                }
                os.flush();
                ios.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("CopyDb", "Database copied!");
        }


        public void OpenDataBase() {
            String filePath = dbPath + dbName;
            SQLiteDatabase.openDatabase(filePath, null, 0);
        }


        Cursor listarSalgados() {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = "SELECT receitas.rec_cod, receitas.rec_nome_receita, receitas.rec_autoria, modo_preparo.mod_tempo_preparo " +
                    "FROM TIPO_RECEITA " +
                    " inner join RECEITAS ON RECEITAS.tip_cod = TIPO_RECEITA.tip_cod " +
                    "LEFT JOIN MODO_PREPARO on MODO_PREPARO.rec_cod = receitas.rec_cod " +
                    " WHERE RECEITAS.tip_cod = 2 " +
                    " group by RECEITAS.rec_cod";


            Cursor cursor = null;
            if(db != null) {
                cursor = db.rawQuery(query, null);
            }
            return cursor;

        }

    Cursor listarDoces() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT receitas.rec_cod, receitas.rec_nome_receita, receitas.rec_autoria, modo_preparo.mod_tempo_preparo " +
                "FROM TIPO_RECEITA " +
                " inner join RECEITAS ON RECEITAS.tip_cod = TIPO_RECEITA.tip_cod " +
                "LEFT JOIN MODO_PREPARO on MODO_PREPARO.rec_cod = receitas.rec_cod " +
                " WHERE RECEITAS.tip_cod = 1 " +
                " group by RECEITAS.rec_cod";


        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;

    }

    Cursor listarIngredientes(int codigo_receita) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select itens_receita.iten_ingredientes " +
                "from RECEITAS " +
                "inner join ITENS_RECEITA on ITENS_RECEITA.rec_cod = RECEITAS.rec_cod " +
                "where receitas.rec_cod = " + codigo_receita + " " +
                "order by receitas.rec_nome_receita, receitas.rec_autoria";


        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;

    }

    Cursor listarModoPreparo(int codigo_receita) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT MOD_DESC, MOD_TEMPO_PREPARO " +
                "FROM MODO_PREPARO " +
                "INNER JOIN RECEITAS ON RECEITAS.rec_cod = MODO_PREPARO.rec_cod " +
                "WHERE MODO_PREPARO.rec_cod = " + codigo_receita +"";


        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;

    }




    }


