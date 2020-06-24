package com.byrinat.arabiclearn.activityes.letterInfo;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.byrinat.arabiclearn.R;
import com.byrinat.arabiclearn.objects.Letter;
import com.byrinat.arabiclearn.objects.LetterVowel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterLetterVowels extends RecyclerView.Adapter<AdapterLetterVowels.ViewHolder> {
    OnCurrentItemClickListener onCurrentItemClickListener;
    ArrayList<LetterVowel> letterVowels;

int learnedProgress=0;
    public AdapterLetterVowels(ArrayList<LetterVowel> letterVowels) {

        this.letterVowels = letterVowels;

    }
    public AdapterLetterVowels(ArrayList<LetterVowel> letterVowels, OnCurrentItemClickListener onCurrentItemClickListener) {
        this.onCurrentItemClickListener = onCurrentItemClickListener;
        this.letterVowels = letterVowels;

    }

    public LetterVowel getItem(Integer position) {
        return letterVowels.get(position);
    }







    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.letter_vowels_item, parent, false);




        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LetterVowel letterVowel=letterVowels.get(position);
        holder.tv_arabicLetter.setText(letterVowel.getArabic_letter());
        holder.tv_russ_transcription.setText(letterVowel.getTranscription());

    }

    @Override
    public int getItemViewType(int position) {
      return position;
    }

    @Override
    public int getItemCount() {
        //int size=0;
        // for(StatusForRvStatuses status :statusRoles){
        //     if(status.isShow())size++;
        // }
        return letterVowels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        @BindView(R.id.progressBar2)
        ProgressBar progressBar2;
        @Nullable
        @BindView(R.id.root_view2)
        ConstraintLayout root_view;
        @Nullable
        @BindView(R.id.tv_arabicLetter)
        TextView tv_arabicLetter;
        @Nullable
        @BindView(R.id.tv_russ_transcription)
        TextView tv_russ_transcription;


        ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);


        }

    }

    public interface OnCurrentItemClickListener {
        void onItemClick(Letter letter, int position);
    }
}
