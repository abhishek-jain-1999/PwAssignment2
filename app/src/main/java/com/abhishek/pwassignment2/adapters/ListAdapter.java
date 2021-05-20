package com.abhishek.pwassignment2.adapters;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.abhishek.pwassignment2.R;
import com.abhishek.pwassignment2.interfaces.OnCheckedChangeListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


    List<Data> list;
    OnCheckedChangeListener listener;

    public ListAdapter(List<Data> list, OnCheckedChangeListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.name_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.checkBox.setText(list.get(position).getName());
        holder.checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            listener.OnCheckedChange(position, isChecked);
            holder.setCheck(isChecked);
        });
        holder.checkBox.setChecked(list.get(position).isSelected);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<Data> list) {
        this.list.clear();
        this.list.addAll(list);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.name_check_box);
        }

        public void setCheck(boolean isChecked) {
            if (isChecked) {
                checkBox.setPaintFlags(checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }else {
                checkBox.setPaintFlags(checkBox.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            }
        }
    }

    public static class Data {
        String name;
        boolean isSelected;

        public Data(String name, boolean isSelected) {
            this.name = name;
            this.isSelected = isSelected;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }
}
