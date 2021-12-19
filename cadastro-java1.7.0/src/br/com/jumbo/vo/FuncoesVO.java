/*
 * The MIT License
 *
 * Copyright 2014 João Paulo Gomes Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * The author may be contacted at: jumbo.vg@hotmail.com</p>
 *
 * João Paulo Gomes Silva
 *
 * JUMBO SISTEMAS
 * Versão 1.0
 */
package br.com.jumbo.vo;

import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author vovo
 */
public class FuncoesVO extends ValueObjectImpl {

    private Integer idFuncoes;
    private String funDescricao;

    public FuncoesVO() {

    }

    /**
     * @return the idFuncoes
     */
    public Integer getIdFuncoes() {
        return idFuncoes;
    }

    /**
     * @return the funDescricao
     */
    public String getFunDescricao() {
        return funDescricao;
    }

    /**
     * @param funDescricao the funDescricao to set
     */
    public void setFunDescricao(String funDescricao) {
        this.funDescricao = funDescricao;
    }

    /**
     * @param idFuncoes the idFuncoes to set
     */
    public void setIdFuncoes(Integer idFuncoes) {
        this.idFuncoes = idFuncoes;
    }

}
