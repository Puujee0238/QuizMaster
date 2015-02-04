/*
 */
package de.zell.quiz.activities.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import de.zell.quiz.activities.R;
import de.zell.quiz.entities.Answer;
import de.zell.quiz.entities.Quiz;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Christopher Zell <zelldon91@googlemail.com>
 */
public class QuizFragment extends Fragment {

  public static final String ARG_QUIZ = "quiz";
  private static final String TAG_QUIZ = "tag.quiz";
  private static final Float QUIZ_HEAD_TEXT_SIZE = 32f;
  private static final Float QUIZ_BODY_TEXT_SIZE = 18f;
  private static final Integer QUIZ_CONTENT_MARGIN = 30;
  
  private Quiz q;
  private View header;
  private View content;

  public View getHeader() {
    return header;
  }

  public View getContent() {
    return content;
  }
  
  

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState == null) {
      savedInstanceState = getArguments();
    }

    if (savedInstanceState != null) {
      q = (Quiz) savedInstanceState.getSerializable(TAG_QUIZ);
      if (q == null) {
        q = (Quiz) savedInstanceState.getSerializable(ARG_QUIZ);
      }
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    Context ctx = getActivity();
    final LinearLayout ll = new LinearLayout(ctx);
    ll.setOrientation(LinearLayout.VERTICAL);

    if (q != null) {
      header = createQuestionHead(ctx);
      ll.addView(header);
      content = createQuestionContent(ctx);
      ll.addView(content);
    }
    return ll;
  }

  protected View createQuestionHead(Context ctx) {
    LinearLayout ll = new LinearLayout(ctx);
    ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                                        LayoutParams.WRAP_CONTENT));
    ll.setOrientation(LinearLayout.VERTICAL);
    ll.setBackgroundColor(getResources().getColor(R.color.light_gray));
    
    TextView question = new TextView(ctx);
    question.setText(q.getQuestion());
    LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                           LayoutParams.WRAP_CONTENT);
    params.gravity = Gravity.CENTER;
    question.setLayoutParams(params);
    question.setTextSize(QUIZ_HEAD_TEXT_SIZE);
    question.setTextColor(getResources().getColor(R.color.black));
    ll.addView(question);
    return ll;
  }

  protected View createQuestionContent(Context ctx) {
    List<Answer> answers = q.getAnswers();
    Collections.shuffle(answers);
    LinearLayout ll = new LinearLayout(ctx);
    ll.setOrientation(LinearLayout.VERTICAL);
    LayoutParams llParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                                             LayoutParams.MATCH_PARENT);
    ll.setLayoutParams(llParams);
    
    
    LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                           LayoutParams.WRAP_CONTENT);
    params.gravity = Gravity.CENTER;
    params.topMargin = QUIZ_CONTENT_MARGIN;
    RadioGroup grp = new RadioGroup(ctx);
    grp.setLayoutParams(params);
    grp.setOrientation(LinearLayout.VERTICAL);
    for (int i = 0; i < answers.size(); i++) {
      RadioButton btn = new RadioButton(ctx);
      btn.setText(answers.get(i).getAnswer());
      btn.setId(i);
      btn.setTextSize(QUIZ_BODY_TEXT_SIZE);
      btn.setLayoutParams(params);
      grp.addView(btn);
    }
    grp.setOnCheckedChangeListener(createOnCheckedChangeListener());
    ll.addView(grp);
    return ll;
  }
  
  protected RadioGroup.OnCheckedChangeListener createOnCheckedChangeListener() {
    return new RadioGroup.OnCheckedChangeListener() {

      public void onCheckedChanged(RadioGroup arg0, int arg1) {
        if (arg1 >= 0) {
          Answer a = q.getAnswers().get(arg1);
          if (a.getCorrect() != null && a.getCorrect()) {
            content.setBackgroundColor(getResources().getColor(R.color.green));
          } else {
            content.setBackgroundColor(getResources().getColor(R.color.red));
          }
        }
      }
    };
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putSerializable(TAG_QUIZ, q);
  }

}
