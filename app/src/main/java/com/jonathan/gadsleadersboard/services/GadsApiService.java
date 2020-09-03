package com.jonathan.gadsleadersboard.services;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.jonathan.gadsleadersboard.models.LearningLeaders;
import com.jonathan.gadsleadersboard.models.SkillLeaders;
import com.jonathan.gadsleadersboard.network.NetworkService;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GadsApiService {

    private static GadsApiService instance = null;
    private NetworkService networkService;

    // constructor
    public GadsApiService() {
        networkService = new NetworkService();
    }

    // singleton method
    public static GadsApiService getInstance() {
        if (instance == null)
            instance = new GadsApiService();
        return instance;
    }

    public MutableLiveData<List<LearningLeaders>> getLearningLeaders() {
        final MutableLiveData<List<LearningLeaders>> learningLeaderList = new MutableLiveData<>();
        networkService.getGadsApi().getLearningLeaders().enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                if (response.isSuccessful()) {
                    Log.i("message-learning", "response has a value");
                    learningLeaderList.setValue(response.body());
                } else {
                    Log.i("message-learning", "response failed");
                    learningLeaderList.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {
                learningLeaderList.setValue(null);
            }
        });
        return learningLeaderList;
    }

    public MutableLiveData<List<SkillLeaders>> getSkillLeaders() {

        final MutableLiveData<List<SkillLeaders>> skillLeadersList = new MutableLiveData<>();
        networkService.getGadsApi().getSkillLeaders().enqueue(new Callback<List<SkillLeaders>>() {
            @Override
            public void onResponse(Call<List<SkillLeaders>> call, Response<List<SkillLeaders>> response) {
                if (response.isSuccessful()) {
                    Log.i("message-skill", "response has a value");
                    skillLeadersList.setValue(response.body());
                } else {
                    Log.i("message-skill", "response failed");
                    skillLeadersList.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<SkillLeaders>> call, Throwable t) {
                skillLeadersList.setValue(null);
            }
        });
        return skillLeadersList;
    }


}
