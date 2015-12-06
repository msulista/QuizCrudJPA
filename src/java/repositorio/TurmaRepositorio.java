/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import dao.TurmaDaoBd;
import java.util.List;
import model.Turma;

/**
 *
 * @author marcus.rodrigues
 */
public class TurmaRepositorio {
    
    private TurmaDaoBd turmaDaoBd;

    public TurmaRepositorio() {
        this.turmaDaoBd = new TurmaDaoBd();
    }
    
    public void addTurma(Turma turma){
        this.turmaDaoBd.inserir(turma);
    }
    public void edita(Turma turma){
        this.turmaDaoBd.atualizar(turma);
    }
    public List<Turma> getTurmas(){
        return turmaDaoBd.listar();
    }
    
    public void deletaTurma(Turma turma){
        this.turmaDaoBd.deletar(turma);
    }
    
}
