package Games.Class;

public class Personnage {

    private String name;
    private int life;
    private int attaque, defense, mana ;

    public Personnage(String name ,int life, int attaque, int defense, int mana) {
        this.name = name;
        this.life = life;
        this.attaque = attaque;
        this.defense = defense;
        this.mana = mana;
    }

    public int getLife() {
        return life;
    }

    protected void AddLife(int getlife){
        this.life += getlife;
    }

    protected void removeLife(int removeLife){
        this.life -= removeLife;
    }

    public String getAttck(Personnage personnage){
        int removeLife = this.attaque - personnage.getDefense();
        if(removeLife > 0){
         personnage.removeLife(removeLife);
        }else{
            removeLife(0);
        }
        return personnage.getName() + " à perdu " + removeLife + " HP" ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
