package laptop.com.mobility_problem_statement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    String url="https://picsum.photos/list";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager( new GridLayoutManager(this,2));
        getSupportActionBar().setTitle("Sample Screen");




        StringRequest stringRequest= new StringRequest(url, new Response.Listener <String>() {
            @Override
            public void onResponse(String response) {
               // Toast.makeText(MainActivity.this, "Response"+response, Toast.LENGTH_LONG).show();

                GsonBuilder gsonBuilder= new GsonBuilder();
                Gson gson= gsonBuilder.create();
                Detail[] details=gson.fromJson(response,Detail[].class);

                recyclerView.setAdapter(new DetailsAdapter(MainActivity.this,details));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error occured", Toast.LENGTH_SHORT).show();

            }
        }

        );

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }

}