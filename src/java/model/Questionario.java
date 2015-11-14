/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marcus.rodrigues
 */
public class Questionario {
    
    private String materia;
    private double peso;
    private String pergunta;
    private String respostaCorreta;
    private String respostaErrada01;
    private String respostaErrada02;
    private String respostaErrada03;

    public Questionario(String materia, double peso, String pergunta, String respostaCorreta, String respostaErrada01, String respostaErrada02, String respostaErrada03) {
        this.materia = materia;
        this.peso = peso;
        this.pergunta = pergunta;
        this.respostaCorreta = respostaCorreta;
        this.respostaErrada01 = respostaErrada01;
        this.respostaErrada02 = respostaErrada02;
        this.respostaErrada03 = respostaErrada03;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public String getRespostaErrada01() {
        return respostaErrada01;
    }

    public void setRespostaErrada01(String respostaErrada01) {
        this.respostaErrada01 = respostaErrada01;
    }

    public String getRespostaErrada02() {
        return respostaErrada02;
    }

    public void setRespostaErrada02(String respostaErrada02) {
        this.respostaErrada02 = respostaErrada02;
    }

    public String getRespostaErrada03() {
        return respostaErrada03;
    }

    public void setRespostaErrada03(String respostaErrada03) {
        this.respostaErrada03 = respostaErrada03;
    }
    
    
    
}
