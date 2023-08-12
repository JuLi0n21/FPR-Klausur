package fahrzeug;

/**
 * Pkw, hat extra Anzahl von Sitzen
 */
public class PKW extends Fahrzeug implements Comparable {
    /**
     * The Anzahl sitze.
     */
    int anzahlSitze;

    /**
     * Erstellt neuen Pkw.
     * <p>
     * Abgeleitet von Fahrzeug:
     *
     * @see   Fahrzeug
     * @param id                     the id
     * @param modellbeschreibung     the modellbeschreibung
     * @param tagesmietpreis         the tagesmietpreis
     * @param hoechstgeschwindigkeit the hoechstgeschwindigkeit
     *                               <p>
     *                               Intern:
     * @param anzahlSitze            the anzahl sitze
     */
    public PKW(int id, String modellbeschreibung, double tagesmietpreis, int hoechstgeschwindigkeit, int anzahlSitze) {
        super(id, modellbeschreibung, tagesmietpreis, hoechstgeschwindigkeit);
        this.anzahlSitze = anzahlSitze;
    }

    /**
     * Gibt anzahl sitze zurück.
     *
     * @return the anzahl sitze
     */
    public int getAnzahlSitze() {
        return anzahlSitze;
    }

    /**
     * Setzt anzahl sitze.
     *
     * @param anzahlSitze the anzahl sitze
     */
    public void setAnzahlSitze(int anzahlSitze) {
        this.anzahlSitze = anzahlSitze;
    }

    @Override
    public String toString() {
        return "\nPKW" +
                super.toString() + "\n" +
                "AnzahlSitze=" + anzahlSitze + "\n";
    }
}
