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
