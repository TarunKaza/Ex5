package com.example.tarunkaza.ex5;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Tarun Kaza on 20-03-2016.
 */
public class Update extends Activity {

    EditText id1,name1,number1;
    Button update1;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        id1 = (EditText)findViewById(R.id.editText1);
        name1 = (EditText)findViewById(R.id.editText2);
        number1 = (EditText)findViewById(R.id.editText3);
        update1 = (Button)findViewById(R.id.button1);

        update1.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub

                //Getting the Values from EditText
                String s1 = id1.getText().toString();
                String s2 = name1.getText().toString();
                String s3 = number1.getText().toString();

                //Update Operation
                db = openOrCreateDatabase("myDataBase.db", MODE_PRIVATE, null);
                //Query for Inserting Table
                db.execSQL("update sample set name='"+s2+"',number='"+s3+"' where id='"+s1+"';");
                Toast.makeText(getApplicationContext(),  "ID :"+s1+" "+"Update", 5000).show();
                db.close();
            }
        });
    }

}
