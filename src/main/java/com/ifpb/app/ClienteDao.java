package com.ifpb.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDao {
    private Connection conexao;
    
    public ArrayList<Cliente> getClientes() throws SQLException{
        ArrayList<Cliente> clientes = new ArrayList<>();
        inicializaConexao();
        ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM cliente");
        while(rs.next()){
            Cliente c = new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"));
            clientes.add(c);
        }
        rs.close();
        fechaConexao();
        return clientes;
    }

    private void inicializaConexao(){
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://host-banco:5432/dac-cliente";
            String usuario = "postgres";
            String senha = "pgadmin";
            this.conexao = DriverManager.getConnection(url,usuario,senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void fechaConexao(){
        try {
            this.conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
