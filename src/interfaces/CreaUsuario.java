package interfaces;

import Controlador.ControladorLogin;
import Controlador.Fecha;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CreaUsuario extends JFrame implements ActionListener {

    public JPanel contentPane;
    public JLabel mail, contraseña, primerN, segundoN, apellido, cumpleaños, genero, documento, celular, titulo1, titulo2;
    public JTextField ma, pN, sN, ap, cum, doc, cel;
    public JPasswordField cont;
    public JComboBox gen;
    public JButton crearU;
    public String[] generos = {"Masculino", "Femenino", "No se sabe"};

    //CREACIÓN DE INTERFAZ
    public CreaUsuario() {
        //FRAME
        this.setTitle("Creación de Usuario");
        this.setSize(600, 700);
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
        titulo1 = new JLabel("Creación de Usuario");
        titulo1.setAlignmentX(CENTER_ALIGNMENT);
        titulo1.setBounds(180, 20, 250, 30);
        titulo1.setForeground(Color.WHITE);
        titulo1.setFont(new Font("Berlin Sans FB", 0, 24));

        titulo2 = new JLabel("Por favor, ingrese los datos:");
        titulo2.setBounds(20, 100, 400, 30);
        titulo2.setForeground(Color.WHITE);
        titulo2.setFont(new Font("Berlin Sans FB", 0, 24));

        mail = new JLabel("Mail:");
        mail.setBounds(20, 150, 350, 30);
        mail.setForeground(Color.WHITE);
        mail.setFont(new Font("Berlin Sans FB", 0, 22));

        contraseña = new JLabel("Contraseña:");
        contraseña.setBounds(20, 200, 350, 30);
        contraseña.setForeground(Color.WHITE);
        contraseña.setFont(new Font("Berlin Sans FB", 0, 22));

        primerN = new JLabel("Primer Nombre:");
        primerN.setBounds(20, 250, 350, 30);
        primerN.setForeground(Color.WHITE);
        primerN.setFont(new Font("Berlin Sans FB", 0, 22));

        segundoN = new JLabel("Segundo Nombre:");
        segundoN.setBounds(20, 300, 350, 30);
        segundoN.setForeground(Color.WHITE);
        segundoN.setFont(new Font("Berlin Sans FB", 0, 22));

        apellido = new JLabel("Apellido:");
        apellido.setBounds(20, 350, 350, 30);
        apellido.setForeground(Color.WHITE);
        apellido.setFont(new Font("Berlin Sans FB", 0, 22));

        cumpleaños = new JLabel("Fecha de Nacimiento:");
        cumpleaños.setBounds(20, 400, 350, 30);
        cumpleaños.setForeground(Color.WHITE);
        cumpleaños.setFont(new Font("Berlin Sans FB", 0, 22));

        genero = new JLabel("Genero:");
        genero.setBounds(20, 450, 350, 30);
        genero.setForeground(Color.WHITE);
        genero.setFont(new Font("Berlin Sans FB", 0, 22));

        documento = new JLabel("Documento:");
        documento.setBounds(20, 500, 350, 30);
        documento.setForeground(Color.WHITE);
        documento.setFont(new Font("Berlin Sans FB", 0, 22));

        celular = new JLabel("Celular:");
        celular.setBounds(20, 550, 350, 30);
        celular.setForeground(Color.WHITE);
        celular.setFont(new Font("Berlin Sans FB", 0, 22));

        //TEXT FIELDS
        ma = new JTextField();
        ma.setFont(new Font("Berlin Sans FB", 0, 20));
        ma.setForeground(Color.BLACK);
        ma.setBounds(300, 150, 200, 30);

        cont = new JPasswordField();
        cont.setFont(new Font("Berlin Sans FB", 0, 20));
        cont.setForeground(Color.BLACK);
        cont.setBounds(300, 200, 200, 30);

        pN = new JTextField();
        pN.setFont(new Font("Berlin Sans FB", 0, 20));
        pN.setForeground(Color.BLACK);
        pN.setBounds(300, 250, 200, 30);

        sN = new JTextField();
        sN.setFont(new Font("Berlin Sans FB", 0, 20));
        sN.setForeground(Color.BLACK);
        sN.setBounds(300, 300, 200, 30);

        ap = new JTextField();
        ap.setFont(new Font("Berlin Sans FB", 0, 20));
        ap.setForeground(Color.BLACK);
        ap.setBounds(300, 350, 200, 30);

        cum = new JTextField();
        cum.setFont(new Font("Berlin Sans FB", 0, 20));
        cum.setForeground(Color.BLACK);
        cum.setBounds(300, 400, 200, 30);

        doc = new JTextField();
        doc.setFont(new Font("Berlin Sans FB", 0, 20));
        doc.setForeground(Color.BLACK);
        doc.setBounds(300, 500, 200, 30);

        cel = new JTextField();
        cel.setFont(new Font("Berlin Sans FB", 0, 20));
        cel.setForeground(Color.BLACK);
        cel.setBounds(300, 550, 200, 30);

        //COMBO BOX
        gen = new JComboBox(generos);
        gen.setFont(new Font("Berlin Sans FB", 0, 20));
        gen.setForeground(Color.BLACK);
        gen.setBounds(300, 450, 200, 30);

        //BOTON
        crearU = new JButton("Crear Usuario");
        crearU.setFont(new Font("Berlin Sans FB", 0, 22));
        crearU.setForeground(Color.WHITE);
        crearU.setBackground(Color.BLUE.darker());
        crearU.setBounds(200, 600, 200, 30);
        crearU.addActionListener(this);

        //AGREGAR COMPONENTES
        contentPane.add(titulo1);
        contentPane.add(titulo2);
        contentPane.add(mail);
        contentPane.add(contraseña);
        contentPane.add(primerN);
        contentPane.add(segundoN);
        contentPane.add(apellido);
        contentPane.add(cumpleaños);
        contentPane.add(genero);
        contentPane.add(documento);
        contentPane.add(celular);
        contentPane.add(ma);
        contentPane.add(cont);
        contentPane.add(pN);
        contentPane.add(sN);
        contentPane.add(ap);
        contentPane.add(cum);
        contentPane.add(gen);
        contentPane.add(doc);
        contentPane.add(cel);
        contentPane.add(crearU);
    }

    //USO DE BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearU) {      //BOTÓN DE CREAR USUARIO
            if ((String) gen.getSelectedItem() == "Masculino") {
                ControladorLogin cl = new ControladorLogin();
                Fecha f = new Fecha();

                int h = cl.registrarUsuario(ma.getText(), cont.getText(), doc.getText(), pN.getText(), sN.getText(), cel.getText(), ap.getText(), f.cambiar(cum.getText()), "Masculino");

                if (h == 0) {
                    JOptionPane.showMessageDialog(null, "Error");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario registrado");
                }

            } else if ((String) gen.getSelectedItem() == "Femenino") {
                ControladorLogin cl = new ControladorLogin();
                Fecha f = new Fecha();

                int h = cl.registrarUsuario(ma.getText(), cont.getText(), doc.getText(), pN.getText(), sN.getText(), cel.getText(), ap.getText(), f.cambiar(cum.getText()), "Femenino");

                if (h == 0) {
                    JOptionPane.showMessageDialog(null, "Error");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario registrado");
                }
            } else if ((String) gen.getSelectedItem() == "No se sabe") {

                ControladorLogin cl = new ControladorLogin();
                Fecha f = new Fecha();

                int h = cl.registrarUsuario(ma.getText(), cont.getText(), doc.getText(), pN.getText(), sN.getText(), cel.getText(), ap.getText(), f.cambiar(cum.getText()), "No se sabe");

                if (h == 0) {
                    JOptionPane.showMessageDialog(null, "Error");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario registrado");
                }
            }

            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
}
