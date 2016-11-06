package com.example.diyanuar.kitkat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class camera extends AppCompatActivity {


    private static final int ACTIVITY_START_CAMERA_APP = 0;
    private ImageView sPhotoCapturedImageView;
    private String sImageFileLocation = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        sPhotoCapturedImageView = (ImageView) findViewById(R.id.gambar);
    }

    public void take(View view){
        // Toast.makeText(this,"Oke",Toast.LENGTH_SHORT).show();
        Intent callCameraApplicationIntent = new Intent();
        callCameraApplicationIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        File gmabarfile = null ;
        try{
            gmabarfile = createImagefile();
        }   catch (IOException e){
            e.printStackTrace();
        }
        callCameraApplicationIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(gmabarfile));
        startActivityForResult(callCameraApplicationIntent, ACTIVITY_START_CAMERA_APP);

    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        if (requestCode == ACTIVITY_START_CAMERA_APP && resultCode == RESULT_OK ){
            // Toast.makeText(this,"OCE",Toast.LENGTH_SHORT).show();
            //          Bundle extras = data.getExtras();
            //Bitmap hasilgambarBitmap = (Bitmap) extras.get("data");
            // sPhotoCapturedImageView.setImageBitmap(hasilgambarBitmap);
            Bitmap hasilgambarBitmap = BitmapFactory.decodeFile(sImageFileLocation);
            sPhotoCapturedImageView.setImageBitmap(hasilgambarBitmap);

        }
    }

    File createImagefile()throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String namagambar ="IMAGE_"+ timeStamp+ "_";
        File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(namagambar,".jpg",storageDirectory);
        sImageFileLocation = image.getAbsolutePath();

        return image;
    }
}