package com.jonathan.gadsleadersboard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jonathan.gadsleadersboard.R;
import com.jonathan.gadsleadersboard.adapters.SkillLeadersAdapter;
import com.jonathan.gadsleadersboard.models.SkillLeaders;
import com.jonathan.gadsleadersboard.viewModel.SkillLeadersViewModel;

import java.util.List;

public class SkillIQLeadersFragment extends Fragment {

    private View view, emptyView;
    private RecyclerView skillLeadersRecyclerView;
    private SkillLeadersViewModel skillLeadersViewModel;
    private SkillLeadersAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        skillLeadersViewModel = ViewModelProviders.of(this).get(SkillLeadersViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);
        emptyView = view.findViewById(R.id.emptyView);

        adapter = new SkillLeadersAdapter(getContext());
        skillLeadersRecyclerView = view.findViewById(R.id.skill_leaders_recyclerView);
        skillLeadersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        skillLeadersRecyclerView.setAdapter(adapter);

        skillLeadersViewModel.getSkillLeadersLiveData().observe(getViewLifecycleOwner(), new Observer<List<SkillLeaders>>() {
            @Override
            public void onChanged(List<SkillLeaders> skillLeaders) {
                if (skillLeaders != null && skillLeaders.size() > 0) {
                    skillLeadersRecyclerView.setVisibility(View.VISIBLE);
                    adapter.setItems(skillLeaders);
                    emptyView.setVisibility(View.GONE);
                } else {
                    skillLeadersRecyclerView.setVisibility(View.GONE);
                    emptyView.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }
}
