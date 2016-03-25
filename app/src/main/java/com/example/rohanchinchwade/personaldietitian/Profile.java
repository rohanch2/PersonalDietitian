package com.example.rohanchinchwade.personaldietitian;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class Profile extends Activity {

    ImageButton button;
    ImageView imageview;
    static final int CAM_REQUET=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button = (ImageButton) findViewById(R.id.button);

        imageview = (ImageView) findViewById(R.id.imageView);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file) );
                startActivityForResult(camera_intent, CAM_REQUET);


            }

        });
    }
    private File getFile() {
        File folder = new File("sdcard/camera_app");

        if (!folder.exists()) {

            folder.mkdir();

        }

        File image_file = new File(folder, "cam_image.jpg");

        return image_file;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        String path = "sdcard/camera_app/cam_image.jpg";
        imageview.setImageDrawable(Drawable.createFromPath(path));
    }
}
