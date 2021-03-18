package laptop.com.mobility_problem_statement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.Detailsviewholder> {
    Context context;
    Detail [] data;
    String URL="https://picsum.photos/300/300?image=";

    public  DetailsAdapter(Context context,Detail [] data )
    {
        this.context=context;
        this.data=data;
    }


    @Override
    public Detailsviewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.llist_item,parent,false);
        return new Detailsviewholder(view);
    }

    @Override
    public void onBindViewHolder( Detailsviewholder holder, int position) {
        Detail detail=data[position];
        String  id_details=String.valueOf(detail.getId());
         holder.Author.setText(detail.getAuthor());
        Glide.with(holder.imageView.getContext()).load(URL+id_details).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context,Sample_cell.class);
                intent.putExtra("id",String.valueOf(detail.getId()));
                intent.putExtra("Author",detail.getAuthor());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class Detailsviewholder extends RecyclerView.ViewHolder {
        TextView Author;
        ImageView imageView;
        public Detailsviewholder(final View itemView) {
            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.imageview);
            Author=(TextView)itemView.findViewById(R.id.textview_2);
        }
    }
}
