package interfaces;

import Modelo.Boleta;
import Modelo.Pelicula;
import Modelo.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Compra extends JFrame implements ActionListener {
    
    public JPanel contentPane1, contentPane2;
    public JLabel titulo, nC, pel, numA, sa, hor, pre, numeroAsientos;
    public JLabel nombreComprador, pelicula, sala, hora, precio;
    public JButton comprarAsientos;
    Usuario u;
    public Compra(Usuario usuario,Pelicula peli,Boleta boleta){
        u=usuario;
        //FRAME
        this.setTitle("Factura");
        this.setSize(400,700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //PANELES
        contentPane1 = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/fondo.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane1.setBorder(new EmptyBorder(5,5,5,5));
        contentPane1.setLayout(null);
        
        contentPane2 = new JPanel();
        contentPane2.setBounds(50,50,300,550);
        contentPane2.setBorder(new EmptyBorder(5,5,5,5));
        contentPane2.setLayout(null);
        contentPane2.setBackground(Color.BLUE.darker());
        
        //LABELS
        titulo = new JLabel("FACTURA");
        titulo.setBounds(150,20,150,30);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Berlin Sans FB",0,25));
        
        nC = new JLabel("Nombre del comprador:");
        nC.setBounds(60,60,300,30);
        nC.setForeground(Color.WHITE);
        nC.setFont(new Font("Berlin Sans FB",0,22));
        
        pel = new JLabel("Película:");
        pel.setBounds(60,150,300,30);
        pel.setForeground(Color.WHITE);
        pel.setFont(new Font("Berlin Sans FB",0,22));
        
        numA = new JLabel("Número de Asientos:");
        numA.setBounds(60,240,300,30);
        numA.setForeground(Color.WHITE);
        numA.setFont(new Font("Berlin Sans FB",0,22));
        
        numeroAsientos = new JLabel();
        numeroAsientos.setBounds(90,280,300,30);
        numeroAsientos.setForeground(Color.WHITE);
        numeroAsientos.setFont(new Font("Berlin Sans FB",0,20));
        numeroAsientos.setText(Integer.toString(boleta.getnAsientos()));
        
        sa = new JLabel("Sala:");
        sa.setBounds(60,330,300,30);
        sa.setForeground(Color.WHITE);
        sa.setFont(new Font("Berlin Sans FB",0,22));
        
        hor = new JLabel("Hora:");
        hor.setBounds(60,420,300,30);
        hor.setForeground(Color.WHITE);
        hor.setFont(new Font("Berlin Sans FB",0,22));
        
        sala = new JLabel();
        sala.setBounds(90,370,300,30);
        sala.setForeground(Color.WHITE);
        sala.setFont(new Font("Berlin Sans FB",0,20));
        sala.setText(boleta.getSala());
        
        hora = new JLabel();
        hora.setBounds(90,460,300,30);
        hora.setForeground(Color.WHITE);
        hora.setFont(new Font("Berlin Sans FB",0,20));
        hora.setText(boleta.getHora());
        
        pre = new JLabel("Precio Total:");
        pre.setBounds(60,510,300,30);
        pre.setForeground(Color.WHITE);
        pre.setFont(new Font("Berlin Sans FB",0,22));
        
        //LABELS PARA LLENAR
        nombreComprador = new JLabel();     //PONER NOMBRE DEL USUARIO
        nombreComprador.setBounds(90,100,300,30);
        nombreComprador.setForeground(Color.WHITE);
        nombreComprador.setFont(new Font("Berlin Sans FB",0,20));
        nombreComprador.setText(usuario.getPrimerNombre()+usuario.getSegundoNombre()+usuario.getApellidos());
        
        pelicula = new JLabel();        //PONER NOMBRE DE LA PELÍCULA
        pelicula.setBounds(90,190,300,30);
        pelicula.setForeground(Color.WHITE);
        pelicula.setFont(new Font("Berlin Sans FB",0,20));
        pelicula.setText(peli.getTitulo());
        
        
        precio = new JLabel();      //PONER EL PRECIO TOTAL
        precio.setBounds(90,550,300,30);
        precio.setForeground(Color.WHITE);
        precio.setFont(new Font("Berlin Sans FB",0,20));
        precio.setText(Integer.toString(boleta.getnAsientos()*10000));
        
        //BOTON
        comprarAsientos = new JButton("Finalizar Compra");
        comprarAsientos.setFont(new Font("Berlin Sans FB", 0, 22));
        comprarAsientos.setForeground(Color.WHITE);
        comprarAsientos.setBackground(Color.BLUE.darker());
        comprarAsientos.setBounds(100,620,200,30);
        comprarAsientos.addActionListener(this);
        
        //AGREGAR COMPONENTES
        getContentPane().add(titulo);
        getContentPane().add(nC);
        getContentPane().add(pel);
        getContentPane().add(numA);
        getContentPane().add(sa);
        getContentPane().add(hor);
        getContentPane().add(pre);
        getContentPane().add(nombreComprador);
        getContentPane().add(pelicula);
        getContentPane().add(numeroAsientos);
        getContentPane().add(sala);
        getContentPane().add(hora);
        getContentPane().add(precio);
        getContentPane().add(comprarAsientos);
        getContentPane().add(contentPane2);
        getContentPane().add(contentPane1);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comprarAsientos){
            
            
            JOptionPane.showMessageDialog(null, "Compra finalizada");
            this.setVisible(false);
            new Principal(u).setVisible(true);
        }
    }
}