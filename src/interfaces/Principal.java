package interfaces;

import Controlador.ControladorPrincipal;
import Modelo.Pelicula;
import Modelo.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame implements ActionListener {

    DescripcionPeli dP;
    Pelicula p;
    Usuario usuario;
    ControladorPrincipal cp = new ControladorPrincipal();

    public JPanel titulo, peliculas;
    public JLabel bienve, titulo2;
    public JLabel im1, im2, im3, im4, im5, distri;      //IMAGENES
    public JRadioButton peli1, peli2, peli3, peli4, peli5;
    public JButton comprar, borrarU, cerrarS;
    public ButtonGroup grupoPelis = new ButtonGroup();
    public int pelicula;

    public Principal(Usuario u) {
        usuario = u;

        //FRAME
        this.setTitle("Home");
        this.setSize(1000, 1000);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //PANELES
        peliculas = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/fondo.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        peliculas.setBorder(new EmptyBorder(5, 5, 5, 5));
        peliculas.setLayout(null);

        titulo = new JPanel();
        titulo.setBounds(0, 0, 1000, 150);
        titulo.setBorder(new EmptyBorder(5, 5, 5, 5));
        titulo.setLayout(null);
        titulo.setBackground(Color.blue.brighter());

        //LABELS
        bienve = new JLabel("Bienvenido," + usuario.getPrimerNombre() + " " + usuario.getApellidos(), SwingConstants.CENTER);
        bienve.setVerticalAlignment(SwingConstants.CENTER);
        bienve.setBounds(200, 40, 600, 50);
        bienve.setForeground(Color.WHITE);
        bienve.setFont(new Font("Berlin Sans FB", 0, 40));

        titulo2 = new JLabel("Por favor, escoja qué película quiere ver:");
        titulo2.setBounds(40, 150, 600, 40);
        titulo2.setForeground(Color.WHITE);
        titulo2.setFont(new Font("Berlin Sans FB", 0, 30));

        //IMAGENES
        distri = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/escudo.png")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        distri.setBorder(new EmptyBorder(1, 1, 1, 1));
        distri.setLayout(null);
        distri.setBounds(10, 0, 145, 145);

        im1 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/avengers.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        im1.setBorder(new EmptyBorder(1, 1, 1, 1));
        im1.setLayout(null);
        im1.setBounds(100, 200, 200, 300);

        im2 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/chucky.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        im2.setBorder(new EmptyBorder(1, 1, 1, 1));
        im2.setLayout(null);
        im2.setBounds(400, 200, 200, 300);

        im3 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/reyleon.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        im3.setBorder(new EmptyBorder(1, 1, 1, 1));
        im3.setLayout(null);
        im3.setBounds(700, 200, 200, 300);

        im4 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/spiderman.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        im4.setBorder(new EmptyBorder(1, 1, 1, 1));
        im4.setLayout(null);
        im4.setBounds(150, 600, 200, 300);

        im5 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/toystory.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        im5.setBorder(new EmptyBorder(1, 1, 1, 1));
        im5.setLayout(null);
        im5.setBounds(650, 600, 200, 300);

        //RADIO BUTTON
        peli1 = new JRadioButton("Avengers: Endgame");
        peli1.setFont(new Font("Berlin Sans FB", 0, 20));
        peli1.setForeground(Color.WHITE);
        peli1.setOpaque(false);
        peli1.setBounds(100, 520, 200, 30);

        peli2 = new JRadioButton("Child's Play");
        peli2.setFont(new Font("Berlin Sans FB", 0, 20));
        peli2.setForeground(Color.WHITE);
        peli2.setOpaque(false);
        peli2.setBounds(400, 520, 200, 30);

        peli3 = new JRadioButton("The Lion King");
        peli3.setFont(new Font("Berlin Sans FB", 0, 20));
        peli3.setForeground(Color.WHITE);
        peli3.setOpaque(false);
        peli3.setBounds(700, 520, 200, 30);

        peli4 = new JRadioButton("Spiderman: Far For Home");
        peli4.setFont(new Font("Berlin Sans FB", 0, 20));
        peli4.setForeground(Color.WHITE);
        peli4.setOpaque(false);
        peli4.setBounds(150, 920, 250, 30);

        peli5 = new JRadioButton("Toy Story 4");
        peli5.setFont(new Font("Berlin Sans FB", 0, 20));
        peli5.setForeground(Color.WHITE);
        peli5.setOpaque(false);
        peli5.setBounds(650, 920, 200, 30);

        grupoPelis.add(peli1);
        grupoPelis.add(peli2);
        grupoPelis.add(peli3);
        grupoPelis.add(peli4);
        grupoPelis.add(peli5);

        //BOTONES
        comprar = new JButton("Comprar entradas");
        comprar.setFont(new Font("Berlin Sans FB", 0, 20));
        comprar.setForeground(Color.WHITE);
        comprar.setBackground(Color.BLUE.darker());
        comprar.setBounds(400, 750, 200, 30);
        comprar.addActionListener(this);

        borrarU = new JButton("Borrar Usuario");
        borrarU.setFont(new Font("Berlin Sans FB", 0, 20));
        borrarU.setForeground(Color.WHITE);
        borrarU.setBackground(Color.BLACK);
        borrarU.setBounds(780, 30, 200, 30);
        borrarU.addActionListener(this);

        cerrarS = new JButton("Cerrar Sesion");
        cerrarS.setFont(new Font("Berlin Sans FB", 0, 20));
        cerrarS.setForeground(Color.WHITE);
        cerrarS.setBackground(Color.BLACK);
        cerrarS.setBounds(780, 90, 200, 30);
        cerrarS.addActionListener(this);

        //AGREGAR COMPONENTES
        titulo.add(distri);
        titulo.add(bienve);
        getContentPane().add(titulo2);
        getContentPane().add(im1);
        getContentPane().add(im2);
        getContentPane().add(im3);
        getContentPane().add(im4);
        getContentPane().add(im5);
        getContentPane().add(peli1);
        getContentPane().add(peli2);
        getContentPane().add(peli3);
        getContentPane().add(peli4);
        getContentPane().add(peli5);
        getContentPane().add(comprar);
        getContentPane().add(borrarU);
        getContentPane().add(cerrarS);
        getContentPane().add(titulo);
        getContentPane().add(peliculas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comprar) {     //COMPRA BOLETOS
            if (peli1.isSelected() || peli2.isSelected() || peli3.isSelected() || peli4.isSelected() || peli5.isSelected()) {

                if (peli1.isSelected()) {     //SELECCIONA AVENGERS
                    p = cp.seleccionarPelicula("Avengers");
                } else if (peli2.isSelected()) {        //SELECCIONA CHILDS PLAY
                    p = cp.seleccionarPelicula("Childs play");
                } else if (peli3.isSelected()) {        //SELECCIONA REY LEON
                    p = cp.seleccionarPelicula("The lion king");
                } else if (peli4.isSelected()) {        //SELECCIONA SPIDERMAN
                    p = cp.seleccionarPelicula("Spider-man");
                } else if (peli5.isSelected()) {        //SELECCIONA TOYSTORY
                    p = cp.seleccionarPelicula("Toy Story 4");
                }
                dP = new DescripcionPeli(usuario, p);
                this.setVisible(false);
                this.dP.setVisible(true);
                devolverNum();
            } else {
                JOptionPane.showMessageDialog(null, "Escoja una película");
            }
        } else if (e.getSource() == borrarU) {      //BORRA EL USUARIO

            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro quieres borrarlo?");
            if (JOptionPane.OK_OPTION == resp) {

                int h = cp.borrarSusuario(usuario);
                if (h == 1) {
                    JOptionPane.showMessageDialog(null, "Usuario borrado correctamente");
                    this.setVisible(false);
                    new Login().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        } else if (e.getSource() == cerrarS) {      //CIERRA LA SESIÓN Y VUELVE AL LOGIN

            this.setVisible(false);
            new Login().setVisible(true);

        }
    }

    public void devolverNum() {
        if (peli1.isSelected()) {
            this.dP.pel = 1;
        } else if (peli2.isSelected()) {
            this.dP.pel = 2;
        } else if (peli3.isSelected()) {
            this.dP.pel = 3;
        } else if (peli4.isSelected()) {
            this.dP.pel = 4;
        } else if (peli5.isSelected()) {
            this.dP.pel = 5;
        }
    }
}
