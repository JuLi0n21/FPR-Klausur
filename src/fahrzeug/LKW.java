package fahrzeug;

/**
 * Lkw, hat extra laderaum volumen
 */
public class LKW extends Fahrzeug implements Comparable {
    /**
     * The Laderaum volumen.
     */
    int laderaumVolumen;

    /**
     * Estellt neuen Pkw.
     * <p>
     * Abgeleitet von Fahrzeug:
     *
     * @see   Fahrzeug
     * @param id                     id
     * @param modellbeschreibung     modellbeschreibung
     * @param tagesmietpreis         tagesmietpreis
     * @param hoechstgeschwindigkeit hoechstgeschwindigkeit
     *                               <p>
     *                               Intern:
     * @param laderaumVolumen        laderaum volumen
     */
    public LKW(int id, String modellbeschreibung, double tagesmietpreis, int hoechstgeschwindigkeit, int laderaumVolumen) {
        super(id, modellbeschreibung, tagesmietpreis, hoechstgeschwindigkeit);
        this.laderaumVolumen = laderaumVolumen;
    }

    /**
     * Gibt laderaum volumen zurück
     *
     * @return laderaum volumen int
     */
    public int getLaderaumVolumen() {
        return laderaumVolumen;
    }

    /**
     * Setzt laderaum Volumen.
     *
     * @param laderaumVolumen laderaum volumen int
     */
    public void setLaderaumVolumen(int laderaumVolumen) {
        this.laderaumVolumen = laderaumVolumen;
    }

    @Override
    public String toString() {
        return "\nLKW" +
                super.toString() +
                "LaderaumVolumen=" + laderaumVolumen + "\n";
    }
}
