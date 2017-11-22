package com.baway.liuheng.mv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    String s1="http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";
    String s2="http://player.youku.com/player.php/sid/XMjUyODI2NDc2MA==/v.swf";//不支持swf格式的视频播放

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("jiecaovideoplayer的使用");
        jcVideoPlayerStandard= (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
        jcVideoPlayerStandard.setUp(s1,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"达奚阿碧");
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
