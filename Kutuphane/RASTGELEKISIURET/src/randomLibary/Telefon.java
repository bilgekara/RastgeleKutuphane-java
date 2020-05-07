package randomLibary;
/**
 * @author Bilgenur
 */
public class Telefon {
    private final rakamUret tel = new rakamUret();
    private String TelNumarasi = "";

    public String Telefon() {
        TelNumarasi = "";
        int TelDizi[] = new int[11];
        TelDizi[0] = 0;
        TelDizi[1] = 5;
        TelDizi[2] = tel.myRand(3,5);
        
        while (TelDizi[2] < 3 || TelDizi[2] > 5) {
            TelDizi[2] = tel.myRand(3,5) ;
        }
        
        
        for (int a = 3; a < 11; a++) {
            TelDizi[a] = tel.myRand(0,9);
        }
        for (int a = 0; a < 11; a++) {
            TelNumarasi += TelDizi[a];
        }
        return TelNumarasi;
    }
}
