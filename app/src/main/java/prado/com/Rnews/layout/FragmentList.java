package prado.com.Rnews.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import java.util.List;

import prado.com.Rnews.R;
import prado.com.Rnews.adapter.RecyclerAdapter;
import prado.com.Rnews.controller.ListTouchHelper;
import prado.com.Rnews.controller.LoadSubmissions;
import prado.com.Rnews.interfaces.AsyncResponse;

public class FragmentList extends Fragment{

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private List<Submission> myDataset;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content, container, false);

        LoadSubmissions info = (LoadSubmissions) new LoadSubmissions(new AsyncResponse() {
            @Override
            public void processFinish(Listing<Submission> output) {

                myDataset =  output;

                mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                mRecyclerView.setHasFixedSize(true);

                FragmentTransaction ft = getFragmentManager().beginTransaction();

                mAdapter = new RecyclerAdapter(getContext(),myDataset, ft);

                ItemTouchHelper.Callback callback = new ListTouchHelper(mAdapter);
                ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
                itemTouchHelper.attachToRecyclerView(mRecyclerView);

                LinearLayoutManager llm = new LinearLayoutManager(getContext());
                mRecyclerView.setLayoutManager(llm);

                mRecyclerView.setAdapter(mAdapter);

            }
        },view).execute();

        return view;
    }

}