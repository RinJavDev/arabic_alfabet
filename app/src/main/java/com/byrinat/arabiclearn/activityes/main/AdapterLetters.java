package com.byrinat.arabiclearn.activityes.main;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.byrinat.arabiclearn.R;
import com.byrinat.arabiclearn.objects.Letter;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterLetters extends RecyclerView.Adapter<AdapterLetters.ViewHolder> {
    OnCurrentItemClickListener onCurrentItemClickListener;
    ArrayList<Letter> letters;

int learnedProgress=0;

    public AdapterLetters( ArrayList<Letter> letters,OnCurrentItemClickListener onCurrentItemClickListener) {
        this.onCurrentItemClickListener = onCurrentItemClickListener;
        this.letters = letters;
        int learnedCount=0;
        for(Letter letter:letters){
            if(letter.enable) learnedCount++;
        }
        learnedProgress= (int) (((float)learnedCount/letters.size())*100);
    }

    public Letter getItem(Integer position) {
        return letters.get(position);
    }







    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        System.out.println("viewType is "+viewType);
        if(viewType==0){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_item, parent, false);

        }else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.letters_item, parent, false);
        }

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        System.out.println("position "+position);
        if(position==0){

        holder.progressBar2.setProgress(learnedProgress);
        }else {
            position--;
            int finalPosition = position;

            holder.root_view.setOnClickListener((View v)->{
                onCurrentItemClickListener.onItemClick(letters.get((finalPosition)), finalPosition);
            });
//
            holder.tv_arabicLetter.setText(letters.get(finalPosition).name);
            holder.tv_russ_transcription.setText(letters.get(finalPosition).russian_name);
            if(letters.get(finalPosition).enable){
                holder.tv_arabicLetter.setVisibility(View.VISIBLE);
                holder.tv_russ_transcription.setVisibility(View.VISIBLE);
                holder.imageView.setVisibility(View.GONE);
            }
            else  {
                holder.tv_arabicLetter.setVisibility(View.INVISIBLE);
                holder.tv_russ_transcription.setVisibility(View.INVISIBLE);
                holder.imageView.setVisibility(View.VISIBLE);
            }
        }


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
        return letters.size()+1;
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
        @Nullable
        @BindView(R.id.imView)
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);


        }

    }

    public interface OnCurrentItemClickListener {
        void onItemClick(Letter letter, int position);
    }
}
