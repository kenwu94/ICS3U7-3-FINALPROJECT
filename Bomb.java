public class Bomb {
    private int damage = 0;

    public Bomb(){}

    public void myDraw(){}

    public void shootProjectile(int power, int angle){}

    public void hitTarget(Tank x){
        x.setHp(x.getHp() - damage);
    }

}
