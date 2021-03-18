package laptop.com.mobility_problem_statement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Sample_cell extends AppCompatActivity {
    String URL="https://picsum.photos/300/300?image=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_cell);
        ImageView Image_selcted=(ImageView)findViewById(R.id.Image_iid);
        getSupportActionBar().setTitle("Sample Cell");
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        String Author=intent.getStringExtra("Author");
        TextView author_Text= (TextView)findViewById(R.id.author);
        author_Text.setText(Author);
        Glide.with(this).load(URL+id).into(Image_selcted);
    }
}