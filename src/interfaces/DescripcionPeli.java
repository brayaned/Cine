package interfaces;

import Controlador.ControladorPrincipal;
import Modelo.Boleta;
import Modelo.Pelicula;
import Modelo.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DescripcionPeli extends JFrame implements ActionListener {
    
    Compra c ;
    Boleta b=new Boleta();
    ControladorPrincipal cp=new ControladorPrincipal();
    Usuario u;
    Pelicula p;
    public JPanel contentPane;
    public JLabel poster, duracion, director, genero, descripcion, escSala, escHora, numB;
    public JLabel dur, dir, gen;
    public JTextArea desc;
    public JRadioButton sala1, sala2, mañana, tarde, noche;
    public ButtonGroup grupoSalas, grupoHoras;
    public JComboBox numeroBoletas;
    public JButton compra;
    public int pel;
    String[] nB = {"1","2","3","4"};
    
    public DescripcionPeli(Usuario usuario, Pelicula pelicula){
        u=usuario;
        p=pelicula;
        
        //FRAME
        this.setTitle("Comprando Boletas");
        this.setSize(900,700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //PANEL
        contentPane = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/fondo.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        
        //LABELS
        poster = new JLabel(){
            public void paintComponent(Graphics g){
                if(pel==1){
                    g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/avengers.jpg")).getImage(), 0, 0, getWidth(), getHeight(), contentPane);
                } else if(pel==2){
                    g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/chucky.jpg")).getImage(), 0, 0, getWidth(), getHeight(), contentPane);
                } else if(pel==3){
                    g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/reyleon.jpg")).getImage(), 0, 0, getWidth(), getHeight(), contentPane);
                } else if(pel==4){
                    g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/spiderman.jpg")).getImage(), 0, 0, getWidth(), getHeight(), contentPane);
                } else if(pel==5){
                    g.drawImage(new ImageIcon(this.getClass().getResource("/imagenes/toystory.jpg")).getImage(), 0, 0, getWidth(), getHeight(), contentPane);
                }
            }
        };
        poster.setBorder(new EmptyBorder(1,1,1,1));
        poster.setLayout(null);
        poster.setBounds(20,20,300,400);
        
        duracion = new JLabel("Duración: ");
        duracion.setBounds(350, 30, 200, 30);
        duracion.setForeground(Color.WHITE);
        duracion.setFont(new Font("Berlin Sans FB",0,28));
        
        director = new JLabel("Director: ");
        director.setBounds(350, 130, 200, 30);
        director.setForeground(Color.WHITE);
        director.setFont(new Font("Berlin Sans FB",0,28));
        
        genero = new JLabel("Género: ");
        genero.setBounds(350, 230, 200, 30);
        genero.setForeground(Color.WHITE);
        genero.setFont(new Font("Berlin Sans FB",0,28));
        
        escSala = new JLabel("Escoja la sala: ");
        escSala.setBounds(650, 30, 250, 30);
        escSala.setForeground(Color.WHITE);
        escSala.setFont(new Font("Berlin Sans FB",0,25));
        
        escHora = new JLabel("Escoja la hora: ");
        escHora.setBounds(650, 150, 250, 30);
        escHora.setForeground(Color.WHITE);
        escHora.setFont(new Font("Berlin Sans FB",0,25));
        
        numB = new JLabel("Número de Boletas:");
        numB.setBounds(650, 320, 300, 30);
        numB.setForeground(Color.WHITE);
        numB.setFont(new Font("Berlin Sans FB",0,25));
        
        descripcion = new JLabel("Descripción: ");
        descripcion.setBounds(20, 450, 250, 30);
        descripcion.setForeground(Color.WHITE);
        descripcion.setFont(new Font("Berlin Sans FB",0,28));
        
        //LABELS PARA LLENAR
        
        dur = new JLabel();     //PONER DURACION DE LA PELÍCULA
        dur.setBounds(370,80,200,30);
        dur.setForeground(Color.WHITE);
        dur.setFont(new Font("Berlin Sans FB",0,25));
        dur.setText(pelicula.getDuracion());
        
        dir = new JLabel();     //PONER DIRECTOR DE LA PELÍCULA
        dir.setBounds(370,180,200,30);
        dir.setForeground(Color.WHITE);
        dir.setFont(new Font("Berlin Sans FB",0,25));
        dir.setText(pelicula.getDirector());

        gen = new JLabel();     //PONER GÉNERO DE LA PELÍCULA
        gen.setBounds(370,280,200,30);
        gen.setForeground(Color.WHITE);
        gen.setFont(new Font("Berlin Sans FB",0,25));
        gen.setText(pelicula.getGenero());
        
        //TEXT AREA
        desc = new JTextArea();     //PONER LA DESCRIPCIÓN DE LA PELÍCULA
        desc.setEditable(false);
        desc.setFont(new Font("Berlin Sans FB",0,22));
        desc.setForeground(Color.BLACK);
        desc.setBounds(30,500,400,150);
        desc.setText(pelicula.getDescripcion());
        
        
        //RADIO BUTTONS
        sala1 = new JRadioButton("Sala 1");
        sala1.setFont(new Font("Berlin Sans FB", 0, 25));
        sala1.setForeground(Color.WHITE);
        sala1.setOpaque(false);
        sala1.setBounds(660,70,200,30);
        
        sala2 = new JRadioButton("Sala 2");
        sala2.setFont(new Font("Berlin Sans FB", 0, 25));
        sala2.setForeground(Color.WHITE);
        sala2.setOpaque(false);
        sala2.setBounds(660,110,200,30);
        
        mañana = new JRadioButton("Mañana");
        mañana.setFont(new Font("Berlin Sans FB", 0, 25));
        mañana.setForeground(Color.WHITE);
        mañana.setOpaque(false);
        mañana.setBounds(660,190,200,30);
        
        tarde = new JRadioButton("Tarde");
        tarde.setFont(new Font("Berlin Sans FB", 0, 25));
        tarde.setForeground(Color.WHITE);
        tarde.setOpaque(false);
        tarde.setBounds(660,230,200,30);
        
        noche = new JRadioButton("Noche");
        noche.setFont(new Font("Berlin Sans FB", 0, 25));
        noche.setForeground(Color.WHITE);
        noche.setOpaque(false);
        noche.setBounds(660,270,200,30);
        
        grupoSalas = new ButtonGroup();
        grupoHoras = new ButtonGroup();
        grupoSalas.add(sala1);
        grupoSalas.add(sala2);
        grupoHoras.add(mañana);
        grupoHoras.add(tarde);
        grupoHoras.add(noche);
        
        //COMBO BOX
        numeroBoletas = new JComboBox(nB);
        numeroBoletas.setFont(new Font("Berlin Sans FB",0,25));
        numeroBoletas.setForeground(Color.BLACK);
        numeroBoletas.setBounds(660,360,200,30);
        
        //BOTON
        compra = new JButton("Comprar Boletos");
        compra.setFont(new Font("Berlin Sans FB", 0, 20));
        compra.setForeground(Color.WHITE);
        compra.setBackground(Color.BLUE.darker());
        compra.setBounds(550,450,300,30);
        compra.addActionListener(this);
        
        //AGREGAR COMPONENTES
        getContentPane().add(contentPane);
        contentPane.add(poster);
        contentPane.add(duracion);
        contentPane.add(director);
        contentPane.add(genero);
        contentPane.add(escSala);
        contentPane.add(escHora);
        contentPane.add(descripcion);
        contentPane.add(dur);
        contentPane.add(dir);
        contentPane.add(gen);
        contentPane.add(desc);
        contentPane.add(sala1);
        contentPane.add(sala2);
        contentPane.add(mañana);
        contentPane.add(tarde);
        contentPane.add(noche);
        contentPane.add(numB);
        contentPane.add(numeroBoletas);
        contentPane.add(compra);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compra){
            if(sala1.isSelected() || sala2.isSelected()){
                if(mañana.isSelected() || tarde.isSelected() || noche.isSelected()){
                    //COMIENZO DEL CONDICIONAL DE SALA Y HORA
                    if(sala1.isSelected() && mañana.isSelected()){      //SALA 1 Y HORARIO MAÑANA
                        b.setSala("1");
                        devolverAs();
                        b.setHora("Mañana");
                        b=cp.verificarAsientos(b);
                        if(b!=null){
                            c=new Compra(u,p,b);
                            this.setVisible(false);
                            c.setVisible(true);
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No hay asientos disponibles");
                        }
                    }

                    else if(sala1.isSelected() && tarde.isSelected()){      //SALA 1 Y HORARIO TARDE
                        b.setSala("1");
                        devolverAs();
                        b.setHora("Tarde");
                        b=cp.verificarAsientos(b);
                        if(b!=null){
                            c=new Compra(u,p,b);
                            this.setVisible(false);
                            c.setVisible(true);
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No hay asientos disponibles");
                        }
                    }

                    else if(sala1.isSelected() && noche.isSelected()){      //SALA 1 Y HORARIO NOCHE
                        b.setSala("1");
                        devolverAs();
                        b.setHora("Noche");
                        b=cp.verificarAsientos(b);
                        if(b!=null){
                            c=new Compra(u,p,b);
                            this.setVisible(false);
                            c.setVisible(true);
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No hay asientos disponibles");
                        }
                    }

                    else if(sala2.isSelected() && mañana.isSelected()){     //SALA 2 Y HORARIO MAÑANA
                        b.setSala("2");
                        devolverAs();
                        b.setHora("Mañana");
                        b=cp.verificarAsientos(b);
                        if(b!=null){
                            c=new Compra(u,p,b);
                            this.setVisible(false);
                            c.setVisible(true);
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No hay asientos disponibles");
                        }
                    }

                    else if(sala2.isSelected() && tarde.isSelected()){      //SALA 2 Y HORARIO TARDE
                        b.setSala("2");
                        devolverAs();
                        b.setHora("Tarde");
                        b=cp.verificarAsientos(b);
                        if(b!=null){
                            c=new Compra(u,p,b);
                            this.setVisible(false);
                            c.setVisible(true);
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No hay asientos disponibles");
                        }
                    }

                    else if(sala2.isSelected() && noche.isSelected()){      //SALA 2 Y HORARIO NOCHE
                        b.setSala("2");
                        devolverAs();
                        b.setHora("Noche");
                        b=cp.verificarAsientos(b);
                        if(b!=null){
                            c=new Compra(u,p,b);
                            this.setVisible(false);
                            c.setVisible(true);
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No hay asientos disponibles");
                        }
                    }

                    //FIN DEL CONDICIONAL DE SALA Y HORA


                } else {
                    JOptionPane.showMessageDialog(null, "Escoja horario");
                }    
            } else {
                JOptionPane.showMessageDialog(null, "Escoja sala");
            }  
        }
    }
    
    public void devolverAs(){       //NUMERO DE BOLETAS
        if(numeroBoletas.getSelectedItem()=="1"){       //SELECCIONA UNA BOLETA
            b.setnAsientos(1);
        } else if(numeroBoletas.getSelectedItem()=="2"){      //SELECCIONA DOS BOLETAS
            b.setnAsientos(2);
        } else if(numeroBoletas.getSelectedItem()=="3"){      //SELECCIONA TRES BOLETAS
            b.setnAsientos(3);
        } else if(numeroBoletas.getSelectedItem()=="4"){      //SELECCIONA CUATRO BOLETAS
            b.setnAsientos(4);
        }
    }
}