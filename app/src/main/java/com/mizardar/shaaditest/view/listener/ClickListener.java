package com.mizardar.shaaditest.view.listener;

import com.mizardar.shaaditest.model.network.Result;

public interface ClickListener {
    void onAcceptClick(Result user);
    void onDeclineClick(Result user);
    void onCall(Result user);
    void onMail(Result user);
}
