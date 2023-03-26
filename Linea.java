public class Linea{
  Punto2D p1;
  Punto2D p2;
  public void setP1(Punto2D p1){
      this.p1=p1;
    }
   public void setP2(Punto2D p2){
      this.p2=p2;
    }
  public Punto2D getP1(){
      return p1;
    }
  public Punto2D getP2(){
    return p2;
    }
  public Linea(){
    p1= new Punto2D();
    p2= new Punto2D();
  }
  public Linea(Punto2D p1, Punto2D p2){
    this.p1= p1;
    this.p2= p2;
  }
 double largo(){
    return p1.Dista(p2);
  }
  void Moverv(double dy){
    this.p1.Moverv(dy);
    this.p2.Moverv(dy);
  }
  void Moverh(double dx){
    this.p1.Moverh(dx);
    this.p2.Moverh(dx);
  }
  void Moverd(Punto2D p3){
    this.p1.Moverd(p3);
    this.p2.Moverd(p3);
  }
}