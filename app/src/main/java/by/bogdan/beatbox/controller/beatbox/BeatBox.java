package by.bogdan.beatbox.controller.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssets;
    private List<Sound> mSounds;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        mSounds = new ArrayList<>();
        loadSounds();
    }

    private void loadSounds() {
        try {
            String[] soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, String.format("Found %d sounds", soundNames.length));
            for (String filename : soundNames) {
                String assetPath = SOUNDS_FOLDER + "/" + filename;
                mSounds.add(new Sound(assetPath));
            }
        } catch (IOException e) {
            Log.e(TAG, "Couldn't list assets", e);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
