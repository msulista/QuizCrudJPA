/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Quiz;

/**
 *
 * @author marcus.rodrigues
 */
public class QuizRepositorio {
    
    private List<Quiz> quizList;

    public QuizRepositorio() {
        this.quizList = new ArrayList<>();
    }

    public void addQuiz(Quiz quiz){
        quizList.add(quiz);
    }
    
    public List<Quiz> getQuizs(){
        return quizList;
    }
    
    public void deletaQuiz(Quiz quiz){
        quizList.remove(quiz);
    }
    
    
    
    
}
