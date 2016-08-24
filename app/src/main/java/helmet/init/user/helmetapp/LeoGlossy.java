package helmet.init.user.helmetapp;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LeoGlossy extends Fragment {


    ArrayList<GalleryDataBean> data=new ArrayList<GalleryDataBean>();
    GalleryArrayAdapter adapter;
    ProgressBar prog;
    static int pos;

    boolean flag=true;
    RecyclerView.LayoutManager 	mLayoutManager;

    public LeoGlossy() {
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

        return  v;

    }

    private void getData() {

       /* RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest("http://sikhdiary.com/Helmet/helmet.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       // showJSON(response);
                        prog.setVisibility(View.GONE);
                       // Toast.makeText(getActivity(),"get data"+response.toString(),Toast.LENGTH_LONG).show();
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
*/




        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest =  new StringRequest(Request.Method.POST, "http://sikhdiary.com/Helmet/helmetf.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // showJSON(response);
                        prog.setVisibility(View.GONE);
                     //   Toast.makeText(getActivity(),"get data"+response.toString(),Toast.LENGTH_LONG).show();
                        // Log.e("json",response.toString());
                        try {
                            JSONObject jobj = new JSONObject(response.toString());
                            JSONArray jarray=jobj.getJSONArray("data");


                            if(jarray.length()==0){
                                Toast.makeText(getActivity(),"No data",Toast.LENGTH_LONG).show();
                            }
                            for(int i=0;i<jarray.length();i++){
                                JSONObject jsonObject=jarray.getJSONObject(i);

                                GalleryDataBean bean=new GalleryDataBean();
                                bean.setHelmet_name(jsonObject.getString("helmet_name"));
                                bean.setHelmet_image(jsonObject.getString("helmet_image"));
                                bean.setCategory_feature(jsonObject.getString("category_feature"));
                                bean.setCategory_name(jsonObject.getString("category_name"));
                                bean.setHelmet_id(jsonObject.getString("helmet_id"));

                                data.add(bean);
                                Log.e("data",data.size()+"");
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
                        Toast.makeText(getContext(),"No internet.. Please try after sometime",Toast.LENGTH_LONG).show();

                        //Toast.makeText(getActivity(),error.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("error",error.toString());
                    }

                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("rqid", 5+"");

                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(stringRequest);
    }


}
