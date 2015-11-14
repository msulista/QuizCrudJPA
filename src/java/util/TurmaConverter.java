/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import bean.TurmaMB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Turma;

/**
 *
 * @author marcus.rodrigues
 */
    @FacesConverter(value = "turmaConverter")
    public class TurmaConverter implements Converter {  

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null){
            return null;
        }
        TurmaMB turmaMB = context.getApplication().evaluateExpressionGet(context, "#{turmaMB}", TurmaMB.class);
        
        Turma turma = turmaMB.findTurmabyNome(value);
        return turma;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    
        String string = null;
        if(value instanceof Turma){
            string = ((Turma) value).getNome();
        }
        return string;        
    }
             
      
}  
