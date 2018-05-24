package springdemo;

public class TrenerBaseballu implements Trener {

    // dependency
    private ObiektPomocniczy obiektPomocniczy;

    public TrenerBaseballu(ObiektPomocniczy obiektPomocniczy) {
        this.obiektPomocniczy = obiektPomocniczy;
    }

    public String getWorkout() {
        return "machaj kijem";
    }

    public String getMsg() {
        return obiektPomocniczy.getMsg();
    }
}
