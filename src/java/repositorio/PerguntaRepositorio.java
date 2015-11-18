/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import dao.PerguntaDaoBd;
import java.util.List;
import model.Pergunta;
import model.Quiz;

/**
 *
 * @author marcus.rodrigues
 */
public class PerguntaRepositorio {
    
    private PerguntaDaoBd perguntaDao;

    public PerguntaRepositorio() {
        this.perguntaDao = new PerguntaDaoBd();
    }
    
    public void addPergunta(Pergunta pergunta){
        this.perguntaDao.inserir(pergunta);
    }
    
    public void editar(Pergunta pergunta){
        this.perguntaDao.atualizar(pergunta);
    }
    
    public List<Pergunta> getPerguntas(){
       return this.perguntaDao.listar();
    }
    public List<Pergunta> getPerguntasQuiz(Quiz quiz){
        return this.perguntaDao.listaPerguntaQuiz(quiz);
    }
    
    public void deletar(Pergunta pergunta){
        this.perguntaDao.deletar(pergunta);
    }
}
