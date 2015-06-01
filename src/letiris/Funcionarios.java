/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letiris;

import java.sql.SQLException;

/**
 *
 * @author purpleside
 */
public class Funcionarios {

    private String login;
    private String senha;
    private String nome;
    private String email;

    public Funcionarios() {
        this.login = "";
        this.senha = "";
        this.nome = "";
        this.email = "";
    }

    public Funcionarios(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.nome = "";
        this.email = "";
    }

    public Funcionarios(String login, String senha, String nome, String email) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param login
     * @param senha
     * @return
     */
    public static boolean validaUsuario(String login, String senha) throws SQLException {
        Persistencia persistencia = new Persistencia();
        
        Funcionarios func = persistencia.getFuncionarioPorLogin(login);
        
        
        return func.getSenha().equalsIgnoreCase(senha);//login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("123456");
    }
}
