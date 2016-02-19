package com.example.young.week1project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    Button Emailbutton;
    Button Photobutton;

    public static final int SELECT_IMAGE=1;
    public static final String IMAGE_KEY = "image";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Photobutton=(Button)findViewById(R.id.Photobutton);
        Emailbutton=(Button)findViewById(R.id.Emailbutton);

        Photobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,SELECT_IMAGE);
                   }

        });
        Emailbutton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent2 = new Intent(Intent.ACTION_SENDTO);
                                               intent2.setType("*/*");
                                               intent2.putExtra(Intent.EXTRA_EMAIL, new String[]{"contact@mobiledevsberkeley.org"});
                                               startActivity(intent2);
                                           }
                                       });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fabintent= new Intent(getApplicationContext(),FABActivity.class);
                startActivity(fabintent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==RESULT_OK){
            if (requestCode==SELECT_IMAGE){
                Uri selectedImageUri=data.getData();
                Intent intent3 = new Intent(getApplicationContext(), PhotoActivity.class);
                intent3.putExtra(IMAGE_KEY, selectedImageUri);
                startActivity(intent3);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

 /*       public void composeEmail(String[] contact@mobiledevsberkeley.org, String subject) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, contact@mobiledevsberkeley.org);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }*/
    }
}
