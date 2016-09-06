package prado.com.Rnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.FragmentTransaction;

import net.dean.jraw.models.Submission;


import java.util.List;

import prado.com.Rnews.R;
import prado.com.Rnews.controller.JsonImg;
import prado.com.Rnews.layout.FragmentWeb;

/**
 * Created by Prado on 14/08/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private LayoutInflater li;
    private List<Submission> mData;
    private Context context;
    private FragmentTransaction ft;

    public RecyclerAdapter(Context c, List<Submission> mDataSet, FragmentTransaction ft){
        this.li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mData = mDataSet;
        this.context = c;
        this.ft = ft;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = li.inflate(R.layout.fragment_itens, parent, false);
        v.setLayoutParams(new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));


        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.text.setText(mData.get(position).getTitle());
        if(position == 0){
            holder.imageView.setImageResource(R.drawable.burka);
        } else if(position == 1){
            holder.imageView.setImageResource(R.drawable.cannae);
        } else if(position == 2){
            holder.imageView.setImageResource(R.drawable.duterte);
        } else{
            holder.imageView.setImageResource(R.drawable.imagenf);
        }

        //JsonImg img = new JsonImg();
        //img.getImage(mData.get(position).getUrl());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position == 0){
                    ft.replace(R.id.content_main, new FragmentWeb(mData.get(position).getUrl()));
                    ft.addToBackStack(null);
                    ft.commit();

                }else{
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(mData.get(position).getUrl()));
                    context.startActivity(i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView text;
        private CardView cardView;

        public MyViewHolder(View v) {
            super(v);

            imageView = (ImageView) v.findViewById(R.id.imageCard);
            text      = (TextView)  v.findViewById(R.id.titleText);
            cardView  = (CardView)  v.findViewById(R.id.card_view);

        }
    }
}

