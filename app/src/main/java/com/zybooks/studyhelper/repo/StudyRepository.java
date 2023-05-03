package com.zybooks.studyhelper.repo;

import android.content.Context;
import com.zybooks.studyhelper.model.Question;
import com.zybooks.studyhelper.model.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudyRepository {

    private static StudyRepository mStudyRepo;
    private final List<Subject> mSubjectList;
    private final HashMap<Long, List<Question>> mQuestionMap;

    public static StudyRepository getInstance(Context context) {
        if (mStudyRepo == null) {
            mStudyRepo = new StudyRepository(context);
        }
        return mStudyRepo;
    }

    private StudyRepository(Context context) {

        mSubjectList = new ArrayList<>();
        mQuestionMap = new HashMap<>();

        addStarterData();
    }

    private void addStarterData() {
        // Add a few subjects and questions
        Subject subject = new Subject("SPAGHETTI");
        subject.setId(1);
        addSubject(subject);

        Question question = new Question();
        question.setId(1);
        question.setText("Spaghetti");
        question.setAnswer("1lb of Angelhair pasta \n 2 cups water \n 8 oz of canned tomato sauce");
        question.setInstructions("Boil it you fucking moron");
        question.setSubjectId(1);
        addQuestion(question);


        subject = new Subject("History");
        subject.setId(2);
        addSubject(subject);

        question = new Question();
        question.setId(3);
        question.setText("On what date was the U.S. Declaration of Independence adopted?");
        question.setAnswer("July 4, 1776");
        question.setSubjectId(2);
        addQuestion(question);

        subject = new Subject("Computing");
        subject.setId(3);
        addSubject(subject);
    }

    public void addSubject(Subject subject) {
        mSubjectList.add(subject);
        List<Question> questionList = new ArrayList<>();
        mQuestionMap.put(subject.getId(), questionList);
    }

    public Subject getSubject(long subjectId) {
        for (Subject subject: mSubjectList) {
            if (subject.getId() == subjectId) {
                return subject;
            }
        }

        return null;
    }

    public List<Subject> getSubjects() {
        return mSubjectList;
    }

    public void addQuestion(Question question) {
        List<Question> questionList = mQuestionMap.get(question.getSubjectId());
        if (questionList != null) {
            questionList.add(question);
        }
    }

    public List<Question> getQuestions(long subjectId) {
        return mQuestionMap.get(subjectId);
    }
}