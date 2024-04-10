import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws KnyguException {

        /////////////////////////////////////////////////////////
        /////// Uzduotis nr1

        System.out.println();
        System.out.println("Uzduotis nr1");
        System.out.println();

        ImputManager imputManager = new ImputManager();
        IntDivider intDivider = new IntDivider();

//        while(true) {
//            System.out.println("Pradedame programa");
//            Integer x = intDivider.divide(imputManager.askForInput());
//            if (x != null) System.out.println("Jusu atsakymas yra: " + x);
//            System.out.println("Ar norite testi? (T/N)");
//            if(!imputManager.atsakymas()) break;
//        }

        /////////////////////////////////////////////////////////
        /////// Uzduotis nr2
        System.out.println();
        System.out.println("Uzduotis nr2");
        System.out.println();

        Autorius autorius1 = new Autorius("Vardenis1", "Pavardenis1", new Date(1952,12,2));
        Autorius autorius2 = new Autorius("Vardenis2", "Pavardenis2", new Date(1982,11,1));
        Autorius autorius3 = new Autorius("Vardenis3", "Pavardenis3", new Date(1912,1,11));

        Knyga knyga1 = new Knyga("Čia knygos pavadinimas 1", autorius1, new Date(1987,2,14));
        Knyga knyga2 = new Knyga("Čia knygos pavadinimas 2", autorius1, new Date(2000,3,15));
        Knyga knyga3 = new Knyga("Čia knygos pavadinimas 3", autorius1, new Date(2022,8,16));
        Knyga knyga4 = new Knyga("Čia knygos pavadinimas 4", autorius2, new Date(2014,1,17));
        Knyga knyga5 = new Knyga("Čia knygos pavadinimas 5", autorius2, new Date(1987,12,18));
        Knyga knyga6 = new Knyga("Čia knygos pavadinimas 6", autorius2, new Date(2011,2,19));
        Knyga knyga7 = new Knyga("Čia knygos pavadinimas 7", autorius3, new Date(1987,12,24));
        Knyga knyga8 = new Knyga("Čia knygos pavadinimas 8", autorius3, new Date(1987,2,14));
        Knyga knyga9 = new Knyga("Čia knygos pavadinimas 9", autorius3, new Date(2010,2,4));

        Biblioteka biblioteka = new Biblioteka();

        Knyga paimtaKnyga = null;

        System.out.println("Tuscios Bibliotikos testas: ");
        try {
            biblioteka.removeKnyga("Čia knygos pavadinimas 1",123);
            System.out.println();
            System.out.println(paimtaKnyga);

        }catch(KnyguException e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        ////Prideti knyga su scanner
        while(true) {
            System.out.println("Ar norite prideti knyga (T/N)");
            try {
                if (!biblioteka.atsakymas()) break;
                biblioteka.addKnyga();
            }catch(KnyguException e){
            System.out.println(e.getMessage());
            }
        }
        ////Paimti knyga knyga su scanner
        while(true) {
            System.out.println("Ar norite paimti knyga (T/N)");
            if(!biblioteka.atsakymas()) break;
            try {
                 paimtaKnyga = biblioteka.removeKnyga();
                 System.out.println(paimtaKnyga);
            }catch(KnyguException e){
                System.out.println(e.getMessage());
            }

        }

        /////Prideti be scanner
        biblioteka.addKnyga(knyga1);
        biblioteka.addKnyga(knyga2);
        biblioteka.addKnyga(knyga3);
        biblioteka.addKnyga(knyga4);
        biblioteka.addKnyga(knyga5);
        biblioteka.addKnyga(knyga6);
        biblioteka.addKnyga(knyga7);
        biblioteka.addKnyga(knyga8);
        biblioteka.addKnyga(knyga9);


        System.out.println("Tokios knygos nera testas: ");
        try {
            paimtaKnyga = biblioteka.removeKnyga("Čia knygos pavadinimas ",123);
            System.out.println();
            System.out.println(paimtaKnyga);
        }catch(KnyguException e){
            System.out.println(e.getMessage());

        }

        System.out.println();
        System.out.println("Knygos paejimo testas (tokios nera): ");
        try {
            paimtaKnyga = biblioteka.removeKnyga("Čia knygos pavadinimas ",123);
            System.out.println();
            System.out.println(paimtaKnyga);
        }catch(KnyguException e){
            System.out.println(e.getMessage());

        }

        System.out.println();
        System.out.println("Knygos paejimo testas: ");
        try {
            paimtaKnyga = biblioteka.removeKnyga("Čia knygos pavadinimas 1",123);
            System.out.println();
            System.out.println(paimtaKnyga);
        }catch(KnyguException e){
            System.out.println(e.getMessage());

        }


        if (paimtaKnyga != null)  biblioteka.addKnyga(paimtaKnyga);


        System.out.println();
        System.out.println("Tinkamo pavadinimo testas: ");
        try {
            paimtaKnyga = biblioteka.removeKnyga(null,123);
            System.out.println();
            System.out.println(paimtaKnyga);
        }catch(KnyguException e){
            System.out.println(e.getMessage());

        }

        System.out.println();
        System.out.println("Knygos bibliotekoje: ");
        System.out.println(biblioteka);


    }
}