public class Missile {
    private int damage = 0;

    public Missile(){}

    public void myDraw(){}

    public void shootProjectile(int power, int angle){}

    public void hitTarget(Tank x){
        x.setHp(x.getHp() - damage);
    }


}
