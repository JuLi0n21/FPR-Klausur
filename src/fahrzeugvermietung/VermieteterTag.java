package fahrzeugvermietung;

import fahrzeug.EPKW;
import fahrzeug.Fahrzeug;
import fahrzeug.LKW;
import fahrzeug.PKW;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Speichert Daten und Fahrzeuge in einer Liste für jeweils einen Tag
 * @see Datum
 * @see Fahrzeug
 *
 * Diese Objekte Werden in Fahrzeugvermietung verwaltet.
 * @see Fahrzeugvermietung
 */
public class VermieteterTag implements Comparable<VermieteterTag> {
    /**
     * The Fahrzeuglist.
     */
    ArrayList<Fahrzeug> fahrzeuglist = new ArrayList<>();
    /**
     * The Tag.
     */
    Datum datum;

    /**
     * Instantiates a new Vermieteter tag.
     *
     * @param datum the tag
     */
    public VermieteterTag(Datum datum) {
        this.datum = datum;
    }

    /**
     * Dient zum Testen der VermieteterTag methoden
     * Entry Point is in
     * @see Fahrzeugvermietung
     *
     *
     * @param args the input arguments
     */
    static public void main(String[] args) {
        VermieteterTag montag = new VermieteterTag(new Datum(2001, 9, 21));
        VermieteterTag dienstag = new VermieteterTag(new Datum(2001, 9, 22));
        VermieteterTag mittwoch = new VermieteterTag(new Datum(2001, 9, 23));
        dienstag.addFahrzeug(new PKW(2, "Opel Corsa b", 150, 150, 5));
        montag.addFahrzeug(new PKW(2, "Opel Corsa b", 150, 150, 5));
        montag.addFahrzeug(new PKW(3, "Käfer", 800, 110, 4));
        montag.addFahrzeug(new PKW(4, "Seat Leon", 200, 180, 5));
        montag.addFahrzeug(new PKW(3, "Käfer", 800, 110, 4));
        montag.addFahrzeug(new PKW(4, "Seat Leon", 200, 180, 5));

        //3 EPKWS
        montag.addFahrzeug(new EPKW(5, "Tesla Model Y", 1500, 217, 5, 410));

        montag.addFahrzeug(new LKW(8, "Tesla Semi", 350, 90, 15));

        System.out.println(montag);
        System.out.println(montag.getVermietSum());


        montag.removeFahrzeugindex(4);
        montag.removeFahrzeugindex(2);
        montag.removeFahrzeugindex(1);
        System.out.println(montag);
        System.out.println(dienstag);
        System.out.println(montag.getVermietSum());

    }

    /**
     * Gets datum.
     *
     * @return the datum
     */
    public Datum getDatum() {
        return datum;
    }

    /**
     * Gets fahrzeuglist.
     *
     * @return the fahrzeuglist
     */
    public List<Fahrzeug> getFahrzeuglist() {
        return fahrzeuglist;
    }

    /**
     * Sets fahrzeuglist.
     *
     * @param fahrzeug the fahrzeug
     * @return the boolean
     */
    public boolean addFahrzeug(Fahrzeug fahrzeug) {

        if (!this.fahrzeuglist.contains(fahrzeug)) {
            this.fahrzeuglist.add(fahrzeug);
            fahrzeuglist.sort(null);
            return true;
        }
        //System.err.println("Fahrzeug existiert Bereits!");
        return false;
    }

    /**
     * Remove fahrzeug boolean.
     *
     * @param fahrzeug the fahrzeug
     * @return the boolean
     */
    public boolean removeFahrzeug(Fahrzeug fahrzeug) {
        if (this.fahrzeuglist.contains(fahrzeug)) {
            this.fahrzeuglist.remove(fahrzeug);
            fahrzeuglist.sort(null);
            return true;
        } else return false;

    }

    /**
     * Remove fahrzeugindex.
     *
     * @param index the index
     */
    public void removeFahrzeugindex(int index) {

        this.fahrzeuglist.remove(index);

    }

    /**
     * Nutzt Streams zum summieren aller Tagesvermietspreise der Fahrzeuge vermieted an diesem Tag.
     *
     * @return Gibt die Summe zurück.
     */
    public double getVermietSum() {

        return fahrzeuglist.stream().mapToDouble(e -> e.getTagesmietpreis()).sum();
    }

    @Override
    public int hashCode() {

        return datum.hashCode();
    }

    @Override
    public String toString() {

        String fahrzeuge = fahrzeuglist.stream().map(e -> String.format("%5s ",e.getClass().getSimpleName() + e.getId())).collect(Collectors.joining(""));

        return String.format("%10s | %s ",datum.toString(),fahrzeuge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VermieteterTag that = (VermieteterTag) o;

        return datum.equals(that.datum);
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return fahrzeuglist.isEmpty();
    }

    /**
     * Natürlicher Sort
     */
    public void sort() {
        fahrzeuglist.sort(Fahrzeug::compareTo);
    }

    /**
     * Sortiert die Fahrzeugliste nach angebenen Verlgeichsoperator aufsteigend
     *
     * @param comparator the comparator
     */
    public void sort(Comparator<Fahrzeug> comparator) {

        Collections.sort(fahrzeuglist, comparator);
    }

    /**
     * Erstellt 2 Datums objekt und Vergleicht diese
     * <p>
     * War zu faul es selber zu implementieren
     */
    @Override
    public int compareTo(VermieteterTag o) {

        return new Date(this.datum.getYear(), this.datum.getMonth(), this.datum.getDate()).compareTo(new Date(o.datum.getYear(), o.datum.getMonth(), o.datum.getDate()));

    }
}



