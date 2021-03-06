package randomLibary;
/**
 *
 * @author Bilgenur
 */
public class ImeiNo {
    private final rakamUret rakamuret = new rakamUret();
    private String ImeiNumarasi = "";

    public String IMEINo() {
        ImeiNumarasi = "";
        int ImeiDizi[] = new int[15], Tsayi = 0, Csayi = 0, yedek = 0;
        for (int i = 0; i < 15; i++) {
            ImeiDizi[i] = rakamuret.myRand(0, 9);
        }
        for (int i = 0; i <= 12; i += 2) {
            Tsayi += ImeiDizi[i];
        }
        for (int a = 1; a <= 13; a += 2) {
            yedek = ImeiDizi[a] * 2;
            if (yedek > 9) {
                yedek = yedek - 9;
            }
            Csayi += yedek;
        }
        yedek = Csayi + Tsayi;
        double Yyedek = ((Math.ceil(yedek / 10)) * 10) + 10;
        if (((int) Yyedek - yedek) > 9) {
            ImeiDizi[14] = ((int) Yyedek - yedek) % 10;
        } else {
            ImeiDizi[14] = (int) Yyedek - yedek;
        }
        for (int a = 0; a < 15; a++) {
            ImeiNumarasi += ImeiDizi[a];
        }
        return ImeiNumarasi;
    }

    public String ImeiKontrol(String Imei) {
        String ImeiDondur = "";
        double KTsayi = 0, KCsayi = 0;
        int ImeiDizi[] = new int[Imei.length()];

        if (Imei.length() != 15) {
            return "GecersizImei";
        }
        for (int i = 0; i < Imei.length(); i++) {
            ImeiDizi[i] = Integer.parseInt(Imei.substring(i, i + 1));
        }
        for (int i = 0; i <= 12; i += 2) {
            KTsayi += ImeiDizi[i];
        }
        for (int i = 1; i <= 13; i += 2) {
            if (ImeiDizi[i] * 2 > 9) {
                KCsayi += ImeiDizi[i] * 2 - 9;
            } else {
                KCsayi += ImeiDizi[i] * 2;
            }
        }
        double Kyedek = ((Math.ceil((KTsayi + KCsayi) / 10)) * 10);
        for (int i = 0; i < 15; i++) {
            ImeiDondur += ImeiDizi[i];
        }
        if (Kyedek - (KTsayi + KCsayi) == ImeiDizi[14]) {
            return "GecerliImei";
        } else {
            return "GecersizImei";
        }
    }
}
