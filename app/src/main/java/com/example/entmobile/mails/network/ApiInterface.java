package com.example.entmobile.mails.network;

import com.example.entmobile.mails.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("inbox.json")
    Call<List<Message>> getInbox();
}
