package com.baway.liuheng.mvpretrofitrxjava.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.baway.liuheng.mvpretrofitrxjava.R;
import com.baway.liuheng.mvpretrofitrxjava.adapter.RecyAdapter;
import com.baway.liuheng.mvpretrofitrxjava.bean.UserBean;
import com.baway.liuheng.mvpretrofitrxjava.presenter.RecyPresenter;
import com.baway.liuheng.mvpretrofitrxjava.view.RecyView;

public class MainActivity extends AppCompatActivity implements RecyView {

    private RecyclerView mRlv;
    private RecyAdapter adapter;
    private SwipeRefreshLayout mSfl;
    private RecyPresenter presenter;
    int a=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new RecyPresenter(this, this);
        presenter.show(a);
        initView();


    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void showRecy(UserBean been) {
        adapter = new RecyAdapter(this, been);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mRlv.setAdapter(adapter);
            }
        });
        adapter.setOnItemclickListener(new RecyAdapter.OnItemclickListener() {
            @Override
            public void OnitemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "达奚阿碧", Toast.LENGTH_SHORT).show();
            }
        });


    }
    //刷新条目  未出现效果
    @Override
    public void showModel(int pnum) {
        mSfl = (SwipeRefreshLayout) findViewById(R.id.sfl);
        mSfl.setColorSchemeResources(R.color.colorAccent,R.color.colorPrimaryDark);
        mSfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSfl.setRefreshing(false);
                        a++;
                        presenter.show(a);
                    }
                },2000);
            }
        });

    }
}
