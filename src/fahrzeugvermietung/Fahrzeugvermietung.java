package fahrzeugvermietung;

import fahrzeug.EPKW;
import fahrzeug.Fahrzeug;
import fahrzeug.LKW;
import fahrzeug.PKW;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Fahrzeugvermietung
 * Verwaltet Die Tage sowie die dazu gehörigen Mietwagen
 * Sie werden in einem Kalender Gespeichert
 * Ein Kalender Eintrag enthält einen Tag und eine Liste der Autos welche an diesem Vermietet sind.
 * <p>
 * Zur Hilfe sind Mietwagen bereits implementiert.
 * Außerdem werden diese gespeichert und zufällig einer zufälligen anzahl an Tagen zugewissen.
 */
public class Fahrzeugvermietung {
    /**
     * The Fuhrpark.
     */
    Set<Fahrzeug> fuhrpark = new HashSet<>();
    /**
     * The Tages kalender.
     */
    Set<VermieteterTag> tagesKalender = new TreeSet<>(VermieteterTag::compareTo);

    /**
     * Erstellt Fahrzeugvermietung:
     * Legt Fahrzeuge an: 4 PKW, 3 E-PKW und 6 LKW
     * <p>
     * PKWS:
     * Porsche, Opel, Käfer, Seat
     * EPKWS:
     * Tesla, Nissan, Geco
     * LKWS:
     * Tesla, MAN, Cargobull, TATA
     */
    public Fahrzeugvermietung() {


        //einfügen von DUMMY DATA
        //4 PKWS
        fuhrpark.add(new PKW(1, "Porsche Cayman s", 3000, 350, 2));
        fuhrpark.add(new PKW(2, "Opel Corsa b", 150, 150, 5));
        fuhrpark.add(new PKW(3, "Käfer", 800, 110, 4));
        fuhrpark.add(new PKW(4, "Seat Leon", 200, 180, 5));

        //3 EPKWS
        fuhrpark.add(new EPKW(5, "Tesla Model Y", 1500, 217, 5, 410));
        fuhrpark.add(new EPKW(6, "Leaf", 300, 250, 5, 300));
        fuhrpark.add(new EPKW(7, "Geco Ole 3000", 120, 80, 1, 80));

        //6 LKWS
        fuhrpark.add(new LKW(8, "Tesla Semi", 350, 90, 15));
        fuhrpark.add(new LKW(9, "MAN", 200, 105, 45));
        fuhrpark.add(new LKW(10, "Cargobull", 180, 100, 50));
        fuhrpark.add(new LKW(11, "TATA", 220, 110, 47));
        fuhrpark.add(new LKW(12, "Shaanxi", 190, 120, 50));
        fuhrpark.add(new LKW(13, "Volvo", 260, 150, 80));



        /*Generiert 5-10 Tage mit zufällligem Datum
         * Und füllt diese mit 0-10 Fahrzeugen*/
        int maxDaycount = 10;
        int maxFahrzeugcount = 10;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < random.nextInt(5, maxDaycount); i++) {
            VermieteterTag tag = new VermieteterTag(new Datum(2022, random.nextInt(1, 12), random.nextInt(1, 31)));
            for (int j = 0; j < random.nextInt(0, maxFahrzeugcount); j++) {
                tag.addFahrzeug(getFahrzeug(random.nextInt(1, fuhrpark.size())));
            }
            tagesKalender.add(tag);
        }

    }

    /** Wird genutzt um Nach Datum zufragen.
     * */
    private static int datumeingeben() {

        System.out.println("Bitte Datum eingeben [TTMMJJJJ]");

        return new Scanner(System.in).nextInt();
    }

    private static void lines() {
        System.out.println("------------------------------------------");
    }

    /** Gibt Menu aus.
     * */
    private static void printMainMenu() {
        lines();
        System.out.println("WILLKOMMEN ZUR FAHRZEUGVERMIETUNGSSOFTWARE");
        lines();
        System.out.println("Wie möchten sie fortfahren?");
        System.out.println();
        System.out.println("[1] Übersicht");
        System.out.println("[2] Ändere Sortier kreterium");
        System.out.println("[3] Anzeigen aller Mieteinahmen eines Tages.");
        System.out.println();
        System.out.println("Verwaltung der Daten sowie enthaltener Daten");
        System.out.println("[4] Datum anpassen");
        System.out.println("[5] Datum hinzufügen");
        System.out.println("[6] Datum entfernen");
        System.out.println();
        System.out.println("Verwalten des Fuhrparks");
        System.out.println("[7] Fuhrpark Anzeigen");
        System.out.println("[8] Fahrzeug anpassen");
        System.out.println("[9] Fahrzeug hinzufügen");
        System.out.println("[10] Fahrzeug entfernen");
        System.out.println();
        System.out.println("[0] Beenden des Programms.");
        System.out.println("Zahl eingeben und mit ENTER Bestätigen!");
        System.out.println();
    }

    /** Gibt einen Eingabe String Formatiert aus.
     * */
    private static void printHeadline(String abschnitt) {
        lines();
        System.out.println(abschnitt);
        lines();
    }

    /** Liest eingabe ein und gibt sie weiter. Wird hauptsächlich verwendet um auf betätigung zuwarten befor es zurück ins menu geht.
     * */
    private static int back() {
        System.out.println("[0] Zurückehren");
        return new Scanner(System.in).nextInt();
    }

    /**
     * Gibt ein Fahrzeug aus dem Set wieder sofern vorhanden
     *
     * @param id ID welche das Fahrzeug eindeutig Identifiziert
     * @return Fahrzeug Fahrzeug
     */
    public Fahrzeug getFahrzeug(int id) {

        return fuhrpark.stream().filter(o -> o.getId() == id).findFirst().orElse(null);

    }

    /**
     * Fügt einen Tag in den Kalender ein
     *
     * @param date Fügt Datum in Kalender ein
     * @return Gibt zurück ob das einfügen erfolgreich war
     */
    public boolean addDatum(Datum date) {
        return tagesKalender.add(new VermieteterTag(date));
    }

    /**
     * Entfernt einen Tag aus dem Kalender
     *
     * @param date Datum welches entfernt werden soll
     * @return Gibt zurück ob entfernen erfolgreich war
     */
    public boolean removeDatum(Datum date) {

        return tagesKalender.remove(new VermieteterTag(date));
    }

    /**
     * Entfernt lehre Tag (Tage ohne eingetragene Autos) aus dem Kalender
     */
    public void removeEmptyDatum() {
        tagesKalender.removeIf(VermieteterTag::isEmpty);
    }

    /**
     * Gibt das Objekt zurück sofern es existert //REFACTORING
     *
     * @param date the date
     * @return the vermmieter tag
     */
    public VermieteterTag getDatumifexits(Datum date) {
        if (tagesKalender.stream().anyMatch(e -> e.getDatum().equals(date))) {
            return tagesKalender.stream().filter(e -> e.getDatum().equals(date)).findFirst().get();
        }

        return null;
    }

    /**
     * Gibt alle Fahrzeuge für jeweils einen Tag aus
     *
     * @return Gibt Tag + Fahrzeug.klasse und id formatiert zurück
     */
    public String printKalendar() {
        removeEmptyDatum();
        return "---TAG-----|---------Fahrzeuge-------------\n"
                + tagesKalender.stream().sorted().map(VermieteterTag::toString).collect(Collectors.joining("\n")) + "\n"
                + "-----------|-------------------------------";
    }

    /**
     * Gibt zu einem bestimmten Datum die Fahrzeuge wieder
     *
     * @param date Datum Datum
     * @return Ausgabewert string
     */
    public String printKalenderday(Datum date) {
        if (tagesKalender.stream().noneMatch(e -> e.getDatum().equals(date))) {
            return "Datum Existiert nicht";
        }
        return "---TAG------|---------Fahrzeuge---------------\n"
                + tagesKalender.stream().filter(e -> e.getDatum().equals(date)).findFirst().get() + "\n"
                + "------------|---------------------------------";
    }

    /**
     * Fügt einematum ein Fahrzeug über die ID hinzu.
     *
     * @param date Datum Datum
     * @param id   ID int
     * @return Gibt zurück ob funktioniert hat oder nicht.
     */
    public boolean addFahrzeugtoDatum(Datum date, int id) {
        if (getFahrzeug(id) != null) {
            if (tagesKalender.stream().anyMatch(e -> e.getDatum().equals(date))) {
                return tagesKalender.stream().filter(e -> e.getDatum().equals(date)).findFirst().get().addFahrzeug(getFahrzeug(id));
            }
            System.out.println("Datum existiert nicht: " + date);
            return false;
        }
        System.out.println("Kein Fahrzeug mit dieser ID: " + id);
        return false;
    }

    /**
     * Entfernt an einem Datum ein Fahrzeug über die ID
     *
     * @param date Datum Datum
     * @param id   ID int
     * @return Gibt zurück ob funktioniert hat oder nicht.
     */
    public boolean removeFahrzeugtoDatum(Datum date, int id) {
        if (tagesKalender.stream().anyMatch(e -> e.getDatum().equals(date))) {
            return tagesKalender.stream().filter(e -> e.getDatum().equals(date)).findFirst().get().removeFahrzeug(getFahrzeug(id));
        }
        System.out.println("Datum existiert nicht: " + date);
        return false;
    }

    /**
     * Gibt die Summe alle Mieten für jeden Tag zurück
     * Summiert dafür die Summen der einzelnen Tage.
     *
     * @return Gesammt Miete int
     */
    public double getMietSum() {
        return tagesKalender.stream().mapToDouble(e -> e.getFahrzeuglist().stream().mapToDouble(Fahrzeug::getTagesmietpreis).sum()).sum();
    }

    /**
     * Gibt miete für jeden Tag aus
     *
     * @return Ausgabewert verteiltmiete
     */
    public String getMietSumforDatum() {
        return "---TAG-----|-------Mietsumme---------------\n"
                + tagesKalender.stream().map(e -> ((String.format("%10s |", e.getDatum().toString())) + " " + e.getFahrzeuglist().stream().mapToDouble(Fahrzeug::getTagesmietpreis).sum())).collect(Collectors.joining("\n")) + "\n"
                + "-----------|---------------------------------";
    }

    /**
     * Leitet den Vergleichsoperator and die Sortier Funktion an alle tage im Kalenderweiter
     *
     * @param comparator Vergleichsoperator
     */
    public void sort(Comparator<Fahrzeug> comparator) {
        tagesKalender.forEach(
                tag -> tag.sort(comparator));
    }


    /**
     * Gibt die Inhalte des Sets aus.
     *
     * @return Liste der Fahrzeuge im fuhrpark
     */
    public String fuhrparktoString() {
        return fuhrpark.toString();
    }

    /**
     * Begin Punkt der Anwendung
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Datum Heute = null;
        Scanner input = new Scanner(System.in);

        Fahrzeugvermietung fahrzeugvermietung = new Fahrzeugvermietung();

        int Auswahl = -1;

        while (Auswahl != 0) {

            try {
                printMainMenu();
                Auswahl = input.nextInt();
                switch (Auswahl) {
                    case 0 -> System.exit(0);

                    /*------Übersichts Verwaltung------*/
                    case 1 -> { //Übersicht
                        printHeadline("Übersicht");
                        System.out.println();
                        System.out.println(fahrzeugvermietung.printKalendar());
                        System.out.println();
                        System.out.println("Gesamt Mieteinnahmen: " + fahrzeugvermietung.getMietSum());
                        System.out.println(fahrzeugvermietung.getMietSumforDatum());
                        System.out.println();
                        System.out.println();
                        back();
                    }
                    case 2 -> { //Sortierkrieterium
                        System.out.println("Bitte gewünschtes Sortier Krietierium angeben");
                        System.out.println();
                        System.out.println("[1] Mietpreise");
                        System.out.println("[2] Höchstgeschwindigkeit");
                        System.out.println("[3] ID");
                        int subAuswahl = back();
                        switch (subAuswahl) {
                            case 0 -> {
                                System.out.println("Keine Änderung");
                            }
                            case 1 -> {//nach Tagesmietpreise
                                fahrzeugvermietung.sort(Comparator.naturalOrder());
                                System.out.println("Sortiert nach Mietpreis");
                            }
                            case 2 -> { //nach Höchstgeschwindigkeit
                                fahrzeugvermietung.sort(Comparator.comparingInt(Fahrzeug::getHoechstgeschwindigkeit));
                                System.out.println("Sortiert nach Höchstgeschwindigkeit");
                            }
                            case 3 -> { //nach id
                                fahrzeugvermietung.sort(Comparator.comparingInt(Fahrzeug::getId));
                                System.out.println("Sortiert nach ID");
                            }
                            default -> {
                                System.err.println("Keine Valide Eingabe");
                            }

                        }
                        if (subAuswahl != 0) back();

                    }
                    case 3 -> { //Anzeigen der Mietsumme eines Datums
                        System.out.println("Mietsumme eines Tages Anzeigen!");
                        System.out.println(fahrzeugvermietung.printKalendar());
                        Heute = new Datum(datumeingeben());
                        printHeadline("Mieteinnahmen für den " + Heute + ": " + fahrzeugvermietung.getDatumifexits(Heute).getVermietSum());
                        System.out.println();
                        back();
                    }
                    /*------Datum Verwaltung------*/
                    case 4 -> { //Datum anpassen
                        System.out.println("Bitte ein Datum zum ändern auswählen!");
                        System.out.println(fahrzeugvermietung.printKalendar());
                        Heute = new Datum(datumeingeben());
                        if (fahrzeugvermietung.getDatumifexits(Heute) != null) {
                            System.out.println(fahrzeugvermietung.printKalenderday(Heute));
                            System.out.println("[1] Fahrzeug Hinzufügen");
                            System.out.println("[2] Fahrzeug Entfernen");
                            System.out.println();
                            Auswahl = back();
                            if (Auswahl == 1) {
                                System.out.println("Bitte Fahrzeug ID angeben:");
                                int fahrzeugid = input.nextInt();
                                if (fahrzeugvermietung.addFahrzeugtoDatum(Heute, fahrzeugid)) {
                                    System.out.println("Fahrzeug mit der ID: " + fahrzeugid + ".Wurde Hinzugefügt");
                                } else {
                                    System.out.println("Kein Fahrzeug wurde Hinzugefügt. Falsche ID eingegeben?");
                                }

                            }
                            if (Auswahl == 2) {
                                System.out.println("Bitte Fahrzeug ID angeben:");
                                int fahrzeugid = input.nextInt();
                                if (fahrzeugvermietung.removeFahrzeugtoDatum(Heute, fahrzeugid)) {
                                    System.out.println("Fahrzeug mit der ID: " + fahrzeugid + ". Wurde entfernt");
                                } else {
                                    System.out.println("Kein Fahrzeug wurde Entfernt. Falsche ID eingegeben?");
                                }
                            }
                        } else {
                            System.out.println("Datum: " + Heute + " existert nicht");
                        }
                        back();
                    }
                    case 5 -> { //Datum hinzufügen
                        System.out.println("Welches Datum soll hinzugefügt werden");
                        System.out.println(fahrzeugvermietung.printKalendar());
                        Heute = new Datum(datumeingeben());

                        if (fahrzeugvermietung.addDatum(Heute)) {
                            System.out.println("Datum: " + Heute + " wurde erfolgreich Hinzugefügt");
                            System.out.println("Bitte Direkt einen Wagen zum heutigen Datum hinzufügen(ID)");
                            int fahrzeugid = input.nextInt();
                            System.out.println(fahrzeugvermietung.addFahrzeugtoDatum(Heute, fahrzeugid));
                        } else {
                            System.out.println("Datum: " + Heute + " existert bereits");
                        }
                        back();
                    }
                    case 6 -> { //Tag Entfernen
                        System.out.println("Welcher Tag soll entfernt werden?");
                        System.out.println(fahrzeugvermietung.printKalendar());
                        Heute = new Datum(datumeingeben());

                        if (fahrzeugvermietung.removeDatum(Heute)) {
                            System.out.println("Datum: " + Heute + " wurde erfolgreich entfernt");
                        } else {
                            System.out.println("Datum: " + Heute + " existert nicht");
                        }
                        back();
                    }
                    /*------Fahrzeug Verwaltung------*/
                    case 7 -> {
                        printHeadline("Fahrzeug Übersicht");
                        System.out.println(fahrzeugvermietung.fuhrparktoString());
                        back();
                    }
                    case 8 -> {
                        printHeadline("Fahrzeug anpassen");
                        System.out.println(" ... Methode nicht implementiert da außerhalb der Klasur anforderungen ... ");
                        back();
                    }
                    case 9 -> {
                        printHeadline("Fahrzeug hinzufügen");
                        System.out.println(" ... Methode nicht implementiert da außerhalb der Klasur anforderungen ... ");
                        back();
                    }
                    case 10 -> {
                        printHeadline("Fahrzeug entfernen");
                        System.out.println(" ... Methode nicht implementiert da außerhalb der Klasur anforderungen ... ");
                        back();
                    }
                    default -> System.out.println("Unbekannte Eingabe, bitte nochmals versuchen.");

                }
            } catch (Exception e) {
                System.err.println(e.getMessage());

            }
        }
    }
}

