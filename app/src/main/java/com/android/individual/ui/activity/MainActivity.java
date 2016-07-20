package com.android.individual.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.android.individual.R;
import com.android.individual.ui.base.BaseActivity;
import com.android.individual.utils.netstatus.NetUtils;

public class MainActivity extends BaseActivity {
    private long firstTime=0l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==event.KEYCODE_BACK){
            long secondTime = System.currentTimeMillis();
            if (secondTime-firstTime>3000){
//                showToast("再按一次返回键退出");
                Toast.makeText(getApplicationContext(),R.string.kill_app,Toast.LENGTH_LONG).show();
                firstTime = System.currentTimeMillis();
                return true;
            }else {
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                System.exit(0);
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
