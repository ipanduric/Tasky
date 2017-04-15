package com.zadaca.ipand.tasky;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ipand on 15.4.2017..
 */

public class TaskAdapter extends BaseAdapter {

    private ArrayList<Task> mTask;


    public TaskAdapter (ArrayList<Task> mTask) {
        this.mTask = mTask;
    }

    @Override
    public int getCount() {
        return mTask.size();
    }

    @Override
    public Object getItem(int position) {
        return mTask.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder taskViewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.items, parent, false);
            taskViewHolder = new ViewHolder(convertView);
            convertView.setTag(taskViewHolder);
        } else {
            taskViewHolder = (ViewHolder) convertView.getTag();
        }

        Task task = this.mTask.get(position);
        switch (task.getPriority()) {
            case "Low":
                taskViewHolder.ivPriority.setImageResource(R.drawable.green);
                break;
            case "Medium":
                taskViewHolder.ivPriority.setImageResource(R.drawable.yellow);
                break;
            case "High":
                taskViewHolder.ivPriority.setImageResource(R.drawable.red);
                break;
        }
        taskViewHolder.tvTitle.setText(task.getTitle());
        taskViewHolder.tvDescription.setText(task.getDescription());
        taskViewHolder.tvCategory.setText(task.getCategory());
        return convertView;
    }

    public void addNewTask(Task task) {
        mTask.add(task);
        notifyDataSetChanged();
    }

    public void deleteAt(int position) {
        mTask.remove(position);
        notifyDataSetChanged();
    }


    private class ViewHolder {

        ImageView ivPriority;
        TextView tvTitle, tvDescription, tvCategory;

        public ViewHolder(View taskView) {
            ivPriority = (ImageView) taskView.findViewById(R.id.ivPriority);
            tvTitle = (TextView) taskView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) taskView.findViewById(R.id.tvDescription);
            tvCategory = (TextView) taskView.findViewById(R.id.tvCategory);
        }

    }
}
