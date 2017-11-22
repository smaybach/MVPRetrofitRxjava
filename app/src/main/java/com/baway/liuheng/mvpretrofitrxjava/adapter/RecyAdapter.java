package com.baway.liuheng.mvpretrofitrxjava.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.baway.liuheng.mvpretrofitrxjava.R;
import com.baway.liuheng.mvpretrofitrxjava.bean.UserBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by lenovo on 2017/11/22.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.MyViewHolder> {
    Context context;
    UserBean bean;

    public RecyAdapter(Context context, UserBean bean) {
        this.context = context;
        this.bean = bean;
    }

    //点击事件
    public interface OnItemclickListener{
        public void OnitemClick(View view,int position);
    }
    OnItemclickListener listener;

    public void setOnItemclickListener(OnItemclickListener listener) {
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recy_item, null);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnitemClick(view, (Integer) view.getTag());
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.title.setText(bean.ret.list.get(position).title);
        DraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(bean.ret.list.get(position).pic)
                .setAutoPlayAnimations(true)
                .build();
        holder.img.setController(build);
        
    }

    @Override
    public int getItemCount() {
        return bean.ret.list.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView img;
        private final TextView title;
        private final VideoView mv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mv = itemView.findViewById(R.id.mv);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
