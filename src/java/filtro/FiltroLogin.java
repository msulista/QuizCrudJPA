/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import bean.LoginMB;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcus.rodrigues
 */
@WebFilter(filterName = "FiltroLogin", urlPatterns = {"/faces/login.xhtml"})
public class FiltroLogin implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        LoginMB login = (LoginMB) hsr.getSession().getAttribute("loginMB");
        if(login!=null && login.logadoOn()){
            if(login.eAdmin()){
                resp.sendRedirect(hsr.getContextPath()+"/faces/admin/index.xhtml");
            }else{
                resp.sendRedirect(hsr.getContextPath()+"/faces/usuario/index.xhtml");
            }
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        
    }
    
    
}
