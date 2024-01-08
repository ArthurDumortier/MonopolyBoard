import java.util.ArrayList;
import java.util.List;

public class Projets {
    protected String titre;
    protected List<Cases> casesprojet = new ArrayList<>();
    protected static List<Projets> allprojets = new ArrayList<>();
    protected int majprice;

    public void addcase(Cases c) {
        casesprojet.add(c);
    }

    public void addprojet(Projets p) {
        allprojets.add(p);
    }

    public void setMajprice(int majprice) {
        this.majprice = majprice;
    }

    public int getMajprice() {
        return majprice;
    }

    public List<Cases> getcasesprojet() {
        return casesprojet;
    }

    public static List<Projets> getAllprojets() {
        return allprojets;
    }

    public String getTitre() {
        return titre;
    }

    public Projets(String titre) {
        this.titre = titre;
    }

}