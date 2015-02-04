package de.zell.quiz.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import de.zell.android.util.PropertiesProvider;
import de.zell.android.util.activities.MainNavigationActivity;
import de.zell.android.util.json.JSONUnmarshaller;
import de.zell.quiz.activities.fragments.QuizViewPagerFragment;
import de.zell.quiz.entities.Answer;
import de.zell.quiz.entities.Quiz;
import de.zell.quiz.entities.QuizList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuizMainActivity extends MainNavigationActivity {

  /**
   * The name of the properties file.
   */
  public static final String PROP_FILE = "moccha.properties";

  /**
   * The properties provider instance, to read the property file.
   */
  public static final PropertiesProvider propProvider = PropertiesProvider.getInstance();

  /**
   * Static initializer to initialize the properties provider with the moccha
   * properties file.
   */
  static {
    PropertiesProvider.setPropertyFile(QuizMainActivity.class, PROP_FILE);
  }

  public static final Integer QUIZ_1_ID = R.raw.quiz1;
  public static final Integer QUIZ_2_ID = 1;
  public static final String QUIZ_1_NAME = "Quiz1";
  public static final String QUIZ_2_NAME = "Quiz2";
  /**
   * The available fragments which can be selected, the names are shown in the
   * left menu of the navigation drawer.
   */
  public static final String[] FRAGMENT_NAMES = {QUIZ_1_NAME};

  public Fragment createQuizFragment(Integer quiz) {
    Bundle b = new Bundle();
    QuizList list = readQuizList(quiz);
    b.putSerializable(QuizViewPagerFragment.ARG_ENITY, list);
    Fragment frg = new QuizViewPagerFragment();
    frg.setArguments(b);
    return frg;
  }

  private QuizList readQuizList(Integer quiz) {
    QuizList list = new QuizList();
    try {
      InputStream stream = getResources().openRawResource(quiz);
      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
      StringBuilder strBuilder = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        strBuilder.append(line);
      }
      JSONObject obj = new JSONObject(strBuilder.toString());
      list = JSONUnmarshaller.unmarshall(obj, QuizList.class);
    } catch (IOException ex) {
      Logger.getLogger(QuizMainActivity.class.getName()).log(Level.SEVERE, null, ex);
    } catch (JSONException ex) {
      Logger.getLogger(QuizMainActivity.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
  }

  @Override
  protected Fragment[] getNavigationFragments() {
    final Fragment[] FRAGMENTS = {createQuizFragment(QUIZ_1_ID)};
    return FRAGMENTS;
  }

  @Override
  protected String[] getNavigationFragmentNames() {
    return FRAGMENT_NAMES;
  }

  @Override
  protected void startSearch(String query) {
  }
}
