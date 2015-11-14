/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Quiz;
import repositorio.QuizRepositorio;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@ApplicationScoped
public class QuizMB {
    
    private QuizRepositorio quizRepositorio;
    private Quiz quizSelecionado;

    public QuizMB() {
    }

    
    public QuizMB(QuizRepositorio quizRepositorio, Quiz quizSelecionado) {
        this.quizRepositorio = new QuizRepositorio();
        this.quizSelecionado = new Quiz();
    }

    public QuizRepositorio getQuizRepositorio() {
        return quizRepositorio;
    }

    public void setQuizRepositorio(QuizRepositorio quizRepositorio) {
        this.quizRepositorio = quizRepositorio;
    }

    public Quiz getQuizSelecionado() {
        return quizSelecionado;
    }

    public void setQuizSelecionado(Quiz quizSelecionado) {
        this.quizSelecionado = quizSelecionado;
    }
    
     
    //Cadastro
    public String cadastraQuiz(){
        adicionaQuiz();
        limparCadastro();
        
        return "listaQuiz";
    }
    public void adicionaQuiz(){
        this.quizRepositorio.addQuiz(quizSelecionado);
    }
    
    public void limparCadastro(){
        quizSelecionado = new Quiz();
    }
    
    //Edita
    
    public String editar(Quiz quiz){
        quizSelecionado = quiz;
        return "listaQuiz?faces-redirect=true";
    }
    
    public String atualizar(){
        
        return "index?faces-redirect=true";
    }
    
    public String remover(Quiz quiz){
        quizRepositorio.deletaQuiz(quiz);
        return "listaQuiz?faces-redirect=true";
    }
    
    //Gerenciamento
    
}
