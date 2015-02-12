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
package de.zell.quiz.activities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import de.zell.android.util.fragments.EntityViewPagerFragment;
import de.zell.quiz.entities.QuizList;

/**
 *
 * @author Christopher Zell <zelldon91@googlemail.com>
 */
public class QuizViewPagerFragment extends EntityViewPagerFragment {

  private QuizList list;
  
  @Override
  protected void loadEntity() {
    //nothing todo
  }

  @Override
  protected FragmentPagerAdapter getPageAdapter(FragmentManager mgr) {
    return new QuizPager(mgr);
  }

  @Override
  protected void extractEntityInformation() {
    list = ((QuizList) entity);
    list.shuffle();
  }
  
  
  /**
   * The FragmentPagerAdapter for the quizzes.
   */
  public class QuizPager extends FragmentPagerAdapter {

    public QuizPager(FragmentManager fm) {
      super(fm);
    }

    @Override
    public int getCount() {
      return list.size();
    }

    //get Item basically calls the subFragments using the newInstance method
    @Override
    public Fragment getItem(int position) {
      Bundle args = new Bundle();
      args.putSerializable(QuizFragment.ARG_QUIZ, list.get(position));
      Fragment frg = new QuizFragment();
      frg.setArguments(args);
      return frg;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return list.get(position).getQuestion();
    }
  }
  
  
  
}
