package com.jh.sh.jhsdk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jh.sh.jhsdk.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by phoenix on 2017/4/22.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.MyViewHolder> {

    private Context context;
    private List<String> texts = Arrays.asList("充值", "账单记录", "我的代金券", "安全中心", "帮助Q&A");

    public FirstAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jh_item_first, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(texts.get(position));
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.id_text);
        }
    }
}
