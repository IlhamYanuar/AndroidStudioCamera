package com.example.diyanuar.kitkat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

/**
 * Created by diyanuar on 01/11/16.
 */

public class MainActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_menu);


            //tombol gallery
            ImageButton galery = (ImageButton) findViewById(R.id.gallery);
            galery.setOnClickListener(new View.OnClickListener() {

                public void onClick(View arg0) {
                    // TODO Auto-generated method stub

                    Intent a = new Intent(getApplicationContext(), gallery.class);

                    startActivity(a);
                }
            });

            //tombol camera
            ImageButton kamera = (ImageButton) findViewById(R.id.Camera);
            kamera.setOnClickListener(new View.OnClickListener() {

                public void onClick(View arg0) {
                    // TODO Auto-generated method stub

                    Intent a = new Intent(getApplicationContext(), camera.class);

                    startActivity(a);
                }
            });

            //tombol share
            ImageButton setting2 = (ImageButton) findViewById(R.id.share);
            setting2.setOnClickListener(new View.OnClickListener() {

                public void onClick(View arg0) {
                    // TODO Auto-generated method stub

                    Intent a = new Intent(getApplicationContext(), share.class);

                    startActivity(a);
                }
            });
        }

        //button keluar
        @Override
        public void onBackPressed(){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Apakah anda ingin keluar ?");
            builder.setCancelable(true);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    System.exit(0);
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
    }
