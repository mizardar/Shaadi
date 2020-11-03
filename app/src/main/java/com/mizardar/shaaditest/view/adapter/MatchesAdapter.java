package com.mizardar.shaaditest.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mizardar.shaaditest.databinding.ItemUserCardBinding;
import com.mizardar.shaaditest.model.network.Result;
import com.mizardar.shaaditest.view.listener.ClickListener;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchHolder> {

    private Context context;
    private List<Result> userList;
    private ClickListener clickListener;

    public MatchesAdapter(Context context, List<Result> userList, ClickListener clickListener) {
        this.context = context;
        this.userList = userList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserCardBinding itemUserCardBinding = ItemUserCardBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MatchHolder(itemUserCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchHolder holder, int position) {
        Result user = userList.get(position);
        holder.setValue(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class MatchHolder extends RecyclerView.ViewHolder{

        private ItemUserCardBinding itemUserCardBinding;

        public MatchHolder(@NonNull ItemUserCardBinding itemUserCardBinding) {
            super(itemUserCardBinding.getRoot());
            this.itemUserCardBinding = itemUserCardBinding;
        }

        public void setValue(Result user){
            itemUserCardBinding.setUser(user);
            itemUserCardBinding.setClickListener(clickListener);
        }
    }
}
