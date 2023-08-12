package fahrzeug;

/**
 * Basis Klasse der Fahrzeuge, von ihr Leiten alle ab.
 * @see PKW
 * @see EPKW
 * @see LKW
 *
 * Die Objekte werden in Fahrzeugvermietung sowie VermieterTag genutzt
 * @see fahrzeugvermietung.Fahrzeugvermietung
 * @see fahrzeugvermietung.VermieteterTag
 *
 */
public abstract class Fahrzeug implements Comparable {
    /**
     * Die Id.
     */
    int id;
    /**
     * Die Modellbeschreibung
     */
    String modellbeschreibung;
    /**
     * Der Tagesmietpreis.
     */
    double tagesmietpreis;
    /**
     * Die Hoechstgeschwindigkeit.
     */
    int hoechstgeschwindigkeit;

    /**
     * Stellt für die Abgeleiteten klassen die folgenden Werte zur verfügung;
     *
     * @param id                     Die ID beschreibt das Fahrzeug eindeutig
     * @param modellbeschreibung     Beschreibt das Model des Fahrzeugs(Hier namen des Fahrzeugs)
     * @param tagesmietpreis         Preis der pro Tag gezahlt werden muss
     * @param hoechstgeschwindigkeit Maximale Geschwindigkeit des Fahrzeugs
     */
    public Fahrzeug(int id, String modellbeschreibung, double tagesmietpreis, int hoechstgeschwindigkeit) {
        this.id = id;
        this.modellbeschreibung = modellbeschreibung;
        this.tagesmietpreis = tagesmietpreis;
        this.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
    }

    /**
     * Gibt ID zurück
     *
     * @return the ID int
     */
    public int getId() {
        return id;
    }

    /**
     * Setzt ID
     *
     * @param id ID int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gibt modellbeschreibung zurück
     *
     * @return modellbeschreibung String
     */
    public String getModellbeschreibung() {
        return modellbeschreibung;
    }

    /**
     * Setzt die Modellbeschreibung
     *
     * @param modellbeschreibung modellbeschreibung String
     */
    public void setModellbeschreibung(String modellbeschreibung) {
        this.modellbeschreibung = modellbeschreibung;
    }

    /**
     * Gibt Mietkosten pro Tag zurück;
     *
     * @return tagesmietpreis double
     */
    public double getTagesmietpreis() {
        return tagesmietpreis;
    }

    /**
     * Legt den Mietpreis pro Tag fest
     *
     * @param tagesmietpreis tagesmietpreis double
     */
    public void setTagesmietpreis(double tagesmietpreis) {
        this.tagesmietpreis = tagesmietpreis;
    }

    /**
     * Gibt hoechstgeschwindigkeit zurück.
     *
     * @return hoechstgeschwindigkeit int
     */
    public int getHoechstgeschwindigkeit() {
        return hoechstgeschwindigkeit;
    }

    /**
     * Setzt hoechstgeschwindigkeit
     *
     * @param hoechstgeschwindigkeit hoechstgeschwindigkeit int
     */
    public void setHoechstgeschwindigkeit(int hoechstgeschwindigkeit) {
        this.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
    }

    /**
     * Stellt den Natürlichen Sortierer Voraus
     * */
    @Override
    public int compareTo(Object o) {

        Fahrzeug other = (Fahrzeug) o;

        if (this.tagesmietpreis > other.tagesmietpreis) {
            return 1;
        } else if (this.tagesmietpreis < other.tagesmietpreis) {
            return -1;
        }
        return 0;
    }

    /**
     * Gleiche Object werden an der ID identifiziert
     */
    @Override
    public boolean equals(Object o) {

        Fahrzeug other = (Fahrzeug) o;

        return this.id == other.id;
    }

    /**
     * Wird vom Set benötigt um die Einzigartigkeit des Fahrzeug zu prüfen
     * Da Fahrzeuge in der Theorie Mehrmals existieren können wird nur die Id auf Kopien geprüft, bzw in den Hash mit einbezogen
     */
    @Override
    public int hashCode() {
        return id * 31;
    }


    @Override
    public String toString() {
        return
                "\nId=" + id + "\n" +
                        "Modellbeschreibung='" + modellbeschreibung + '\'' + "\n" +
                        "Tagesmietpreis=" + tagesmietpreis + "\n" +
                        "Hoechstgeschwindigkeit=" + hoechstgeschwindigkeit;
    }

}
