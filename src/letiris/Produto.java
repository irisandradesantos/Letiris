/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letiris;

/**
 *
 * @author purpleside
 */
public class Produto {
    private String codigo;
    private String nome;
    private int quantidade;
    private float precoOriginal;
    private String tipo;
    private float precoFinal;
    private float lucro;

    public Produto(String codigo, String nome, int quantidade, float precoOriginal, String tipo, float lucro) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoOriginal = precoOriginal;
        this.tipo = tipo;
        this.lucro = lucro;
        this.precoFinal = calculaPrecoFinal();
    }

    Produto() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoOriginal() {
        return precoOriginal;
    }

    public void setPrecoOriginal(float precoOriginal) {
        this.precoOriginal = precoOriginal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal() {
        this.precoFinal = calculaPrecoFinal();
    }

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }
    
    public Object[] toArray(){
        Object [] obj = {this.codigo, this.nome, this.quantidade, this.precoOriginal, this.tipo, this.precoFinal, this.lucro};
        return obj;
    }
    
    private float calculaPrecoFinal(){
        double p = 100;
        //this.precoFinal = this.precoOriginal*this.lucro;
        //System.out.println("Calculando..."+this.precoFinal);
        return (this.precoOriginal + ((this.precoOriginal*this.lucro)/100));
    }   
    
    
    
}
