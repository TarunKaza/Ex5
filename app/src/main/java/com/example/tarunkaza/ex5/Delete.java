package com.example.tarunkaza.ex5;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Tarun Kaza on 20-03-2016.
 */
public class Delete extends Activity {

    EditText Id;
    Button del;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Id = (EditText) findViewById(R.id.editText1);
        del = (Button) findViewById(R.id.button1);

        del.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                //Getting the Values from EditText
                String s1 = Id.getText().toString();
                //Delete Operation
                db = openOrCreateDatabase("myDataBase.db", MODE_PRIVATE, null);
                //Query for Deleting Table
                db.execSQL("delete from sample where id='" + s1 + "';");
                Toast.makeText(getApplicationContext(), "ID :" + s1 + " " + "Deleted", 5000).show();
                db.close();
            }
        });

    }
}