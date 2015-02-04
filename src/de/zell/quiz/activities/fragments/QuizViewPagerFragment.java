/*
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
    //nothing todo
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
