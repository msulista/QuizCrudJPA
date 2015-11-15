/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import dao.QuizDaoBd;
import java.util.ArrayList;
import java.util.List;
import model.Quiz;

/**
 *
 * @author marcus.rodrigues
 */
public class QuizRepositorio {
    
    private List<Quiz> quizList;
    private QuizDaoBd quizDaoBd;

    public QuizRepositorio() {
        this.quizList = new ArrayList<>();
        this.quizDaoBd = new QuizDaoBd();
    }

    public void addQuiz(Quiz quiz){
        this.quizDaoBd.inserir(quiz);
    }
    
    public void editar(Quiz quiz){
        this.quizDaoBd.atualizar(quiz);
    }
    public List<Quiz> getQuizs(){
        return quizDaoBd.listar();
    }
    
    public void deletaQuiz(Quiz quiz){
        this.quizDaoBd.deletar(quiz);
    }
    
    
    
    
}
