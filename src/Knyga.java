import java.util.Date;

public class Knyga {
    private String pavadinimas;
    private Date isleidimoMetai;
    private Autorius autorius;
    private Integer SKAITYTOJOID;
    Knyga(){
        Date isleidimoMetai = new Date();
        autorius = new Autorius();
    }
    Knyga(String pavadinimas, Autorius autorius, Date isleidimoMetai) {
        this.pavadinimas = pavadinimas;
        this.autorius = autorius;
        this.isleidimoMetai = isleidimoMetai;
    }

    public Date getIsleidimoMetai() {
        return isleidimoMetai;
    }

    public Autorius getAutorius() {
        return autorius;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public Integer getSKAITYTOJOID() {
        return SKAITYTOJOID;
    }

    public void setSKAITYTOJOID(Integer SKAITYTOJOID) {
        this.SKAITYTOJOID = SKAITYTOJOID;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public void setIsleidimoMetai(Date isleidimoMetai) {
        this.isleidimoMetai = isleidimoMetai;
    }

    public void setAutorius(Autorius autorius) {
        this.autorius = autorius;

    }

    @Override
    public String toString() {
        return "Knygos informacija: \n" +
                "Autorius: " + autorius.getVardas() + " " + autorius.getPavarde() + "\n" +
                "Knygos pavadinimas: " + pavadinimas + "\n" +
                "Skaitytojo ID: " +  SKAITYTOJOID + "\n";

    }
}
