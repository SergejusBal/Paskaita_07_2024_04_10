import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Biblioteka {
    Scanner scanner  = new Scanner(System.in);
    private ArrayList<Knyga> knyguSarasas = new ArrayList<Knyga>();

    public Biblioteka() {

    }
    public Biblioteka(ArrayList<Knyga> knyguSarasas) {
        this.knyguSarasas = knyguSarasas;
    }

    public ArrayList<Knyga> getKnyguSarasas() {
        return knyguSarasas;
    }


    public void addKnyga() throws KnyguException{
        Knyga knyga = new Knyga();


        try{
           System.out.println("Irasykite knygos pavadinima");
           knyga.setPavadinimas(scanner.nextLine());
           System.out.println("Irasykite knygos autoriaus varda");
           knyga.getAutorius().setVardas(scanner.nextLine());
           System.out.println("Irasykite knygos autoriaus pavarde");
           knyga.getAutorius().setPavarde(scanner.nextLine());
           System.out.println("Irasykite knygos leidimo metus");
           int metai = scanner.nextInt();
           if(metai<1900) throw new KnyguException("Metai turi buti Daugiau nei 1900");
           System.out.println("Irasykite knygos leidimo menesi");
           int men = scanner.nextInt();
           if(1<=men && men<=12) throw new KnyguException("Menesis turi buti buo 1 iki 12");
           System.out.println("Irasykite knygos leidimo diena");
           int diena = scanner.nextInt();
           if(1<=diena && diena<=31) throw new KnyguException("Menesis turi buti buo 1 iki 12");
           knyga.setIsleidimoMetai(new Date(metai, men, diena));
           System.out.println(knyga);

        } catch (InputMismatchException e){
            System.out.println("Klaida prasome bandyti dar karta");
            scanner.nextLine();
            addKnyga();
        }
        knyguSarasas.add(knyga);

    }
    public void addKnyga(Knyga knyga){
        knyga.setSKAITYTOJOID(null);
        knyguSarasas.add(knyga);
    }

    public Knyga removeKnyga() throws KnyguException{
        String pavadinimas = null;
        Integer varID = null;
        Knyga knyga = null;
        try {
            System.out.println("Iveskite Knygos pavadinima");
            pavadinimas = scanner.nextLine();
            System.out.println("Iveskite vardotojoID");
            varID = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Klaida prasome bandyti dar karta");
            scanner.nextLine();
            removeKnyga();
        }
        if(knyga != null) return knyga;

        if(knyguSarasas.size() == 0)  throw new KnyguException("Bibliotika yra tuscia");
        if(pavadinimas == null || pavadinimas.isEmpty() || pavadinimas.isBlank() )  throw new KnyguException("Iveskite tinkama pavadinima");
        boolean knygaYra = false;
        int index = 0;
        for(int i = 0; i < knyguSarasas.size(); i++) {
            if(knyguSarasas.get(i).getPavadinimas().equals(pavadinimas)){
                knygaYra = true;
                index = i;
                break;
            }
        }
        if(!knygaYra) throw new KnyguException("Tokios knygos nera");
        else
        {
            System.out.println("Jus imate knyga: " + knyguSarasas.get(index).getPavadinimas());
            knyga = knyguSarasas.remove(index);
            knyga.setSKAITYTOJOID(varID);

        }

        return knyga;

    }
    public Knyga removeKnyga(String pavadinimas, Integer varID) throws KnyguException{
        if(knyguSarasas.size() == 0)  throw new KnyguException("Bibliotika yra tuscia");
        if(pavadinimas == null || pavadinimas.isEmpty() || pavadinimas.isBlank() )  throw new KnyguException("Iveskite tinkama pavadinima");
        boolean knygaYra = false;
        int index = 0;
        Knyga knyga = null;
        for(int i = 0; i < knyguSarasas.size(); i++) {
           if(knyguSarasas.get(i).getPavadinimas().equals(pavadinimas)){
                knygaYra = true;
                index = i;
                break;
            }
        }
        if(!knygaYra) throw new KnyguException("Tokios knygos nera");
        else
        {
            System.out.println("Jus imate knyga: " + knyguSarasas.get(index).getPavadinimas());
            knyga = knyguSarasas.remove(index);
            knyga.setSKAITYTOJOID(varID);
        }

       return knyga;

    }

    public boolean atsakymas() {
        while (true) {
            String scVerte = scanner.nextLine();
            if (scVerte.toUpperCase().equals("T")) return true;
            else if (scVerte.toUpperCase().equals("N")) return false;
        }
    }


    @Override
    public String toString() {
        String grazu = "";
        for (Knyga k : knyguSarasas) {
            grazu += "Pavadinimas: " + k.getPavadinimas() + "  Autorius :" + k.getAutorius().getVardas() + " " +k.getAutorius().getPavarde() + "  Leidimo metai: " +  k.getIsleidimoMetai().getYear() + "\n";
        }
        return grazu;
    }
}
