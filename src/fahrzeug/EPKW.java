package fahrzeug;

/**
 * Epkw, abgeleitet von PKW, hat maximalereichweite extra
 */
public class EPKW extends PKW implements Comparable {

    /**
     * The Maximale reichweite.
     */
    int maximaleReichweite;

    /**
     * Erstellt EPKW.
     * <p>
     * Abgeleitet von Fahrzeug:
     *
     * @see   Fahrzeug
     * @param id                     the id
     * @param modellbeschreibung     the modellbeschreibung
     * @param tagesmietpreis         the tagesmietpreis
     * @param hoechstgeschwindigkeit the hoechstgeschwindigkeit
     *
     * @see PKW                      Abgeleitet von PKW:
     * @param anzahlSitze            the anzahl sitze
     *
     *                               Interne:
     * @param maximaleReichweite     the maximale reichweite
     */
    public EPKW(int id, String modellbeschreibung, double tagesmietpreis, int hoechstgeschwindigkeit, int anzahlSitze, int maximaleReichweite) {
        super(id, modellbeschreibung, tagesmietpreis, hoechstgeschwindigkeit, anzahlSitze);
        this.maximaleReichweite = maximaleReichweite;
    }

    /**
     * Gibt maximale reichweite zurück.
     *
     * @return maximale reichweite int
     */
    public int getMaximaleReichweite() {
        return maximaleReichweite;
    }

    /**
     * Setzt maximale reichweite.
     *
     * @param maximaleReichweite maximale reichweite int
     */
    public void setMaximaleReichweite(int maximaleReichweite) {
        this.maximaleReichweite = maximaleReichweite;
    }

    @Override
    public String toString() {
        return "\nE" +
                super.toString().substring(1, super.toString().length() - 2) + "\n" +
                "MaximaleReichweite=" + maximaleReichweite + "\n";
    }
}
