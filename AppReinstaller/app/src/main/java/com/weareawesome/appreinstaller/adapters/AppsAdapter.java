package com.weareawesome.appreinstaller.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weareawesome.appreinstaller.R;
import com.weareawesome.appreinstaller.models.AppModel;

import java.util.ArrayList;

public class AppsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<AppModel> appModelArrayList;

    public AppsAdapter(ArrayList<AppModel> appModelArrayList) {
        this.appModelArrayList = appModelArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AppViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //todo set data
    }

    @Override
    public int getItemCount() {
        return appModelArrayList.size();
    }

    static class AppViewHolder extends RecyclerView.ViewHolder {
        public AppViewHolder(View itemView) {
            super(itemView);
        }
    }
}
