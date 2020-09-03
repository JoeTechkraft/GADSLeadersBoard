package com.jonathan.gadsleadersboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jonathan.gadsleadersboard.R;
import com.jonathan.gadsleadersboard.models.LearningLeaders;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    private List<LearningLeaders> learningLeaders;
    private Context context;

    public  LearningLeadersAdapter(Context context){
        this.context = context;
    }

    public void setItems(List<LearningLeaders> items) {
        this.learningLeaders = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.learning_leaders_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindItem(learningLeaders.get(position));
    }

    @Override
    public int getItemCount() {
        return learningLeaders == null ? 0 : learningLeaders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtSubtitle;


        public ViewHolder( View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtSubtitle = itemView.findViewById(R.id.txtSubtitle);
        }
        public void bindItem(LearningLeaders item){
            txtTitle.setText(item.getName());
            txtSubtitle.setText(context.getString(R.string.learning_leader_details, item.getHours(), item.getCountry()));

        }
    }
}
