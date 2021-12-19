/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jumbo.vo;

import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Joao
 */
public class UsuarioVO extends ValueObjectImpl{
    
    private Integer uCod;
    private String uNome;
    private String uLogin;
    private String uSenha;
    
    public UsuarioVO(){
        
    }

    /**
     * @return the uCod
     */
    public Integer getuCod() {
        return uCod;
    }

    /**
     * @param uCod the uCod to set
     */
    public void setuCod(Integer uCod) {
        this.uCod = uCod;
    }

    /**
     * @return the uNome
     */
    public String getuNome() {
        return uNome;
    }

    /**
     * @param uNome the uNome to set
     */
    public void setuNome(String uNome) {
        this.uNome = uNome;
    }

    /**
     * @return the uLogin
     */
    public String getuLogin() {
        return uLogin;
    }

    /**
     * @param uLogin the uLogin to set
     */
    public void setuLogin(String uLogin) {
        this.uLogin = uLogin;
    }

    /**
     * @return the uSenha
     */
    public String getuSenha() {
        return uSenha;
    }

    /**
     * @param uSenha the uSenha to set
     */
    public void setuSenha(String uSenha) {
        this.uSenha = uSenha;
    }
    
 
    


    
    
}
