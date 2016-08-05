package helmet.init.user.helmetapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
//import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DescriptionActivity extends AppCompatActivity {

    TextView locate, tryit, helmetname, name1, availablecolors, features, desc1, desc2;
    ArrayList<GalleryDataBean> images=new ArrayList<>();
    ImageView helmetimg;
    RecyclerView imagesRecycler;
    ImageAdapter imgAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main3);



        String feature = getIntent().getStringExtra("helmet_feature");
        String helmet_id = getIntent().getStringExtra("helmet_id");
        String helmet_name = getIntent().getStringExtra("helmet_name");
        String image = getIntent().getStringExtra("helmet_image");



        getAvailableColors(helmet_id);

        Log.e("helmet_id",helmet_id);

        imagesRecycler=(RecyclerView)findViewById(R.id.image_recycler);
        LinearLayoutManager manager=new LinearLayoutManager(DescriptionActivity.this,LinearLayoutManager.HORIZONTAL,false);
        imagesRecycler.setLayoutManager(manager);




        locate = (TextView) findViewById(R.id.locate);
        tryit = (TextView) findViewById(R.id.tryit);
        helmetname = (TextView) findViewById(R.id.helmetname);
        name1 = (TextView) findViewById(R.id.name1);
        availablecolors = (TextView) findViewById(R.id.availablecolors);
        features = (TextView) findViewById(R.id.features);
        desc1 = (TextView) findViewById(R.id.desc1);
        desc2 = (TextView) findViewById(R.id.desc2);

        helmetimg = (ImageView) findViewById(R.id.helmetimage);

        Typeface custom = Typeface.createFromAsset(getAssets(), "fonts/gillsanssemibolditalic.ttf");
        helmetname.setTypeface(custom);

        Typeface name1font = Typeface.createFromAsset(getAssets(), "fonts/gillsans-light-italic.ttf");
        name1.setTypeface(custom);
        locate.setTypeface(custom);
        availablecolors.setTypeface(custom);
        features.setTypeface(custom);
        tryit.setTypeface(custom);

        Typeface descfont = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");
        desc1.setTypeface(descfont);
        desc2.setTypeface(descfont);





        name1.setText(helmet_name);

        desc1.setText(feature);
        Picasso.with(getApplicationContext()).load(image).into(helmetimg);


        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locate = new Intent(DescriptionActivity.this, LocateActivity.class);
                startActivity(locate);
            }
        });
        tryit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent tryit=new Intent(DescriptionActivity.this,CameraActivity.class);
                startActivity(tryit);
*/
                // Intent tr=new Intent(DescriptionActivity.this,CustomCamera.class);
                //startActivityForResult(tr,100);

            }
        });



    }



    private void getAvailableColors(final String helmet_id) {
//Toast.makeText(DescriptionActivity.this,helmet_id,Toast.LENGTH_LONG).show();
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://sikhdiary.com/Helmet/AvailableColors.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                           //Toast.makeText(DescriptionActivity.this,"get data"+response.toString(),Toast.LENGTH_LONG).show();
                        try {
                            JSONObject jobj = new JSONObject(response.toString());
                            JSONArray jarray = jobj.getJSONArray("data");

                            if (jarray.length() == 0) {
                                Toast.makeText(DescriptionActivity.this, "No available colors", Toast.LENGTH_LONG).show();
                            }

                            for (int i = 0; i < jarray.length(); i++) {
                                JSONObject jsonObject = jarray.getJSONObject(i);

                                GalleryDataBean bean = new GalleryDataBean();
                                bean.setImage(jsonObject.getString("image"));

                                images.add(bean);


                            }
                            //imgAdapter.notifyDataSetChanged();
                            Log.e("colors array", images.size()+"");
                           // imgAdapter.notifyDataSetChanged();
                            imgAdapter=new ImageAdapter(getApplicationContext(), images);
                            imagesRecycler.setAdapter(imgAdapter);

                        } catch (Exception e) {
                            Log.e("exception", e.toString());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //prog.setVisibility(View.GONE);

                        //Toast.makeText(getActivity(),error.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("error", error.toString());
                    }

                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("helmet_id",1+"");

                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void setAdapter() {
        imgAdapter=new ImageAdapter(getApplicationContext(), images);
        imagesRecycler.setAdapter(imgAdapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && data != null) {
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
