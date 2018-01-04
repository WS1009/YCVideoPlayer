package cn.jzvd.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import cn.jzvd.JZVideoPlayerStandard;
import cn.jzvd.R;

/**
 * 全屏展示后，是否展示分享按钮
 */
public class JZVideoPlayerStandardShowShareButtonAfterFullscreen extends JZVideoPlayerStandard {

    public ImageView shareButton;

    public JZVideoPlayerStandardShowShareButtonAfterFullscreen(Context context) {
        super(context);
    }

    public JZVideoPlayerStandardShowShareButtonAfterFullscreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void init(Context context) {
        super.init(context);
        shareButton = (ImageView)findViewById(R.id.share);
        shareButton.setOnClickListener(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_standard_with_share_button;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.share) {
            Toast.makeText(getContext(), "Whatever the icon means", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setUp(String url, int screen, Object... objects) {
        super.setUp(url, screen, objects);
        if (currentScreen == SCREEN_WINDOW_FULLSCREEN) {
            shareButton.setVisibility(View.VISIBLE);
        } else {
            shareButton.setVisibility(View.INVISIBLE);
        }
    }
}
