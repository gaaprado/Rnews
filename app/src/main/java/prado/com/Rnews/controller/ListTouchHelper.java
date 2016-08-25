package prado.com.Rnews.controller;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import prado.com.Rnews.adapter.RecyclerAdapter;


/**
 * Created by Prado on 18/08/2016.
 */

public class ListTouchHelper extends ItemTouchHelper.SimpleCallback {

    private RecyclerAdapter adapter;

    public ListTouchHelper(RecyclerAdapter adapter){
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
    }


    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        /*this.adapter.onItemMove(viewHolder.getAdapterPosition(),
                target.getAdapterPosition());
        */
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    }
}
