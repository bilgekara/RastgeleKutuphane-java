package randomLibary;
/**
 * @author Bilgenur
 */
public class Kisi {
    private final RastgeleKisi YeniKisi = new RastgeleKisi();
    private final Yas YeniYas = new Yas();
    private final Telefon YeniTelefon = new Telefon();
    private final ImeiNo YeniImei = new ImeiNo();
    private final KimlikNo YeniKimlik = new KimlikNo();
    private String Gonder;

    public String KisiOlustur() {
        Gonder = YeniKimlik.KimlikNo() + " " + YeniKisi.RastgeleKisi() + " " + YeniYas.Yas() + " " + YeniTelefon.Telefon() + " (" + YeniImei.IMEINo() + ")";
        return Gonder;
    }

    public String KimlikKontrol(String Kimlik) {
        KimlikNo Tckontrol = new KimlikNo();
        return Tckontrol.KimlikNuKontrol(Kimlik);
    }

    public String ImeiKontrol(String Imei) {
        ImeiNo ImeiKontrol = new ImeiNo();
        return ImeiKontrol.ImeiKontrol(Imei);
    }
}
