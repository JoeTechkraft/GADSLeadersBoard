package com.jonathan.gadsleadersboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jonathan.gadsleadersboard.models.LearningLeaders;
import com.jonathan.gadsleadersboard.remote.Repository;

import java.util.List;

public class LearningLeadersViewModel extends ViewModel {

    public MutableLiveData<List<LearningLeaders>> getLearningLeadersLiveData() {
        return Repository.getInstance().getLearningLeaders();
    }

}
