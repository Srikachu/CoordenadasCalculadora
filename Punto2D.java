public class Punto2D{
  private double x,y;
  public double getX(){
      return this.x;
    }
  public double getY(){
      return this.y;
    }
  public void setX(double x){
      this.x=x;
    }
   public void setY(double y){
      this.y=y;
    }
  public Punto2D(double x, double y){
    this.x=x;
    this.y=y;
  }
  public Punto2D( ){
    this.x=0;
    this.y=0;
  }
  void Moverh(double dx){
    setX(this.x+dx);
 }
  void Moverv(double dy){
    setY(this.y+dy);
 }
  void Moverd(Punto2D v2){
    setX(this.x+v2.x);
    setY(this.y+v2.y);
 }
  double Dista(Punto2D v2){
    return (Math.sqrt(Math.pow (this.x-v2.x,2) +Math.pow(this.y-v2.y,2)));
  }
  double Dista(){
    return (Math.sqrt( Math.pow (this.x,2) +Math.pow(this.y,2)));
  }
}