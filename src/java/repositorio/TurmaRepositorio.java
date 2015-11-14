/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Turma;

/**
 *
 * @author marcus.rodrigues
 */
public class TurmaRepositorio {
    
    private List<Turma> turmas;

    public TurmaRepositorio() {
        this.turmas = new ArrayList<Turma>();
        this.turmas.add(new Turma("PI2QN", "Programação para Internet II", "Quinta", "604A", "ADS", "4"));
        this.turmas.add(new Turma("ES3TN", "Engenharia de Software III", "Terça", "503A", "ADS", "4"));
        this.turmas.add(new Turma("PD4N", "Projeto e Desenvolvimento", "Quarta", "702A", "ADS", "4"));
    }
    
    public void addTurma(Turma turma){
        turmas.add(turma);
    }
    
    public List<Turma> getTurmas(){
        return turmas;
    }
    
    public void deletaTurma(Turma turma){
        turmas.remove(turma);
    }
    
}
