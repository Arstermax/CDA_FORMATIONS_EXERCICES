package magasin.Class.Custumer;

public  class Custumer {
     private String firstname, lastname, genre;
    private int age;

    public Custumer(String firstname, String lastname, String genre, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.genre = genre;
        this.age = age;
    }

    /** Description:
     * @param firstname
     * @param lastname
     * @param genre
     * @param age
     * @return
     */
    public String updateProfils(String firstname, String lastname, String genre, int age){
        if (!firstname.isEmpty() && firstname.equals(this.firstname)) this.firstname = firstname;
        if (!lastname.isEmpty() && lastname.equals(this.lastname)) this.lastname = lastname;
        if (!genre.isEmpty() && genre.equals(this.genre)) this.genre = genre;
        if (!firstname.isEmpty() && firstname.equals(this.firstname)) this.firstname = firstname;
        return "Succès";
    }
}
