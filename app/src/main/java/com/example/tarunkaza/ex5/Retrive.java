package com.example.tarunkaza.ex5;
import android.app.Activity;
import android.database.Cursor;
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
public class Retrive extends Activity {

    EditText Id;
    Button ret;

    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        Id = (EditText)findViewById(R.id.editText1);
        ret = (Button)findViewById(R.id.button1);

        ret.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub

                //Getting the Values from EditText
                String s1 = Id.getText().toString();

                //Retrive operation
                db = openOrCreateDatabase("myDataBase.db", MODE_PRIVATE, null);
                //Query for Retriving Table
                c = db.rawQuery("select * from sample where id='"+s1+"'", null);

                if(c.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(), "ID :"+s1+" "+"NotFound", 5000).show();
                }
                while (c.moveToNext())
                {

                    String id = c.getString(0);
                    String name = c.getString(1);
                    String num = c.getString(2);

                    Toast.makeText(getApplicationContext(), id+" "+name+" "+num, Toast.LENGTH_SHORT).show();
                }
                c.close();
                db.close();
            }
        });
    }

}
