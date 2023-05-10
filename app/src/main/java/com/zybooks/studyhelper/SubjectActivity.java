package com.zybooks.studyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zybooks.studyhelper.model.Food;
import com.zybooks.studyhelper.viewmodel.SubjectListViewModel;
import java.util.List;

public class SubjectActivity extends AppCompatActivity
        implements SubjectDialogFragment.OnSubjectEnteredListener {

    private SubjectAdapter mSubjectAdapter;
    private RecyclerView mRecyclerView;
    private int[] mSubjectColors;
    private SubjectListViewModel mSubjectListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mSubjectListViewModel = new SubjectListViewModel(getApplication());

        mSubjectColors = getResources().getIntArray(R.array.subjectColors);

//        findViewById(R.id.add_subject_button).setOnClickListener(view -> addSubjectClick());

        // Create 2 grid layout columns
        mRecyclerView = findViewById(R.id.subject_recycler_view);
        RecyclerView.LayoutManager gridLayoutManager =
                new GridLayoutManager(getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        // Show the subjects
        updateUI(mSubjectListViewModel.getSubjects());
    }

    private void updateUI(List<Food> foodList) {
        mSubjectAdapter = new SubjectAdapter(foodList);
        mRecyclerView.setAdapter(mSubjectAdapter);
    }

    //going to reuse this to instead let the player know when a recipe is added to favorites

//    @Override
//    public void onSubjectEntered(String subjectText) {
//        if (subjectText.length() > 0) {
//            Subject subject = new Subject(subjectText);
//
//            updateUI(mSubjectListViewModel.getSubjects());
//
//            Toast.makeText(this, "Added " + subjectText + "to favorites", Toast.LENGTH_SHORT).show();
//        }
//    }

    private void addSubjectClick() {
        SubjectDialogFragment dialog = new SubjectDialogFragment();
        dialog.show(getSupportFragmentManager(), "subjectDialog");
    }

    private class SubjectHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Food mFood;
        private final TextView mSubjectTextView;

        public SubjectHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.recycler_view_items, parent, false));
            itemView.setOnClickListener(this);
            mSubjectTextView = itemView.findViewById(R.id.subject_text_view);
        }

        public void bind(Food food, int position) {
            mFood = food;
            mSubjectTextView.setText(food.getText());

            // Make the background color dependent on the length of the subject string
            int colorIndex = food.getText().length() % mSubjectColors.length;
            mSubjectTextView.setBackgroundColor(mSubjectColors[colorIndex]);
        }

        @Override
        public void onClick(View view) {
            // Start QuestionActivity with the selected subject
            Intent intent = new Intent(SubjectActivity.this, QuestionActivity.class);
            intent.putExtra(QuestionActivity.EXTRA_SUBJECT_ID, mFood.getId());
            intent.putExtra(QuestionActivity.EXTRA_SUBJECT_TEXT, mFood.getText());

            startActivity(intent);
        }
    }

    private class SubjectAdapter extends RecyclerView.Adapter<SubjectHolder> {

        private final List<Food> mFoodList;

        public SubjectAdapter(List<Food> foods) {
            mFoodList = foods;
        }

        @NonNull
        @Override
        public SubjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new SubjectHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(SubjectHolder holder, int position){
            holder.bind(mFoodList.get(position), position);
        }

        @Override
        public int getItemCount() {
            return mFoodList.size();
        }
    }
}