package com.coderbd.servicewithrecycleviewex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    //for get data use model class
    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    /*
    * this method will be call when view holder is created means
    * an instance of ViewHolder is created
    * */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //create a View object and by the help of LayoutInflater we will get the list_item.xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    /*
    * This method will be called after calling onCreateViewHolder() method and
    * this method will bind the data to the ViewHolder that means
    * we will show the actual data to RecyclerView
    */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the current object from listItem (private List<ListItem> listItem)
        final ListItem listItem = listItems.get(position);
        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());

        //Picasso.with(context).load(listItem.getImageUrl()).into(holder.imageView);
        String url = listItem.getImageUrl();
        if (url.isEmpty()) {
            Picasso.get().load(R.drawable.ic_person_unknown).into(holder.imageView);
        } else{
            Picasso.get().load(url).into(holder.imageView);
        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked on : "+listItem.getHead(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //return the size of recycler view
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //define two text views
        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = itemView.findViewById(R.id.textViewHeading);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            imageView = itemView.findViewById(R.id.imageView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
