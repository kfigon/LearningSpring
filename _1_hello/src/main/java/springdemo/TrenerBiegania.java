package springdemo;

public class TrenerBiegania implements Trener {

    private ObiektPomocniczy obiektPomocniczy;

    public TrenerBiegania(ObiektPomocniczy obiektPomocniczny) {
        this.obiektPomocniczy = obiektPomocniczny;
    }

    public String getWorkout() {
        return "Biegaj typie!";
    }

    public String getMsg() {
        return obiektPomocniczy.getMsg();
    }
}
