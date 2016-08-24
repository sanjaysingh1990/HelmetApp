
package helmet.init.user.helmetapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocateActivity extends AppCompatActivity {

    TextView locateMap;
    private GoogleMap googleMap;
    RecyclerView addressRecycler,distancetimeRecycler;
    ArrayList<GalleryDataBean> distributor=new ArrayList<>();
    RecyclerAdapter adapter;
    DistanceTimeAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_locate);

        getData();
        locateMap = (TextView) findViewById(R.id.locate);
        addressRecycler=(RecyclerView)findViewById(R.id.address);

        LinearLayoutManager manager=new LinearLayoutManager(LocateActivity.this,LinearLayoutManager.VERTICAL,false);
        addressRecycler.setLayoutManager(manager);



        if(distributor!=null)
        {
            adapter = new RecyclerAdapter(distributor);
            addressRecycler.setAdapter(adapter);
        }
        else
        getData();




        Typeface descfont = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");
        locateMap.setTypeface(descfont);


        try {
            // Loading map
            initilizeMap();

            double latitude =  30.361;
            double longitude =   76.8485;

            // googleMap.setMyLocationEnabled(true);
// create marker
            MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Ambala Cantt ");

// adding marker
            googleMap.addMarker(marker);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getData() {

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest("http://sikhdiary.com/Helmet/Distributor.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Toast.makeText(DescriptionActivity.this,"get data"+response.toString(),Toast.LENGTH_LONG).show();
                        try {
                            JSONObject jobj = new JSONObject(response.toString());
                            JSONArray jarray = jobj.getJSONArray("data");

                            if (jarray.length() == 0) {
                                Toast.makeText(LocateActivity.this, "No available colors", Toast.LENGTH_LONG).show();
                            }

                            for (int i = 0; i < jarray.length(); i++) {
                                JSONObject jsonObject = jarray.getJSONObject(i);

                                GalleryDataBean bean = new GalleryDataBean();
                                bean.setDistributor_name(jsonObject.getString("distributor_name"));
                                bean.setDistributor_location(jsonObject.getString("distributor_location"));
                                bean.setDistributor_contact(jsonObject.getString("distributor_contact"));
                                bean.setLatitude(jsonObject.getString("latitude"));
                                bean.setLongitude(jsonObject.getString("longitude"));
                                bean.setDistance(jsonObject.getString("distance"));
                                bean.setTime(jsonObject.getString("time"));



                                distributor.add(bean);


                            }

                            //imgAdapter.notifyDataSetChanged();
                            Log.e("colors array", distributor.size()+"");
                            adapter.notifyDataSetChanged();
                           //imgAdapter=new ImageAdapter(getApplicationContext(), images);
                            //imagesRecycler.setAdapter(imgAdapter);

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
 };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void initilizeMap() {

        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();

                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


            }

        }
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {

        ArrayList<GalleryDataBean> dist;

        public RecyclerAdapter(ArrayList<GalleryDataBean> distributor) {
        this.dist=distributor;

        }

        @Override
        public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {

           View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.distributor_list_row,null);
            Myholder hold=new Myholder(v);

            return hold;
        }

        @Override
        public void onBindViewHolder(Myholder holder, int position) {

        GalleryDataBean distItem=dist.get(position);
            holder.sname.setText(distItem.getDistributor_name());
            holder.sno.setText(distItem.getDistributor_location());
            holder.sph.setText(distItem.getDistributor_contact());
            holder.distance1.setText(distItem.getDistance());
            holder.time1.setText(distItem.getTime());

        }

        @Override
        public int getItemCount() {
            return dist.size();
        }

        public class Myholder extends RecyclerView.ViewHolder {
            TextView sname,sno,sstate,sph,distance1,time1;

            public Myholder(View itemView) {
                super(itemView);

                sname=(TextView)itemView.findViewById(R.id.shopname);
                sno=(TextView)itemView.findViewById(R.id.shopno);
                //sstate=(TextView)itemView.findViewById(R.id.shopstate);
                sph=(TextView)itemView.findViewById(R.id.shopph);
                distance1=(TextView)itemView.findViewById(R.id.distance);
                time1=(TextView)itemView.findViewById(R.id.time);

            }
        }
    }


    private class DistanceTimeAdapter extends RecyclerView.Adapter<DistanceTimeAdapter.Myholder> {

        ArrayList<GalleryDataBean> dist;

        public DistanceTimeAdapter(ArrayList<GalleryDataBean> distributor) {
            this.dist=distributor;

        }

        @Override
        public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.distsnce_time_list_row,null);
            Myholder hold=new Myholder(v);

            return hold;
        }

        @Override
        public void onBindViewHolder(Myholder holder, int position) {

            GalleryDataBean distItem=dist.get(position);
            holder.distance1.setText(distItem.getDistance());
            holder.time1.setText(distItem.getTime());
            // holder.sstate.setText(distItem.getDistributor_location());

        }

        @Override
        public int getItemCount() {
            return dist.size();
        }

        public class Myholder extends RecyclerView.ViewHolder {
            TextView distance1,time1;

            public Myholder(View itemView) {
                super(itemView);

                distance1=(TextView)itemView.findViewById(R.id.distance);
                time1=(TextView)itemView.findViewById(R.id.time);


            }
        }
    }

}
