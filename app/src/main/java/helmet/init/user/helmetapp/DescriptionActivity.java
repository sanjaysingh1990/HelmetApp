package helmet.init.user.helmetapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class DescriptionActivity extends AppCompatActivity {

    TextView locate,tryit,helmetname,name1,availablecolors,features,desc1,desc2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main3);

    locate=(TextView)findViewById(R.id.locate);
        tryit=(TextView)findViewById(R.id.tryit);
        helmetname=(TextView)findViewById(R.id.helmetname);
        name1=(TextView)findViewById(R.id.name1);
        availablecolors=(TextView)findViewById(R.id.availablecolors);
        features=(TextView)findViewById(R.id.features);
        desc1=(TextView)findViewById(R.id.desc1);
        desc2=(TextView)findViewById(R.id.desc2);

        Typeface custom=Typeface.createFromAsset(getAssets(), "fonts/gillsanssemibolditalic.ttf");
        helmetname.setTypeface(custom);

        Typeface name1font=Typeface.createFromAsset(getAssets(), "fonts/gillsans-light-italic.ttf");
        name1.setTypeface(custom);
        locate.setTypeface(custom);
        availablecolors.setTypeface(custom);
        features.setTypeface(custom);
        tryit.setTypeface(custom);

        Typeface descfont=Typeface.createFromAsset(getAssets(),"fonts/gillsans.ttf");
        desc1.setTypeface(descfont);
        desc2.setTypeface(descfont);

        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locate=new Intent(DescriptionActivity.this,LocateActivity.class);
                startActivity(locate);
            }
        });
        tryit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent tryit=new Intent(DescriptionActivity.this,CameraActivity.class);
                //startActivity(tryit);

//                Intent tr=new Intent(DescriptionActivity.this,CustomCamera.class);
  //              startActivityForResult(tr,100);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode==100&&data!=null) {
           String path = data.getExtras().getString("url");
           int camid = data.getExtras().getInt("camid");

           // bitmap = Bitmap.createScaledBitmap(bitmap,40);
           Bitmap selectedImage = CompressImage.compressImage(path);
           Bitmap mBitmapRotated = null;
           // Rotate Back photo only once in here
           mBitmapRotated = CamUtils.rotateBackImage(selectedImage);
           if (camid == 1)
               mBitmapRotated = CamUtils.rotateFrontImage(this, mBitmapRotated);

           ByteArrayOutputStream stream = new ByteArrayOutputStream();
           // Must compress the Image to reduce image size to make upload easy
           mBitmapRotated.compress(Bitmap.CompressFormat.JPEG, 100, stream);
           byte[] byte_arr = stream.toByteArray();
           // Encode Image to String

       }
    }
}
