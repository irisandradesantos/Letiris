/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letiris;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.J;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 *
 * @author purpleside
 */
public class MyFrame extends javax.swing.JFrame {

    JPanel painel;
    JPanel painelImagem;
    JLabel login = new JLabel("Login:");
    JTextField loginTxt = new JTextField(5);
    JLabel senha = new JLabel("Senha:");
    JPasswordField senhaP = new JPasswordField(10);
    JTextField senhaTxt = new JTextField(6);
    JButton entrar = new JButton("Entrar");
    MyFrame frame = this;
    
private ImageIcon icon;
private JLabel imagem;
    /**
     * Creates new form MyFrame
     */
    public MyFrame() throws IOException {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        painel = new JPanel(new GridLayout(3, 2));
        painelImagem = new JPanel(new GridLayout(1, 1));
        URL url = getClass().getResource("/Imagens/logoMenor.jpg");
        //BufferedImage myPicture = ImageIO.read(new File("/Users/irisandradesantos/NetBeansProjects/Letiris/src/Imagens/logo.jpg"));
        //JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        
        icon = new  ImageIcon(url);
        

        //dentro do painel
        imagem = new JLabel(icon);
      
        imagem.setSize(30, 30);
        imagem.setVisible(true);
        painelImagem.add(imagem);
        painelImagem.setSize(30, 30);
        painel.add(login);
        painel.add(loginTxt);
        painel.add(senha);
        painel.add(senhaP);
        painel.setSize(30, 30);
        entrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (Funcionarios.validaUsuario(loginTxt.getText(), senhaP.getText())) {
                        System.out.println("entrou");
                        frame.setVisible(false);
                        MenuFrame menu = new MenuFrame();
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro", "Usuário ou senha errados", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Falhou ");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        entrar.setSize(10, 20);
        //painel.add(entrar);
        this.setLayout(new GridBagLayout());
       
        GridBagConstraints c = new GridBagConstraints();
      

                //natural height, maximum width
        c.fill = GridBagConstraints.HORIZONTAL;
    
        c.weightx = 0.4;

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;


        
        
        this.getContentPane().add(painelImagem, c);
                c.fill = GridBagConstraints.HORIZONTAL;
    
        c.weightx = 0.4;

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;

        this.getContentPane().add(painel, c);
                c.fill = GridBagConstraints.HORIZONTAL;
    
        c.weightx = 0.2;

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;

        this.getContentPane().add(entrar, c);
        
        
        
        this.setTitle("Letíris");
        this.setSize(350, 400);
        this.setLocation(50, 50);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
