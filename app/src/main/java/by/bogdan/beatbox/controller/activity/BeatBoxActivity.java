package by.bogdan.beatbox.controller.activity;

import android.support.v4.app.Fragment;

import by.bogdan.beatbox.controller.fragment.BeatBoxFragment;

public class BeatBoxActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
