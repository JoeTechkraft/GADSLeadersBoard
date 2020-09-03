package com.jonathan.gadsleadersboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jonathan.gadsleadersboard.models.SkillLeaders;
import com.jonathan.gadsleadersboard.remote.Repository;

import java.util.List;

public class SkillLeadersViewModel extends ViewModel {

    public MutableLiveData<List<SkillLeaders>> getSkillLeadersLiveData(){
        return Repository.getInstance().getSkillLeaders();
    }
}
