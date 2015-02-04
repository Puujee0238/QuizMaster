/*
 */
package de.zell.quiz.entities;

import de.zell.android.util.db.Entity;
import de.zell.android.util.json.JSONElement;
import java.util.ArrayList;
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
}
