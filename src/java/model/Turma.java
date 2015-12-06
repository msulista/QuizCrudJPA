/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

/**
 *
 * @author marcus.rodrigues
 */
@Entity
public class Turma implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "turm_seq", sequenceName = "turm_seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "turm_seq")
    private Integer id;
    
    private String nome;
    private String materia;
    private String diaSemana;
    private String sala;
    private String curso;
    private String semestre;
    
    @ManyToMany(mappedBy = "turma")
//    @ManyToMany(cascade = CascadeType.REFRESH)
//    @JoinTable(name = "turma", joinColumns = {
//                                                @JoinColumn(name = "alunos_id", nullable = false)}, 
//                                inverseJoinColumns = {@JoinColumn(name = "turma_id", nullable = false)})
    private List<Usuario> alunos;

    @Transient
    private int quantidadeAlunos;  
    
     public Turma() {        
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

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(int quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }
    
    public void adicionaAluno(Usuario usuario){
        this.alunos.add(usuario);
    }
    
    public int quantidadeAlunos(){        
        return this.alunos.size();
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
    
}
