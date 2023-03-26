import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MiVentana extends JFrame implements ActionListener{
  
//Coordenadas
  //2D
  private JTextField x1;
  private JTextField y1;

  private JTextField x2;
  private JTextField y2;

  private JTextField x3;
  private JTextField y3;
  private JTextField z3;
//Botones
  //ARRIBA
  private JButton punto2DD;
  private JButton punto3DD;
  private JButton line;
  //ABAJO
  private JButton moverV;
  private JButton moverH;
  private JButton moverD;
  private JButton dista;
  private JButton dista0;
  private JButton enter;

  boolean primero=true;
  double x,y=0;
  Punto2D p1;
  Punto2D p2;
  Punto2D p6;
  //Punto p2= new Punto();
  Punto3D p3;
  Punto3D p4;
  Punto3D p5;
  Linea linea;
  //Paneles
  JPanel panelCoords3;
  JPanel panelCoords2;
  JPanel coords1;
  JPanel coords2;
  JPanel botonesAbajo;
  
  
  public MiVentana(){
    p1= new Punto2D();
    p2= new Punto2D();
    p6= new Punto2D();
  //Punto p2= new Punto();
    p3= new Punto3D();
    p4= new Punto3D();
    p5= new Punto3D();
    linea= new Linea();

    this.setTitle("Coordenadas, puntos y linea");
    x1= new JTextField();
    y1= new JTextField();
    
    x2= new JTextField();
    y2= new JTextField();
    
    x3= new JTextField();
    y3= new JTextField();
    z3= new JTextField();
    
    punto2DD= new JButton("Punto 2D");
    punto3DD= new JButton("Punto 3D");
    line= new JButton("Linea");

    moverV=new JButton("Mov.Vertical");
    moverH=new JButton("Mov.Horrizontal");
    moverD=new JButton("Mov.Diagonal");
    dista =new JButton("Dist puntos");
    dista0 =new JButton("Dist 0");
    enter=new JButton ("=");
  //grid filas y columnas
    
    this.getContentPane().setLayout(new BorderLayout ());
    //North
    JPanel panelBotonUp=new JPanel();
    panelBotonUp.setLayout(new FlowLayout());
    
    panelBotonUp.add(punto2DD);
    panelBotonUp.add(punto3DD);
    panelBotonUp.add(line);
    
    this.getContentPane().add(panelBotonUp,BorderLayout.NORTH);
    //center
    panelCoords3=new JPanel();
    panelCoords3.setLayout(new GridLayout(1,7));
    panelCoords2=new JPanel();
    panelCoords2.setLayout(new GridLayout(2,1));
    
    coords1=new JPanel();
    coords1.setLayout(new GridLayout(1,5));
    
    coords2=new JPanel();
    coords2.setLayout(new GridLayout(1,5));

   
    coords1.add(new JLabel("("));
    coords1.add(x1);
    coords1.add(new JLabel(","));
    coords1.add(y1);
    coords1.add(new JLabel(")"));
     
    coords2.add(new JLabel("("));
    coords2.add(x2);
    coords2.add(new JLabel(","));
    coords2.add(y2);
    coords2.add(new JLabel(")"));
    
  
    panelCoords2.add(coords1);
    panelCoords2.add(coords2);

   
    
    panelCoords3.add(new JLabel("("));
    panelCoords3.add(x3);
    panelCoords3.add(new JLabel(","));
    panelCoords3.add(y3);
    panelCoords3.add(new JLabel(","));
    panelCoords3.add(z3);
    panelCoords3.add(new JLabel(")"));

    
    botonesAbajo=new JPanel();
    botonesAbajo.setLayout(new GridLayout(2,3));
    botonesAbajo.add(moverV);
    botonesAbajo.add(moverH);
    botonesAbajo.add(moverD);
    botonesAbajo.add(dista);
    botonesAbajo.add(dista0);
    botonesAbajo.add(enter);
      
    this.getContentPane().add( botonesAbajo, BorderLayout.SOUTH);
    
    this.setSize(400, 400);
    
    this.setVisible(true);
    botonesAbajo.setVisible(false);
    
    line.addActionListener(this);
    punto2DD.addActionListener(this);
    punto3DD.addActionListener(this);
    moverV.addActionListener(this);
    moverH.addActionListener(this);
    moverD.addActionListener(this);
    dista.addActionListener(this);
    dista0.addActionListener(this);
    enter.addActionListener(this);

    line.setActionCommand("linea");
    punto2DD.setActionCommand("punto2DD");
    punto3DD.setActionCommand("punto3DD");
    moverV.setActionCommand("moverV");
    moverH.setActionCommand("moverH");
    moverD.setActionCommand("moverD");
    dista.setActionCommand("dista");
    dista0.setActionCommand("dista0");
    enter.setActionCommand("enter");

  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
    public void actionPerformed (ActionEvent e){
      //BOTONES ARRIBA
      if(e.getActionCommand().equals("linea")){
        this.getContentPane().add(panelCoords2 ,BorderLayout.CENTER);
        panelCoords2.setVisible(true);
        coords1.setVisible(true);
        coords2.setVisible(true);
        panelCoords3.setVisible(false);
        botonesAbajo.setVisible(true);

        line.setEnabled(false);
        punto2DD.setEnabled(true);
        punto3DD.setEnabled(true);
        
        dista0.setVisible(false);
      }
      if(e.getActionCommand().equals("punto2DD")){
        this.getContentPane().add(panelCoords2 ,BorderLayout.CENTER);
        panelCoords2.setVisible(true);
        coords1.setVisible(true);
        coords2.setVisible(false);
        panelCoords3.setVisible(false);
        botonesAbajo.setVisible(true);

        line.setEnabled(true);
        punto2DD.setEnabled(false);
        punto3DD.setEnabled(true);
        dista0.setVisible(true);
      }
      if(e.getActionCommand().equals("punto3DD")){
        this.getContentPane().add(panelCoords3 ,BorderLayout.CENTER);
        panelCoords3.setVisible(true);
        panelCoords2.setVisible(false);
        botonesAbajo.setVisible(true);
        
        line.setEnabled(true);
        punto2DD.setEnabled(true);
        punto3DD.setEnabled(false);
        dista0.setVisible(true);
      }
        //BOTONES ABAJO
      if(e.getActionCommand().equals("moverV")){
        moverV.setEnabled(false);
        if(primero){
          if(!line.isEnabled()){
            p1.setX(Double.parseDouble(x1.getText()));
            p1.setY(Double.parseDouble(y1.getText()));
            
            p2.setX(Double.parseDouble(x2.getText()));
            p2.setY(Double.parseDouble(y2.getText()));
            linea.setP1(p1);
            linea.setP2(p2);
            
            x1.setText("");
            x2.setText("");
            y1.setText("");
            y2.setText("");
          }else if(!punto2DD.isEnabled()){
            p1.setX(Double.parseDouble(x1.getText()));
            p1.setY(Double.parseDouble(y1.getText()));
            x1.setText("");
            y1.setText("");
          }else{
            p3.setX(Double.parseDouble(x3.getText()));
            p3.setY(Double.parseDouble(y3.getText()));
            p3.setZ(Double.parseDouble(z3.getText()));
            x3.setText("");
            y3.setText("");
            z3.setText("");
          }
          primero=false;
        }
        x1.setEnabled(false);
        x2.setEnabled(false);
        y2.setEnabled(false);
        x3.setEnabled(false);
        z3.setEnabled(false);
          
        y1.setEnabled(true);
        y3.setEnabled(true);
      }
      
      if(e.getActionCommand().equals("moverH")){
        moverH.setEnabled(false);
        if(primero){
          if(!line.isEnabled()){
            
            p1.setY(Double.parseDouble(y1.getText()));
            p2.setX(Double.parseDouble(x2.getText()));
            p2.setY(Double.parseDouble(y2.getText()));
            linea.setP1(p1);
            linea.setP2(p2);
            x1.setText("");
            x2.setText("");
            y1.setText("");
            y2.setText("");
          }else if(!punto2DD.isEnabled()){
            p1.setX(Double.parseDouble(x1.getText()));
            p1.setY(Double.parseDouble(y1.getText()));
            x1.setText("");
            y1.setText("");
          }else{
            p3.setX(Double.parseDouble(x3.getText()));
            p3.setY(Double.parseDouble(y3.getText()));
            p3.setZ(Double.parseDouble(z3.getText()));
            x3.setText("");
            y3.setText("");
            z3.setText("");
          }
          primero=false;
        }
        y1.setEnabled(false);
        x2.setEnabled(false);
        y2.setEnabled(false);
        y3.setEnabled(false);
        z3.setEnabled(false);
        
        x1.setEnabled(true);
        x3.setEnabled(true);
      }
      if(e.getActionCommand().equals("moverD")){
        moverD.setEnabled(false);
        if(primero){
          if(!line.isEnabled()){
            p1.setX(Double.parseDouble(x1.getText()));
            p1.setY(Double.parseDouble(y1.getText()));
            p2.setX(Double.parseDouble(x2.getText()));
            p2.setY(Double.parseDouble(y2.getText()));
            linea.setP1(p1);
            linea.setP2(p2);
            x1.setText("");
            x2.setText("");
            y1.setText("");
            y2.setText("");
          }else if(!punto2DD.isEnabled()){
            p1.setX(Double.parseDouble(x1.getText()));
            p1.setY(Double.parseDouble(y1.getText()));
            x1.setText("");
            y1.setText("");
          }else{
            p3.setX(Double.parseDouble(x3.getText()));
            p3.setY(Double.parseDouble(y3.getText()));
            p3.setZ(Double.parseDouble(z3.getText()));
            x3.setText("");
            y3.setText("");
            z3.setText("");
          }
          primero=false;
      }
        x2.setEnabled(false);
        y2.setEnabled(false);
        
        x3.setEnabled(true);
        y3.setEnabled(true);
        z3.setEnabled(true);
        
        x1.setEnabled(true);
        y1.setEnabled(true);
    }
      if(e.getActionCommand().equals("dista")){
        dista.setEnabled(false);
        if(primero){
          if(!punto2DD.isEnabled()){
            p1.setX(Double.parseDouble(x1.getText()));
            p1.setY(Double.parseDouble(y1.getText()));
            x1.setText("");
            y1.setText("");
          }else if(!punto3DD.isEnabled()){
            p3.setX(Double.parseDouble(x3.getText()));
            p3.setY(Double.parseDouble(y3.getText()));
            p3.setZ(Double.parseDouble(z3.getText()));
            x3.setText("");
            y3.setText("");
            z3.setText("");
          }else{
            p1.setX(Double.parseDouble(x1.getText()));
            p1.setY(Double.parseDouble(y1.getText()));
            p2.setX(Double.parseDouble(x2.getText()));
            p2.setY(Double.parseDouble(y2.getText()));
            linea.setP1(p1);
            linea.setP2(p2);
          }
          primero=false;
        }
      }
      if(e.getActionCommand().equals("dista0")){
        dista0.setEnabled(false);
        if(primero){
          if(!punto2DD.isEnabled()){
            p1.setX(Double.parseDouble(x1.getText()));
            p1.setY(Double.parseDouble(y1.getText()));
          }else{
            p3.setX(Double.parseDouble(x3.getText()));
            p3.setY(Double.parseDouble(y3.getText()));
            p3.setZ(Double.parseDouble(z3.getText()));
          }
          primero=false;
        }
      }
      if(e.getActionCommand().equals("enter")){
        primero=true;
        if(!line.isEnabled()){
          if(!moverV.isEnabled()){
            y=Double.parseDouble(y1.getText());
            linea.Moverv(y);
            x1.setText(Double.toString(linea.p1.getX()));
            x2.setText(Double.toString(linea.p2.getX()));
            y1.setText(Double.toString(linea.p1.getY()));
            y2.setText(Double.toString(linea.p2.getY()));
          }else if(!moverH.isEnabled()){
            x=Double.parseDouble(x1.getText());
            linea.Moverh(x);
            x1.setText(Double.toString(linea.p1.getX()));
            x2.setText(Double.toString(linea.p2.getX()));
            y1.setText(Double.toString(linea.p1.getY()));
            y2.setText(Double.toString(linea.p2.getY()));
          }else if(!moverD.isEnabled()){
            p6.setX(Double.parseDouble(x1.getText()));
            p6.setY(Double.parseDouble(y1.getText()));
            linea.Moverd(p6);
            x1.setText(Double.toString(linea.p1.getX()));
            x2.setText(Double.toString(linea.p2.getX()));
            y1.setText(Double.toString(linea.p1.getY()));
            y2.setText(Double.toString(linea.p2.getY()));
          }else if(!dista.isEnabled()){
            x=linea.largo();
            x1.setText(Double.toString(x));
          }
        }else if(!punto2DD.isEnabled()){
          if(!moverV.isEnabled()){
            y=Double.parseDouble(y1.getText());
            p1.Moverv(y);
            x1.setText(Double.toString(p1.getX()));
            y1.setText(Double.toString(p1.getY()));
          }else if(!moverH.isEnabled()){
            x=Double.parseDouble(x1.getText());
            p1.Moverh(x);
            x1.setText(Double.toString(p1.getX()));
            y1.setText(Double.toString(p1.getY()));
          }else if(!moverD.isEnabled()){
            p6.setX(Double.parseDouble(x1.getText()));
            p6.setY(Double.parseDouble(y1.getText()));
            p1.Moverd(p6);
            x1.setText(Double.toString(p1.getX()));
            y1.setText(Double.toString(p1.getY()));
          }else if(!dista.isEnabled()){
            x=p1.Dista();
            x1.setText(Double.toString(x));
            y1.setText(Double.toString(0));
          }else{
            p6.setX(Double.parseDouble(x1.getText()));
            p6.setY(Double.parseDouble(y1.getText()));
            x=p1.Dista(p6);
            x1.setText(Double.toString(x));
            y1.setText(Double.toString(0));
          }
        }else{
          if(!moverV.isEnabled()){
            y=Double.parseDouble(y3.getText());
            p3.Moverv(y);
            x3.setText(Double.toString(p3.getX()));
            y3.setText(Double.toString(p3.getY()));
            z3.setText(Double.toString(p3.getZ()));
          }else if(!moverH.isEnabled()){
            x=Double.parseDouble(x3.getText());
            p3.Moverh(x);
            x3.setText(Double.toString(p3.getX()));
            y3.setText(Double.toString(p3.getY()));
            z3.setText(Double.toString(p3.getZ()));
          }else if(!moverD.isEnabled()){
            p5.setX(Double.parseDouble(x1.getText()));
            p5.setY(Double.parseDouble(y1.getText()));
            p3.Moverd(p5);
            x3.setText(Double.toString(p3.getX()));
            y3.setText(Double.toString(p3.getY()));
            z3.setText(Double.toString(p3.getZ()));
          }else if(!dista0.isEnabled()){
            x=p3.Dista();
            x1.setText(Double.toString(x));
          }else if(!dista.isEnabled()){
            p5.setX(Double.parseDouble(x1.getText()));
            p5.setY(Double.parseDouble(y1.getText()));
            x=p3.Dista(p5);
            x1.setText(Double.toString(x));
          }
        }
      }
    }
}

//https://stackoverflow.com/questions/30369197/switch-between-multiple-jframes
//try catch nomber ormat exception nfe
//  joptionpane. show message dialog 