package com.jonathan.gadsleadersboard.remote;

import androidx.lifecycle.MutableLiveData;

import com.jonathan.gadsleadersboard.models.LearningLeaders;
import com.jonathan.gadsleadersboard.models.SkillLeaders;
import com.jonathan.gadsleadersboard.models.SubmissionRequest;
import com.jonathan.gadsleadersboard.services.GadsApiService;
import com.jonathan.gadsleadersboard.services.GoogleFormApiService;

import java.util.List;

public class Repository {

    private static Repository repository;

    public static Repository getInstance() {
        if (repository == null)
            repository = new Repository();
        return repository;
    }

    public MutableLiveData<List<LearningLeaders>> getLearningLeaders() {
        return GadsApiService.getInstance().getLearningLeaders();
    }

    public MutableLiveData<List<SkillLeaders>> getSkillLeaders() {
        return GadsApiService.getInstance().getSkillLeaders();
    }

    public MutableLiveData<Integer> submitRequest(SubmissionRequest request){
        return GoogleFormApiService.getInstance().submitRequest(request);
    }
}
