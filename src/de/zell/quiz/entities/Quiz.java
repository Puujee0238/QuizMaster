/*
 */
package de.zell.quiz.entities;

import de.zell.android.util.db.Entity;
import de.zell.android.util.json.JSONElement;
import java.util.List;

/**
 *
 * @author Christopher Zell <zelldon91@googlemail.com>
 */
public class Quiz implements Entity<String> {
  
  @JSONElement(name = "question")
  private String question;
  @JSONElement(name = "answers")
  private List<Answer> answers;

  public Quiz() {
  }

  public String getID() {
    return question;
  }

  public String getTableName() {
    return Quiz.class.getName();
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }
  
}
