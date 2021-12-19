package br.com.jumbo.main;

import br.com.jumbo.conn.GraficoViagensConn;
import br.com.jumbo.conn.ViagensConn;
import br.com.jumbo.controller.BancoControler;
import br.com.jumbo.controller.CargoControler1;
import br.com.jumbo.controller.ColaboradorControler;
import br.com.jumbo.controller.CoresControler;
import br.com.jumbo.controller.EnderecoControler;
import br.com.jumbo.controller.FuncoesDetalheController;
import br.com.jumbo.controller.ModelosControler;
import br.com.jumbo.controller.PessoasControler;
import br.com.jumbo.controller.ProdutoControler;
import br.com.jumbo.controller.RateioViagensController;
import br.com.jumbo.controller.RoupasControler;
import br.com.jumbo.controller.VeiculoControler;
import br.com.jumbo.controller.ViagensControler;

import org.openswing.swing.mdi.client.*;
import java.sql.Connection;

/**
 * <p>
 * Title: OpenSwing Framework</p>
 * <p>
 * Description: Client Facade, called by the MDI Tree.</p>
 * <p>
 * Copyright: Copyright (C) 2014 João Paulo</p>
 * <p>
 * </p> @author João Paulo
 *
 * @version 1.3
 */
public class ClienteFachada implements ClientFacade {

    private Connection conn = null;

    public ClienteFachada(Connection conn) {
        this.conn = conn;
    }

    public void getVeiculo() {
        new VeiculoControler(conn);
    }

    public void getColaborador() {
        new ColaboradorControler(conn);
    }

    public void getViagens() {
        new ViagensControler(conn);
    }

    public void getRateioViagens() {
        new RateioViagensController(conn);
    }

    public void getProduto() {
        new ProdutoControler(conn);
    }

    public void getCores() {
        new CoresControler(conn);
    }

    public void getModelos() {
        new ModelosControler(conn);
    }

    public void getPessoas() {
        new PessoasControler(conn);
    }

    public void getRoupas() {
        new RoupasControler(conn);
    }

    public void getBanco() {
        new BancoControler(conn);
    }

    public void getEndereco() {
        new EnderecoControler(conn);
    }

    public void getCargos() {
        new CargoControler1(conn);
    }
    
     public void getViagensRelatorio() {
        new ViagensConn(conn);
    }
      public void getViagensGraficos() {
        new GraficoViagensConn(conn);
    }
}
