/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Pergunta;
import model.Quiz;
import model.Resposta;
import repositorio.PerguntaRepositorio;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@RequestScoped
public class PerguntaMB {

    private PerguntaRepositorio perguntaRepositorio;
    private Pergunta perguntaSelecionada;
    private Quiz quiz;
    private String respostas[];
    /**
     * Creates a new instance of PerguntaMB
     */
    public PerguntaMB() {
        this.perguntaRepositorio = new PerguntaRepositorio();
        this.respostas = new String[4];
        this.perguntaSelecionada = new Pergunta();
        this.quiz = new Quiz();
    }

    public String[] getRespostas() {
        return respostas;
    }

    public void setRespostas(String[] respostas) {
        this.respostas = respostas;
    }
    
    public PerguntaRepositorio getPerguntaRepositorio() {
        return perguntaRepositorio;
    }

    public void setPerguntaRepositorio(PerguntaRepositorio perguntaRepositorio) {
        this.perguntaRepositorio = perguntaRepositorio;
    }

    public Pergunta getPerguntaSelecionada() {
        return perguntaSelecionada;
    }

    public void setPerguntaSelecionada(Pergunta perguntaSelecionada) {
        this.perguntaSelecionada = perguntaSelecionada;
    }
    
    public void cadastraPergunta(){
        cadastraResposta();
        this.perguntaSelecionada.setQuiz(quiz);
        this.perguntaRepositorio.addPergunta(perguntaSelecionada);
        perguntaSelecionada = new Pergunta();
    }
    
    public String carregarQuiz(Quiz q){
         this.quiz = q;         
         return "cadastroPergunta?faces-redirect=true";
    }
    public List<Pergunta> retornaListaPerguntas(){
        List<Pergunta> lista = perguntaRepositorio.getPerguntasQuiz(this.quiz);
        
        return (lista);
    }
    
    public void cadastraResposta(){
        for (int i = 0; i < 4; i++) {
            if(i == 0){
               Resposta resposta = new Resposta();
               resposta.setRespostaTexto(this.respostas[0]);
               resposta.setVerdadeira(true);
               this.perguntaSelecionada.adicionaResposta(resposta);
            }else{
                Resposta resposta = new Resposta();
                resposta.setRespostaTexto(this.respostas[i]);
                resposta.setVerdadeira(false);
                this.perguntaSelecionada.adicionaResposta(resposta);
            }
        }
    }
}
