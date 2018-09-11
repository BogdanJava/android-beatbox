package by.bogdan.beatbox.controller.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import by.bogdan.beatbox.R;
import by.bogdan.beatbox.controller.beatbox.BeatBox;
import by.bogdan.beatbox.controller.beatbox.Sound;

@SuppressWarnings("ConstantConditions")
public class BeatBoxFragment extends Fragment {
    private BeatBox mBeatBox;

    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeatBox = new BeatBox(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beat_box, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_beat_box_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(
                getActivity(), 3
        ));
        recyclerView.setAdapter(new SoundAdapter(getActivity(), mBeatBox.getSounds()));
        return view;
    }
}

class SoundHolder extends RecyclerView.ViewHolder {
    private Button mButton;
    private Sound mSound;

    public SoundHolder(LayoutInflater inflater, ViewGroup container) {
        super(inflater.inflate(R.layout.list_item_sound, container, false));
        mButton = itemView.findViewById(R.id.list_item_sound_button);
    }

    public void bindSound(Sound sound) {
        mSound = sound;
        mButton.setText(mSound.getName());
    }
}

class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {
    private Activity mActivity;
    private List<Sound> mSounds;

    SoundAdapter(Activity activity, List<Sound> sounds) {
        mActivity = activity;
        mSounds = sounds;
    }

    @NonNull
    @Override
    public SoundHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        return new SoundHolder(inflater, viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundHolder soundHolder, int i) {
        soundHolder.bindSound(mSounds.get(i));
    }

    @Override
    public int getItemCount() {
        return mSounds.size();
    }
}
