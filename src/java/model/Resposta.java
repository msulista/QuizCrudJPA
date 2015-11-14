/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author marcus.rodrigues
 */
@Embeddable
public class Resposta implements Serializable {
    
    private String respostaTexto;    
    private boolean verdadeira;

    public Resposta() {
    }
    
    public Resposta(String respostaTexto, boolean verdadeira) {
        this.respostaTexto = respostaTexto;
        this.verdadeira = verdadeira;
    }
    
    public String getRespostaTexto() {
        return respostaTexto;
    }

    public void setRespostaTexto(String respostaTexto) {
        this.respostaTexto = respostaTexto;
    }

    public boolean isVerdadeira() {
        return verdadeira;
    }

    public void setVerdadeira(boolean verdadeira) {
        this.verdadeira = verdadeira;
    }
    
    
    
}
