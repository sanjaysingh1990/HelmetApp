package helmet.init.user.helmetapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class OneFragment extends Fragment {


    ArrayList<GalleryDataBean> data=new ArrayList<GalleryDataBean>();
    GalleryArrayAdapter adapter;
    ProgressBar prog;
    static int pos;

    boolean flag=true;
    RecyclerView.LayoutManager 	mLayoutManager;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_one, container, false);

        prog=(ProgressBar)v.findViewById(R.id.progress_bar);
        prog.setVisibility(View.VISIBLE);

        RecyclerView gridView = (RecyclerView)v.findViewById(R.id.recycler_view);
        gridView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridView.setLayoutManager(mLayoutManager);
        adapter=new GalleryArrayAdapter(getActivity(), data);
        gridView.setAdapter(adapter);



        getData();
        /*String url="http://52.74.238.77/android/wallpaper.php?start=0";

        JsonObjectRequest object=new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Log.d(TAG, response.toString());
                prog.setVisibility(View.GONE);


                try{

                    data.clear();
                    //JSONObject jobj=response.getJSONObject("wallpaper");


                    JSONArray obj = response.getJSONArray("wallpaper");
                    // if(obj.length()<10)
                    //   flag=false;
                    for(int i=0;i<obj.length();i++) {
                        JSONObject object = obj.getJSONObject(i);
                        GalleryDataBean rb=new GalleryDataBean();
                        rb.setId(object.getString("wallpaper_id"));
                        rb.setName(object.getString("wallpaper_title"));
                        rb.setUrl(object.getString("wallpaper_url"));
                        data.add(rb);
                    }

                    adapter.notifyDataSetChanged();

                    Log.e("error1" , obj + "");



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            // notifying list adapter about data changes
            // so that it renders the list view with updated data
//                        adapter.notifyDataSetChanged();

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //VolleyLog.d(TAG, "Error: " + error.getMessage());
                //hidePDialog();
                prog.setVisibility(View.GONE);
            }
        });

        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(object);

*/
        return  v;

    }

    private void getData() {

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest("http://sikhdiary.com/Helmet/helmet.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       // showJSON(response);
                        prog.setVisibility(View.GONE);
                        //Toast.makeText(getActivity(),"get data"+response.toString(),Toast.LENGTH_LONG).show();
                       // Log.e("json",response.toString());
                        try {
                            JSONObject jobj = new JSONObject(response.toString());
                            JSONArray jarray=jobj.getJSONArray("data");

                            for(int i=0;i<jarray.length();i++){
                                JSONObject jsonObject=jarray.getJSONObject(i);

                                GalleryDataBean bean=new GalleryDataBean();
                                bean.setHelmet_name(jsonObject.getString("helmet_name"));
                                bean.setHelmet_image(jsonObject.getString("helmet_image"));

                                data.add(bean);
                            }
adapter.notifyDataSetChanged();
                            }
                        catch (Exception e){
                            Log.e("exception",e.toString());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        prog.setVisibility(View.GONE);

                       Toast.makeText(getActivity(),error.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("error",error.toString());
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }


}
