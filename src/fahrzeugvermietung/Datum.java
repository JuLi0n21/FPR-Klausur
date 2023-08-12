package fahrzeugvermietung;

/**
 * Stellt eigenen Datumstypen da.
 * Sollte mit Offizeller Libray ersetzt werden.
 */
public class Datum {
    private int date;
    private int month;
    private int year;

    /**
     * Instantiates a new Datum.
     *
     * @param year  year int
     * @param month month int
     * @param date  date int
     */
    public Datum(int year, int month, int date) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    /**
     * Erstellt aus einem Eingabe string ein Datum
     * <p>
     * Wenn der Tag mit einer Null beginnt(einstellig) wird es von NextInt() abgeschnitten;
     * <p>
     * Deswegen müssen die Substrings angepasst werden, Das selbe wird mit dem Monat wiederholt
     *
     * @param datum datum String
     */
    public Datum(Integer datum) {
        int year, month, date;


        if(datum.toString().length()< 7 || datum.toString().length()> 8){
            throw new RuntimeException("Datums eingabe nicht Identifizerbar: '" + datum + "'. Kehre zum Hauptmenu zurück!");
        }


        if (datum.toString().length() == 7) {
            date = Integer.parseInt((datum.toString().substring(0, 1)));

            if (Integer.parseInt((datum.toString().substring(1, 2))) == 0) {

                month = Integer.parseInt((datum.toString().substring(2, 3)));

            } else {
                month = Integer.parseInt((datum.toString().substring(1, 3)));
            }
            year = Integer.parseInt((datum.toString().substring(3, 7)));
        } else {
            date = Integer.parseInt((datum.toString().substring(0, 2)));
            if (Integer.parseInt((datum.toString().substring(2, 3))) == 0) {

                month = Integer.parseInt((datum.toString().substring(3, 4)));
            } else {
                month = Integer.parseInt((datum.toString().substring(2, 4)));
            }
            year = Integer.parseInt((datum.toString().substring(4, 8)));

        }
        this.date = date;
        this.month = month;
        this.year = year;
        //System.out.println("Eingegbenes Datum: " + date + " " + month + " " + year);

    }

    /**
     * Gibt den Tag zurück.
     *
     * @return the date
     */
    public int getDate() {
        return date;
    }

    /**
     * Setzt den Tag.
     *
     * @param date the date
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * Gibt den Monat zurück.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Setzt den Monat.
     *
     * @param month the month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Gibt das Jahr zurück.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Setzt das Jahr.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Datum datum = (Datum) o;

        if (date != datum.date) return false;
        if (month != datum.month) return false;
        return year == datum.year;
    }

    @Override
    public int hashCode() {
        int result = date;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }


    @Override
    public String toString() {
        return date + "." + month + "." + year;
    }
}
