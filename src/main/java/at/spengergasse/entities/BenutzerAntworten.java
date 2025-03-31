package at.spengergasse.entities;

public class BenutzerAntworten {

    private String antwort;
    private float prozentSatz;

    public BenutzerAntworten() {

    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public float getProzentSatz() {
        return prozentSatz;
    }

    public void setProzentSatz(float prozentSatz) {
        this.prozentSatz = prozentSatz;
    }
}
