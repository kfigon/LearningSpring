package springdemo;

public class TrenerSzermierki implements Trener {

    private ObiektPomocniczy obiektPomocniczy;

    private String jakasNazwa;

    private String wlasciwosc;

    public String getWorkout() {
        return "Trenujemy mocno cos innego. Wlasciwosc: " + wlasciwosc;
    }

    public String getMsg() {
        return obiektPomocniczy.getMsg() + "nazwa wstrzyknieta z boku: " + jakasNazwa;
    }

    // setNAZWAPOLA
    public void setObiektPomocniczy(ObiektPomocniczy obiektPomocniczy) {
        this.obiektPomocniczy = obiektPomocniczy;
    }

    public void setJakasNazwa(String jakasNazwa) {
        this.jakasNazwa = jakasNazwa;
    }

    public void setWlasciwosc(String wlasciwosc) {
        this.wlasciwosc = wlasciwosc;
    }
}
