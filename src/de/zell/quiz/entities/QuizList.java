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
package de.zell.quiz.entities;

import de.zell.android.util.db.Entity;
import de.zell.android.util.json.JSONElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Christopher Zell <zelldon91@googlemail.com>
 */
public class QuizList implements Entity<Void> {

  @JSONElement(name = "quizzes")
  private List<Quiz> quizzes;

  public QuizList() {
    this.quizzes = new ArrayList<Quiz>();
  }

  public List<Quiz> getQuizzes() {
    return quizzes;
  }

  public void setQuizzes(List<Quiz> quizzes) {
    this.quizzes = quizzes;
  }

  public Void getID() {
    return null;
  }

  public String getTableName() {
    return QuizList.class.getName();
  }

  public int size() {
    return quizzes.size();
  }

  public Quiz get(int at) {
    return quizzes.get(at);
  }

  public void add(Quiz q) {
    quizzes.add(q);
  }
  
  public void shuffle() {
    if (quizzes != null)
      Collections.shuffle(quizzes);
  }
}
