public class Punto3D extends Punto2D{
  private double z;
  public double getZ(){
      return this.z;
    }
  public void setZ(double z){
      this.z=z;
    }
  public Punto3D( ){
    super();
    this.z=0;
  }
  public Punto3D(double x, double y,double z){
    super();
    this.z=z;
  }
  void Moverh(double dx){
    super.Moverh(dx);
 }
  void Moverv(double dy){
    super.Moverv(dy);
 }
  void Moverp(double dz){
    setZ(getZ()+dz);
 }
  void Moverd(Punto3D v4){
    super.Moverd(v4);
    setZ(this.z+v4.getZ());
 }
  double Dista(Punto3D v4){
    return (Math.sqrt(Math.pow (this.getX()-v4.getX(),2) +Math.pow(this.getY()-v4.getY(),2)+Math.pow(this.getZ()-v4.getZ(),2)));
  }
   double Dista(){
    return (Math.sqrt(Math.pow (this.getX(),2) +Math.pow(this.getY(),2)+Math.pow(this.getZ(),2)));
  }
}