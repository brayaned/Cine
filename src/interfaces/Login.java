package interfaces;

import Controlador.ControladorLogin;
import Modelo.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener {

    public JPanel contentPane;
    public JLabel titulo1, titulo2, usuario, contraseña, crearu;
    public JTextField usu;
    public JPasswordField cont;
    public JButton nuevoU, ingresar;

    Usuario u=new Usuario();
    
    
    //CREACIÓN DE LA INTERFAZ
    public Login() {
        //FRAME
        this.setTitle("Cine Distrital");
        this.setSize(600, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //PANEL
        contentPane = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/fondo.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //LABELS
        titulo1 = new JLabel("Bienvenidos a DistriCine");
        titulo1.setAlignmentX(CENTER_ALIGNMENT);
        titulo1.setBounds(180, 20, 250, 30);
        titulo1.setForeground(Color.WHITE);
        titulo1.setFont(new Font("Berlin Sans FB", 0, 24));

        titulo2 = new JLabel("Por favor, ingrese su usuario y contraseña");
        titulo2.setAlignmentX(CENTER_ALIGNMENT);
        titulo2.setBounds(90, 100, 450, 30);
        titulo2.setForeground(Color.WHITE);
        titulo2.setFont(new Font("Berlin Sans FB", 0, 24));

        usuario = new JLabel("Ingresar Usuario: ");
        usuario.setBounds(20, 150, 200, 30);
        usuario.setForeground(Color.WHITE);
        usuario.setFont(new Font("Berlin Sans FB", 0, 20));

        contraseña = new JLabel("Ingresar Contraseña: ");
        contraseña.setBounds(20, 200, 200, 30);
        contraseña.setForeground(Color.WHITE);
        contraseña.setFont(new Font("Berlin Sans FB", 0, 20));

        crearu = new JLabel("Si no tiene usuario, cree uno aquí:");
        crearu.setBounds(20, 300, 400, 30);
        crearu.setForeground(Color.WHITE);
        crearu.setFont(new Font("Berlin Sans FB", 0, 20));

        //TEXTFIELD
        usu = new JTextField();
        usu.setFont(new Font("Berlin Sans FB", 0, 20));
        usu.setForeground(Color.BLACK);
        usu.setBounds(250, 150, 200, 30);

        cont = new JPasswordField();
        cont.setFont(new Font("Berlin Sans FB", 0, 20));
        cont.setForeground(Color.BLACK);
        cont.setBounds(250, 200, 200, 30);

        //BUTTON
        nuevoU = new JButton("Crear Usuario");
        nuevoU.setFont(new Font("Berlin Sans FB", 0, 22));
        nuevoU.setForeground(Color.WHITE);
        nuevoU.setBackground(Color.BLUE.darker());
        nuevoU.setBounds(200, 350, 200, 30);
        nuevoU.addActionListener(this);

        ingresar = new JButton("Ingresar");
        ingresar.setFont(new Font("Berlin Sans FB", 0, 22));
        ingresar.setForeground(Color.WHITE);
        ingresar.setBackground(Color.BLUE.darker());
        ingresar.setBounds(220, 250, 150, 30);
        ingresar.addActionListener(this);

        //AGREGAR COMPONENTES
        contentPane.add(titulo1);
        contentPane.add(titulo2);
        contentPane.add(usuario);
        contentPane.add(contraseña);
        contentPane.add(crearu);
        contentPane.add(usu);
        contentPane.add(cont);
        contentPane.add(nuevoU);
        contentPane.add(ingresar);

    }

    //USO DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nuevoU) {      //BOTÓN NUEVO USUARIO
            this.setVisible(false);
            new CreaUsuario().setVisible(true);
        } else if (e.getSource() == ingresar) {     //BOTÓN INGRESAR
            ControladorLogin cl=new ControladorLogin();
            int h = cl.verificarUsuario(u ,usu.getText(),cont.getText());
            
            if (h == 1) {
                this.setVisible(false);
                new Principal(u).setVisible(true);
                
            } else {
               JOptionPane.showMessageDialog(null, "Error");
            }

        }
    }
}
