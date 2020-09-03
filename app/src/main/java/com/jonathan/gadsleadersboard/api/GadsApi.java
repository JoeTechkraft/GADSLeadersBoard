package com.jonathan.gadsleadersboard.api;

import com.jonathan.gadsleadersboard.models.LearningLeaders;
import com.jonathan.gadsleadersboard.models.SkillLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GadsApi {

    @GET("/api/hours")
    Call<List<LearningLeaders>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillLeaders>> getSkillLeaders();
}
