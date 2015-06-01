/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letiris;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author purpleside
 */
public class Persistencia {
    private Connection conn;
    public Persistencia(){
    try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            String connectionString = "jdbc:mysql://localhost:3306/letiris?user=root&password=&useUnicode=true&characterEncoding=UTF-8";
            this.conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            String connectionString = "jdbc:mysql://localhost:3306/letiris?user=root&password=&useUnicode=true&characterEncoding=UTF-8";
            return DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Funcionarios getFuncionarioPorLogin(String login) throws SQLException {
        Funcionarios func = new Funcionarios();
        
// executa um select
        try (PreparedStatement stmt = this.conn.prepareStatement("select * from funcionarios WHERE login LIKE '" + login + "'")) {
            // executa um select
            ResultSet rs = stmt.executeQuery();
            
// itera no ResultSet
            while (rs.next()) {
                func.setLogin(rs.getString("login"));
                func.setSenha(rs.getString("senha"));
                func.setNome(rs.getString("nome"));
                func.setEmail(rs.getString("email"));
                
            }
        }
        
        return func;
    }
    public static boolean deletarProduto(String codigo){
        System.out.println("conectando");
        // conectando
        Connection con = new Persistencia().getConnection();
        System.out.println("inserindo");
        // cria um preparedStatement
        String sql = "delete from produto WHERE codigo LIKE '"+codigo
                + "'";
        
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
       
            // executa
            stmt.execute();
            stmt.close();

            System.out.println("Deletado!");

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
        
    }
    public static boolean adicionaProduto(Produto produto) {
        System.out.println("conectando");
        // conectando
        Connection con = new Persistencia().getConnection();
        System.out.println("inserindo");
        // cria um preparedStatement
        String sql = "insert into produto"
                + " (codigo,nome,quantidade,precoOriginal, tipo, precoFinal, lucro)"
                + " values (?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);

            // preenche os valores
            stmt.setString(1, produto.getCodigo());
            stmt.setString(2, produto.getNome());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setFloat(4, produto.getPrecoOriginal());
            stmt.setString(5, produto.getTipo());
            stmt.setFloat(6, produto.getPrecoFinal());
            stmt.setFloat(7, produto.getLucro());
            // executa
            stmt.execute();
            stmt.close();

            System.out.println("Gravado!");

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    
    public static ArrayList<Object[]> getProdutos() {
        System.out.println("conectando");
        // conectando
        Connection con = new Persistencia().getConnection();
        System.out.println("procurando produtos");
        // cria um preparedStatement
        String sql = "select * from produto";
        PreparedStatement stmt;
       
      
        ArrayList <Object[]> teste = new ArrayList<> ();
        
        try {
            stmt = con.prepareStatement(sql);

           ResultSet rs = stmt.executeQuery();

// itera no ResultSet
           int i = 0;
        while (rs.next()) {
            Produto prod = new Produto();
            prod.setCodigo(rs.getString("codigo"));
            prod.setNome(rs.getString("nome"));
            prod.setQuantidade(rs.getInt("quantidade"));
            prod.setPrecoOriginal(rs.getFloat("precoOriginal"));
            prod.setTipo(rs.getString("tipo"));
            prod.setPrecoFinal();
            prod.setLucro(rs.getFloat("lucro"));
            
            System.out.println(prod.getNome());
            
            
            teste.add(prod.toArray());
            i++;
        }

            stmt.close();
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            return teste;
        }
        return teste;
    }
    
    

}
