/*
 * Copyright (C) 2015 Christopher Zell <zelldon91@googlemail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.zell.quiz.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import de.zell.android.util.PropertiesProvider;
import de.zell.android.util.activities.MainNavigationActivity;
import de.zell.android.util.json.JSONUnmarshaller;
import de.zell.quiz.activities.fragments.QuizViewPagerFragment;
import de.zell.quiz.entities.QuizList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
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
  public static final Integer QUIZ_2_ID = R.raw.quiz2;
  public static final String QUIZ_1_NAME = "Quiz1";
  public static final String QUIZ_2_NAME = "Quiz2";
  /**
   * The available fragments which can be selected, the names are shown in the
   * left menu of the navigation drawer.
   */
  public static final String[] FRAGMENT_NAMES = {QUIZ_1_NAME, QUIZ_2_NAME};

  public Fragment createQuizFragment(Integer quiz) {
    Bundle b = new Bundle();
    QuizList list = readQuizList(quiz);
    b.putSerializable(QuizViewPagerFragment.ARG_ENTITY, list);
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
    final Fragment[] FRAGMENTS = {createQuizFragment(QUIZ_1_ID), createQuizFragment(QUIZ_2_ID)};
    return FRAGMENTS;
  }

  @Override
  protected String[] getNavigationFragmentNames() {
    return FRAGMENT_NAMES;
  }

  @Override
  protected void startSearch(String query) {
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return false;
  }
  
  
}
