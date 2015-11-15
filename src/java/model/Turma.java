/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author marcus.rodrigues
 */
@Entity
public class Turma implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    
    private String nome;
    private String materia;
    private String diaSemana;
    private String sala;
    private String curso;
    private String semestre;
    
    @ManyToMany(mappedBy = "turma")
    private List<Usuario> alunos;

    public Turma() {
        this.alunos = new ArrayList<>();
    }
    
     public Turma(String nome, String materia, String diaSemana, String sala, String curso, String semestre) {        
        this.nome = nome;
        this.materia = materia;
        this.diaSemana = diaSemana;
        this.sala = sala;
        this.curso = curso;
        this.semestre = semestre;
        this.alunos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
    public List<Usuario> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Usuario> alunos) {
        this.alunos = alunos;
    }

    public void adicionaAluno(Usuario usuario){
        this.alunos.add(usuario);
    }
    
    public int quantidadeAlunos(){
        
        return this.alunos.size();
    }
    
}
