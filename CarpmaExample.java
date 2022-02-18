import java.util.*;


public class CarpmaExample {



    static String zeroRemover(String inputS) {

        

        

        if( inputS.charAt(0) == '0') {
            String zeroless = "";

            //son karakteri silmemek için - 1 yaptım
        for(int i = 1; i < inputS.length() - 1 ; i++) {

            if( inputS.charAt(i) != '0') {

                zeroless = inputS.substring(i);
                break;
            }

        }

        if(zeroless == "") zeroless += inputS.charAt( inputS.length() - 1 );

        return zeroless;

    }

    return inputS;

    }

    static String zeroAdder(String inputS, int zeroCount) {

        String newText = inputS;

        for(int i = 0; i < zeroCount; i++) {

            newText += '0';


        }

        return newText;


    }


    static String stringTopla(String ust, String alt) {

        int eldeVar = 0;
        List<Integer> lUst = new ArrayList<Integer>();
        List<Integer> lAlt = new ArrayList<Integer>();
        List<Integer> sonuc = new ArrayList<Integer>();
    
        for(int i = 0; i < ust.length(); i++) {
            //48 çıkararak ASCII'de 0ın 0a gelmesini sağlıyorum
            int sayiChar = ust.charAt(i) - 48; 
            lUst.add(sayiChar);
        }
    
        for(int i = 0; i < alt.length(); i++) {
            //48 çıkararak ASCII'de 0ın 0a gelmesini sağlıyorum
            int sayiChar = alt.charAt(i) - 48; 
            lAlt.add(sayiChar);
        }
    
        int ustKonum = ust.length() - 1;
        int altKonum = alt.length() - 1; 
    
        if(ustKonum > altKonum) {
    
            for(int i = ustKonum; i >= 0; i--) {
    
                if(altKonum >= 0) {
    
                int eklenecekRakam;
                eklenecekRakam =  lUst.get(ustKonum) + lAlt.get(altKonum) + eldeVar;
    
                eldeVar = eklenecekRakam / 10;
                eklenecekRakam = eklenecekRakam % 10;
    
    
                sonuc.add(eklenecekRakam);
    
    
                } else {
    
                    int eklenecekRakam;
                    eklenecekRakam =  lUst.get(ustKonum) + 0 + eldeVar;
    
                    eldeVar = eklenecekRakam / 10;
                    eklenecekRakam = eklenecekRakam % 10;
    
    
                    sonuc.add(eklenecekRakam);
    
    
                }
    
                ustKonum--;
                altKonum--;
    
            }
    
    
        } else {
    
    
            
            for(int i = altKonum; i >= 0; i--) {
    
                if(ustKonum >= 0) {
    
                int eklenecekRakam;
                eklenecekRakam =  lUst.get(ustKonum) + lAlt.get(altKonum) + eldeVar;
    
                eldeVar = eklenecekRakam / 10;
                eklenecekRakam = eklenecekRakam % 10;
    
    
                sonuc.add(eklenecekRakam);
    
    
                } else {
    
                    int eklenecekRakam;
                    eklenecekRakam =  lAlt.get(altKonum) + 0 + eldeVar;
    
                    eldeVar = eklenecekRakam / 10;
                    eklenecekRakam = eklenecekRakam % 10;
    
    
                    sonuc.add(eklenecekRakam);
    
    
                }
    
                ustKonum--;
                altKonum--;
    
            }
    
    
    
        }
    
        if( eldeVar > 0) sonuc.add(eldeVar);
    
        String toplamText = "";
    
        for(int i = sonuc.size() - 1; i >= 0; i--) {
    
            toplamText += sonuc.get(i);
    
        }
        toplamText = zeroRemover(toplamText);
        return toplamText;
    
    }
    
    static String stringCarp(String ust, String alt) {

        if(ust.length() < alt.length()) {

            String temp = ust;
            ust = alt;
            alt = temp;

        }



        
        int eldeVar = 0;
        List<Integer> lUst = new ArrayList<Integer>();
        List<Integer> lAlt = new ArrayList<Integer>();
        

        String toplamSonuc = "";
    
        for(int i = 0; i < ust.length(); i++) {
            //48 çıkararak ASCII'de 0ın 0a gelmesini sağlıyorum
            int sayiChar = ust.charAt(i) - 48; 
            lUst.add(sayiChar);
        }
    
        for(int i = 0; i < alt.length(); i++) {
            //48 çıkararak ASCII'de 0ın 0a gelmesini sağlıyorum
            int sayiChar = alt.charAt(i) - 48; 
            lAlt.add(sayiChar);
        }
    
        int ustKonum = ust.length() - 1;
        int altKonum = alt.length() - 1; 


        for(int i = altKonum; i >= 0; i--) {

            List<Integer> sonuc = new ArrayList<Integer>();
    
            for(int k = ustKonum; k >= 0; k--) {

                int eklenecekRakam;
                eklenecekRakam =  lUst.get(k) * lAlt.get(i) + eldeVar;
    
                eldeVar = eklenecekRakam / 10;
                eklenecekRakam = eklenecekRakam % 10;
    
    
                sonuc.add(eklenecekRakam);
    

            }

            if( eldeVar != 0) sonuc.add(eldeVar);
            eldeVar = 0;
            
                String toplamText = "";

                for(int m = sonuc.size() - 1; m >= 0; m--) {

                    toplamText += sonuc.get(m);
            
                }


                toplamText = zeroAdder( toplamText, altKonum - i);


                if(toplamSonuc != "") toplamSonuc = stringTopla(toplamSonuc, toplamText);
                else toplamSonuc = toplamText;


            

        }
        toplamSonuc = zeroRemover(toplamSonuc);
        return toplamSonuc;

    }

    public static void main(String args[]) {
    
        String toplamaSonuc = stringTopla( "643", "879");
        System.out.println(toplamaSonuc);

        String sonuc = stringCarp( "97067048534963074327437274384327986748796342796849786432784679824639784673987724396378347869237894678943278967293874392878978932443763272724268", "76934358528343467824783969743977839472968673479864264798246739796476248796427982789643789642798627948326784976928347494324697674236472976924796234789462786247986423796249364226272");
        System.out.println(sonuc);
    
    }
    
    
    
}
