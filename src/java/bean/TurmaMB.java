/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Turma;
import model.Usuario;
import repositorio.TurmaRepositorio;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@ApplicationScoped
public class TurmaMB {
    
    private Usuario proprietario;
    private TurmaRepositorio turmaRepositorio;
    private Turma turmaSelecionada;
    private Turma turmaConfirmacao;
    private List<Turma> turmas;

        
    public TurmaMB() {
        this.proprietario = new Usuario();        
        this.turmaRepositorio = new TurmaRepositorio();
        this.turmaSelecionada = new Turma();
        this.turmas = new ArrayList<>();
        listaTurmas();
    }

    public Usuario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }

    public TurmaRepositorio getTurmaRepositorio() {
        return turmaRepositorio;
    }

    public void setTurmaRepositorio(TurmaRepositorio turmaRepositorio) {
        this.turmaRepositorio = turmaRepositorio;
    }

    public Turma getTurmaSelecionada() {
        return turmaSelecionada;
    }

    public void setTurmaSelecionada(Turma turmaSelecionada) {
        this.turmaSelecionada = turmaSelecionada;
    }

    public Turma getTurmaConfirmacao() {
        return turmaConfirmacao;
    }

    public void setTurmaConfirmacao(Turma turmaConfirmacao) {
        this.turmaConfirmacao = turmaConfirmacao;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public Turma findTurmabyNome(String nome){
        for(Turma turma: turmaRepositorio.getTurmas()){
            if(turma.getNome().equals(nome)){
                return turma;
            }
        }
        return null;
    }
    
    //Cadastro
    public String cadastraTurma(){
        adicionaTurma();
        turmaConfirmacao = turmaSelecionada;
        limparCadastro();
        
        return "listaTurma";
    }
    public void adicionaTurma(){
        this.turmaRepositorio.addTurma(turmaSelecionada);
    }
    
    public String confirmacaoCadastro(){
        return "Turma " + turmaConfirmacao.getNome() + " cadastrada com sucesso!!!";
    }
    
    public void limparCadastro(){
        turmaSelecionada = new Turma();
    }
    
    //Edita
    
    public String editar(Turma turma){
        turmaSelecionada = turma;
        return "editaTurma?faces-redirect=true";
    }
    
    public String atualizar(){
        turmaRepositorio.edita(turmaSelecionada);
        return "listaTurma?faces-redirect=true";
    }
    
    public String remover(Turma turma){
        turmaRepositorio.deletaTurma(turma);
        return "listaTurma?faces-redirect=true";
    }
    
    //Gerenciamento
    
    public String cadastraAluno(Turma turma){
       
        FacesContext context = FacesContext.getCurrentInstance();
        LoginMB loginMB = (LoginMB) context.getExternalContext().getSessionMap().get("loginMB");
        Usuario usuario = loginMB.getUsuarioLogado();
        
        System.out.println("Tamanho array " + turmaSelecionada.getAlunos().size());
        System.out.println("ADICIONA ALUNO "+loginMB.getUsuarioLogado() + "ID TURMA " + turmaSelecionada.getId());
        this.turmaSelecionada = turma;
        usuario.addTurma(turma);
        this.turmaSelecionada.adicionaAluno(usuario);
        cadastraTurma();
        System.out.println("Tamanho array " + turmaSelecionada.getAlunos().size());
                     
       return "listaTurma?faces-redirect=true";
    }
    
    public void listaTurmas(){
        turmas = (turmaRepositorio.getTurmas());
    }
}
