package com.jonathan.gadsleadersboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jonathan.gadsleadersboard.R;
import com.jonathan.gadsleadersboard.models.SkillLeaders;

import java.util.List;

public class SkillLeadersAdapter extends RecyclerView.Adapter<SkillLeadersAdapter.ViewHolder> {

    private List<SkillLeaders> leaders;
    private Context context;

    public SkillLeadersAdapter(Context context){
        this.context = context;
    }

    public void setItems(List<SkillLeaders> leaders){
        this.leaders = leaders;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.skill_leaders_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindItem(leaders.get(position));
    }

    @Override
    public int getItemCount() {
        return leaders == null ? 0 : leaders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtSubtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtSubtitle = itemView.findViewById(R.id.txtSubtitle);
        }
        public void bindItem(SkillLeaders item){
            txtTitle.setText(item.getName());
            txtSubtitle.setText(context.getString(R.string.skill_leader_details, item.getScore(), item.getCountry()));
        }

    }
}
