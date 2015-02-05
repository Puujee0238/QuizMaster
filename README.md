# QuizMaster
Contains an Android application which creates multiple choice quizzes via given json questions.
The application is named QuizMaster can be used to learn for a exam or something else.

# Example JSON file

```json
{
  "quizzes":[
    { "question":"Quest?",
      "noShuffle":false, 
      "answers":[
       {"answer":"Answer1"},
       {"answer":"Answer2"},
       {"answer":"Answer3", "correct":true},
       {"answer":"Answer4"}
      ]
    }
  ]
}
```
'noShuffle' is a Optional Parameter: indicates if the answer order is necessary or not if not the answers are shuffled!
