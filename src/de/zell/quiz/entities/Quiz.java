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
import java.util.List;

/**
 *
 * @author Christopher Zell <zelldon91@googlemail.com>
 */
public class Quiz implements Entity<String> {
  
  @JSONElement(name = "question")
  private String question;
  @JSONElement(name = "notShuffle")
  private Boolean notShuffle;
  @JSONElement(name = "answers")
  private List<Answer> answers;

  public Quiz() {
    this.notShuffle = false;
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

  public Boolean getNotShuffle() {
    return notShuffle;
  }

  public void setNotShuffle(Boolean notShuffle) {
    this.notShuffle = notShuffle;
  }
  
}
