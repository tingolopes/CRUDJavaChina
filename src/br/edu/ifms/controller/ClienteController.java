package br.edu.ifms.controller;

import br.edu.ifms.model.Cliente;
import br.edu.ifms.view.frmCliente;

/**
 *
 * @author Michell
 * @author Kleber
 */
public class ClienteController {
    private Cliente cliente;
    private frmCliente frmCliente;

    public ClienteController(Cliente cliente, frmCliente frmCliente) {
        this.cliente = cliente;
        this.frmCliente = frmCliente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public frmCliente getFrmCliente() {
        return frmCliente;
    }

    public void setFrmCliente(frmCliente frmCliente) {
        this.frmCliente = frmCliente;
    }
    
    
}
