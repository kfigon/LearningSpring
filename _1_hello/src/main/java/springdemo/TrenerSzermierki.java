package springdemo;

public class TrenerSzermierki implements Trener {

    private ObiektPomocniczy obiektPomocniczy;

    private String jakasNazwa;

    public String getWorkout() {
        return "Trenujemy mocno cos innego";
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
}
