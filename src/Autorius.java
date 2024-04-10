import java.util.Date;

public class Autorius {

    private String vardas, pavarde;
    private Date gimimoMetai;

   Autorius(){
       gimimoMetai = new Date();
   }
    Autorius(String vardas, String pavarde, Date gimimoMetai){
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimoMetai = gimimoMetai;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getPavarde() {
        return pavarde;
    }

    public Date getGimimoMetai() {
        return gimimoMetai;
    }
}
