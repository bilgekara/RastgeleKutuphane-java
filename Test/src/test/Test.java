package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import randomLibary.*;
/**
 * @author Bilgenur Kara
*/
public class Test {

    private static final Scanner Giris = new Scanner(System.in);
    private static final Kisi _Kisi = new Kisi();
    private static int secim = 0;
    private static int UretilecekKisiSayisi;
    private static RastgeleKisi rakamuret = new RastgeleKisi();
    
    public static void main(String[] args) throws IOException {
        
        while (secim != 3) {
            Secim();
            switch (secim) {

                case 1:
                    RastgeleKisiUret(UretilecekKisiSayisi);
                    break;

                case 2:
                    KontrolEt();
                    break;
                default:
                    System.out.println("Cikis...");
                    break;
            }

        }
    }
     public static void Secim() {

        System.out.println("1 - Rastgele Kisi uret\n2 - uretilmis Dosya Kontrol Et\n3 - cikis");
        System.out.print("Seciminiz :");
        secim = Giris.nextInt();

        while (secim < 1 || secim > 3) {
            System.out.println("Lutfen Gecerli Degerler Giriniz!\n1 - Rastgele Kisi uret\n2 - Uretilmis Dosya Kontrol Et\n3 - Ãƒâ€¡Ã„Â±kÃ„Â±Ã…Å¸");
            System.out.print("Seciminiz :");
            secim = Giris.nextInt();
        }
        if (secim == 1) {
            System.out.print("uretilecek Kisi Sayisi :");
            UretilecekKisiSayisi = Giris.nextInt();
        }

    }
     public static void RastgeleKisiUret(int in) throws FileNotFoundException, IOException {

        for (int i = 0; i < in; i++) {
            String kayit = _Kisi.KisiOlustur();
            System.out.println(kayit);
            File file = new File("Kisiler.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);

            bWriter.write(kayit);
            bWriter.newLine();
            bWriter.close();
        }
        System.out.println("Kayit Eklendi...");

    }
     public static void KontrolEt() throws FileNotFoundException, IOException {

        FileReader fileReader = new FileReader("Kisiler.txt");
        String line;
        
        try (BufferedReader okuma = new BufferedReader(fileReader)) {
            int GecerliTc = 0, GecersizTc = 0, GecerliImei = 0, GecersizImei = 0;
            while ((line = okuma.readLine()) != null) {

                String[] Bilgiler = line.split(" ");

                if ("GecerliTc".equals(_Kisi.KimlikKontrol(Bilgiler[0]))) {
                    GecerliTc++;
                } else if ("GecersizTc".equals(_Kisi.KimlikKontrol(Bilgiler[0]))) {
                    GecersizTc++;
                }

                if ("GecerliImei".equals(_Kisi.ImeiKontrol(Bilgiler[5].substring(1, Bilgiler[5].length() - 1)))) {
                    GecerliImei++;
                } else if ("GecersizImei".equals(_Kisi.ImeiKontrol(Bilgiler[5].substring(1, Bilgiler[5].length() - 1)))) {
                    GecersizImei++;
                }

            }
            System.out.println("\nT.C Kimlik Kontrol\n" + GecerliTc + " Gecerli\n" + GecersizTc + " Gecersiz");
            System.out.println("\nIMEI Kontrol\n" + GecerliImei + " Gecerli\n" + GecersizImei + " Gecersiz\n");
        }

    }
}
