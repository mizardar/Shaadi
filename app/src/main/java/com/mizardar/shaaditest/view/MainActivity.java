package com.mizardar.shaaditest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.mizardar.shaaditest.R;
import com.mizardar.shaaditest.databinding.ActivityMainBinding;
import com.mizardar.shaaditest.model.network.Result;
import com.mizardar.shaaditest.view.adapter.MatchesAdapter;
import com.mizardar.shaaditest.view.listener.ClickListener;
import com.mizardar.shaaditest.viewmodel.MainViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding activityMainBinding;
    private RecyclerView userRecyclerView;
    private SnapHelper snapHelper;
    private MatchesAdapter matchesAdapter;
    private List<Result> usersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        initViewModel();
        registerObserver();
        initRecyclerView();
    }

    private void initRecyclerView() {
        snapHelper = new PagerSnapHelper();
        userRecyclerView = activityMainBinding.listUsers;
        matchesAdapter = new MatchesAdapter(this,usersList, clickListener);
        userRecyclerView.setAdapter(matchesAdapter);
        snapHelper.attachToRecyclerView(userRecyclerView);
    }

    private void initViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    private void registerObserver() {
        mainViewModel.getUsers().observe(this, users -> {
            if (users != null) {
                usersList.addAll(users);
                matchesAdapter.notifyDataSetChanged();
            }
        });

    }

    private ClickListener clickListener = new ClickListener() {
        @Override
        public void onAcceptClick(Result user) {
            user.setAccepted(true);
            user.setDeclined(false);
            mainViewModel.updateUser(user);
        }

        @Override
        public void onDeclineClick(Result user) {
            user.setAccepted(false);
            user.setDeclined(true);
            mainViewModel.updateUser(user);
        }

        @Override
        public void onCall(Result user) {
            String contact  = user.getPhone();
            if (!TextUtils.isEmpty(contact)){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + contact));
                startActivity(intent);
            }
        }

        @Override
        public void onMail(Result user) {
            String email  = user.getEmail();
            if (!TextUtils.isEmpty(email)) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"+email));
                startActivity(intent);
            }
        }
    };
}