public class Laser {
    private int damage = 0;

    public Laser(){}

    public void myDraw(){}

    public void shootProjectile(int power, int angle){}

    public void hitTarget(Tank x){
        x.setHp(x.getHp() - damage);
    }

}
