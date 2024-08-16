package Dessin;

public class Dessin {
    /**
     *
     * @param niveau {int} niveau
     * @return un dessin de thermomètre
     */
    public String dessinThermometer(double niveau, int min, int max){
        String message = "  _____\n";

        for (int i = 1; i < 10; i++) {
            if (i < niveau ){
               message += i+" |///|\n";
            }else if(i == niveau){
                message += i+ "|---|\n";
            }else{
                message += i+ "|   |\n";
            }
        }
        return message;
    }
}
