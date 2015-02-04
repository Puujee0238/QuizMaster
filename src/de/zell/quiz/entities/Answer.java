/*
 */
package de.zell.quiz.entities;

import de.zell.android.util.db.Entity;
import de.zell.android.util.json.JSONElement;

/**
 *
 * @author Christopher Zell <zelldon91@googlemail.com>
 */
public class Answer implements Entity<String>{

  @JSONElement(name = "answer")
  public String answer;
  @JSONElement(name = "correct")
  public Boolean correct;

  public Answer() {
    this.correct = false;
  }
  
  public String getID() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public String getTableName() {
    return Answer.class.getName();
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public Boolean getCorrect() {
    return correct;
  }

  public void setCorrect(Boolean correct) {
    this.correct = correct;
  }
  
  
  
}
