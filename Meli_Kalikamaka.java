import sun.security.acl.WorldGroupImpl;

import java.io.*;
import java.nio.file.ClosedWatchServiceException;
import java.util.Arrays;
import java.util.Scanner;

public class Meli_Kalikamaka {
    /*
        Meli kalikamaka (meli)
        Lõppvoor 14.02.2015
        http://eio.ee/uploads/Main/2015-02-14-fv.zip
        Failitee /lv-2015/meli/statement/statement.et.pdf

        --- Reeglid ---

        * Sõnades ei ole korduvaid ega pikki täis- ja kaashäälikuid
        * Igale kaashäälikule järgneb alati üks täishäälik
        * Ei eristata häälikuid r, l, s, k

        --- Kasutus ---

        Kõik pikad ja ülipikad täis- ja kaashäälikud muutuvad lühikesteks. - shortenSequence
        Nt "tee" -> "te", "mokka" -> "moka", "toooo" -> "to".

        Järjestikustest täishäälikutest jääb alles esimene. - keepOneVowel
        Nt "tea" -> "te".

        Järgnevate ja sõna lõpus olevate kaashäälikute vahele lisatakse täishäälikud. Lihtsuse mõttes "a".
        Nt "ahv" -> "ahava", "onn" -> "ona".

        "R" -> "L", "S" -> "K" - convertLetters
        Nt "kass" -> "kaka", "tervist" -> "telavikata".

        --- Sisend ---

        * a-z
        * 1-100 märki
        * ei alga ega lõpe tühikutega
        * kahe sõna vahel üks tühik

        --- Näited ---

        "merri krismas" -> "meli kalikamaka"
        "haid joule" -> "hada jole"
        "s rosdestvom" -> "ka lokadekatavoma"
        "uks url" -> "ukaka ulala"
     */

    public static String vowels = "aeiou"; // õäöü is not important here
    public static char[] wordLetters;
    public static void main(String[] arg) throws IOException {
        // Manual operation
        //System.out.println(translate("merri krismas"));
        //System.out.println(translate("haid joule"));
        //System.out.println(translate("s rosdestvom"));
        //System.out.println(translate("uks url"));

        // Loop through all files
        for (int i = 0; i < 30; i++){
            String fileNo = String.valueOf(i);
            String inputWord = readFile("meli_in/input" + fileNo);
            String translatedWord;
            System.out.println("Sõna on " + inputWord);

            translatedWord = translate(inputWord);

            System.out.println("Tõlge on " + translatedWord);

            String testWord = readFile("meli_out/output" + fileNo);
            if(testWord.equals(translatedWord)){
                System.out.println("ÕIGE!");
            }
            else{
                System.out.println("VALE! Õige oleks " + testWord);
            }
            System.out.println();
            writeFile(translatedWord); // Write to melival.txt
        }
    }

    // R > L, S > K
    private static char[] convertLetters(char[] letters){
        for(int i = 0; i < letters.length; i++){
            if(letters[i] == 'r'){
                letters[i] = 'l';
            }
            else if(letters[i] == 's'){
                letters[i] = 'k';
            }
        }
        return letters;
    }

    // Remove repeating letters
    private static char[] shortenSequence(char[] letters) {
        CharArrayWriter newLetters = new CharArrayWriter();
        char prevLetter = Character.MIN_VALUE; // basically empty
        char curLetter;

        for (int i = 0; i < letters.length; i++){
            if (i > 0) {
                prevLetter = letters[i - 1];
            }
            curLetter = letters[i];

            if (prevLetter != curLetter){ // Append current letter only if previous one is not the same
               newLetters.append(curLetter);
            }
        }

        return newLetters.toCharArray();
    }

    // Keep only one vowel
    private static char[] keepOneVowel(char[] letters) {
        CharArrayWriter newLetters = new CharArrayWriter();
        char prevLetter = Character.MIN_VALUE; // basically empty
        char curLetter;

        for (int i = 0; i < letters.length; i++){
            if (i > 0) {
                prevLetter = letters[i - 1];
            }
            curLetter = letters[i];

            // If prev letter is a vowel and current one isn't
            if (vowels.contains(Character.toString(prevLetter))){
                if (!vowels.contains(Character.toString(curLetter))){
                    newLetters.append(curLetter);
                }
            }
            else {
                newLetters.append(curLetter);
            }
        }
        return newLetters.toCharArray();
    }

    // Add the vowel "a" to consonants that don't have vowels
    private static char[] addVowelToConsonant(char[] letters) {
        CharArrayWriter newLetters = new CharArrayWriter();
        String vowels = "aeiou";
        char prevLetter = Character.MIN_VALUE; // basically empty
        char curLetter = Character.MIN_VALUE;

        for (int i = 0; i < letters.length; i++){
            if (i > 0) {
                prevLetter = letters[i - 1];
            }
            curLetter = letters[i];

            if (!vowels.contains(Character.toString(prevLetter))){ // previous letter isn't a vowel
                newLetters.append(prevLetter);

                if (vowels.contains(Character.toString(curLetter))){ // current letter is a vowel
                    newLetters.append(curLetter);
                }
                else if (prevLetter != ' ' && prevLetter != Character.MIN_VALUE){ // previous letter isn't a space or void
                    newLetters.append('a');
                }
            }
        }

        if (!vowels.contains(Character.toString(curLetter))){
            newLetters.append(curLetter);
            newLetters.append('a');
        }

        return newLetters.toCharArray();
    }

    private static String readFile(String filepath) throws IOException {
        String suffix = ".txt";
        BufferedReader reader = new BufferedReader(new FileReader( filepath + suffix));
        return reader.readLine();
    }

    private static void writeFile(String phrase) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("melival.txt"));
        writer.println(phrase);
        writer.close();
    }

    private static String translate(String input){
        wordLetters = input.toLowerCase().toCharArray();
        //System.out.println("lower char[]: " + new String(wordLetters));

        wordLetters = shortenSequence(wordLetters);
        //System.out.println("rr > r: " + new String(wordLetters));

        wordLetters = keepOneVowel(wordLetters);
        //System.out.println("ae > a: " + new String(wordLetters));

        wordLetters = addVowelToConsonant(wordLetters);
        //System.out.println("r > ra: " + new String(wordLetters));

        wordLetters = convertLetters(wordLetters);
        //System.out.println("r > l, s > k: " + new String(wordLetters));


        // Make the string and remove placeholder letters
        // https://stackoverflow.com/a/7655177 https://stackoverflow.com/a/26688728
        input = String.valueOf(wordLetters).replace(String.valueOf(Character.MIN_VALUE), "");

        return input;
    }

}

/*
    --- Väljund ---

    Sõna on mi
    Tõlge on mi
    ÕIGE!

    Sõna on m
    Tõlge on ma
    ÕIGE!

    Sõna on ria
    Tõlge on li
    ÕIGE!

    Sõna on ss
    Tõlge on ka
    ÕIGE!

    Sõna on llliau
    Tõlge on li
    ÕIGE!

    Sõna on ms
    Tõlge on maka
    ÕIGE!

    Sõna on o
    Tõlge on o
    ÕIGE!

    Sõna on orrlly
    Tõlge on olalaya
    ÕIGE!

    Sõna on aeiumktrptvkmmmmrrllsskknnnnzozozozowowwwwuieioiaaaaaiiiiiklktmprstyywwxxssstprtoi
    Tõlge on amakatalapatavakamalalakakanazozozozowowukalakatamapalakatayawaxakatapalato
    ÕIGE!

    Sõna on aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaiaa
    Tõlge on a
    ÕIGE!

    Sõna on a a a a a a aa ai
    Tõlge on a a a a a a a a
    ÕIGE!

    Sõna on aeiumktrptvkmmmmrrllsskknnnnzozozozowowwwwuieioiaaaaaiiiiiklktmprstyywwxxssstprtoi bahbahbah wowowoww
    Tõlge on amakatalapatavakamalalakakanazozozozowowukalakatamapalakatayawaxakatapalato bahabahabaha wowowowa
    ÕIGE!

    Sõna on kkkkkkkkkk llllllllll rrrrrrrrrr ssssssssss oooooooooo uuuuuuuuuu zzzzzzzzzz
    Tõlge on ka la la ka o u za
    ÕIGE!

    Sõna on rlrlrlrlrlrlrlrlrlrl rlrlrlrlrlrlrlrlrlrl rlrlrlrlrlrlrlrlrlrl rlrlrlrlrlrlrlrlrlrl rlrlrlrlrlrlrl
    Tõlge on lalalalalalalalalalalalalalalalalalalala lalalalalalalalalalalalalalalalalalalala lalalalalalalalalalalalalalalalalalalala lalalalalalalalalalalalalalalalalalalala lalalalalalalalalalalalalala
    ÕIGE!

    Sõna on a b c d e f g h i j k l m n o p q r s t u v w x y z
    Tõlge on a ba ca da e fa ga ha i ja ka la ma na o pa qa la ka ta u va wa xa ya za
    ÕIGE!

    Sõna on qiqyrdccbkaxgfdtbu jjdrvkljtvjlfh lfxpytrlhrmtfcjfhujk uaxkbfiheolyauhbnvcgrtcjapwmlhzqoohqsjtikngmj
    Tõlge on qiqayaladacabakaxagafadatabu jadalavakalajatavajalafaha lafaxapayatalalahalamatafacajafahujaka uxakabafihelayahabanavacagalatacajapawamalahazaqohaqakajatikanagamaja
    ÕIGE!

    Sõna on xbzqzjwjbdjtijph pfstofihrdosuzqcakghcqptrmrmpqwartttdrswoacmxxlnqkkiencsxrshksv iwebx yqxijyxizfyep
    Tõlge on xabazaqazajawajabadajatijapaha pafakatofihaladokuzaqacakagahacaqapatalamalamapaqawalatadalakawocamaxalanaqakinacakaxalakahakakava iwebaxa yaqaxijayaxizafayepa
    ÕIGE!

    Sõna on rqhnmeteymlykbbolxxrkdicsibkbzppmcrvveaveihsqmmz faszvbxocyocw z xvrlapcfojdqwlirzorsweiywh zfwmifvp
    Tõlge on laqahanameteyamalayakabolaxalakadicakibakabazapamacalavevehakaqamaza fakazavabaxocayocawa za xavalalapacafojadaqawalilazolakaweyawaha zafawamifavapa
    ÕIGE!

    Sõna on eixfhqswptkevxbmgchvcbygbkjjzuuzlgdipmk vlxmsukgijuvyvkokliatjpgssbeqycizszgltwifsbxofouhwybfqcyjgdg
    Tõlge on exafahaqakawapatakevaxabamagacahavacabayagabakajazuzalagadipamaka valaxamakukagijuvayavakokalitajapagakabeqayacizakazagalatawifakabaxofohawayabafaqacayajagadaga
    ÕIGE!

    Sõna on zxsziv djamynwsobqeixsbjauibbvxpz uoyykkfaiqpzsyqtuippwppdefowgoi t exhgxzv ifhgdtapzlmznlwrqcbpsraw
    Tõlge on zaxakaziva dajamayanawakobaqexakabajabavaxapaza uyakafaqapazakayaqatupawapadefowago ta exahagaxazava ifahagadatapazalamazanalawalaqacabapakalawa
    ÕIGE!

    Sõna on xnzfqbptkbjbbqbjcmpkgqdbqzfhcomiuvfsmgqymmrghjnorogisqvdvnlfwjefkbldifwoqeqpnhrmi dntvxpevisronnqpfv
    Tõlge on xanazafaqabapatakabajabaqabajacamapakagaqadabaqazafahacomivafakamagaqayamalagahajanologikaqavadavanalafawajefakabaladifawoqeqapanahalami danatavaxapevikalonaqapafava
    ÕIGE!

    Sõna on foablehxfzuugofxoaxdnwjwtzyasynmavsciwrhaoqh lqpdzfnrmvlnyenypr jcvvvkcuppf nitrcocnmplzvqlbbpkrmenz
    Tõlge on fobalehaxafazugofaxoxadanawajawatazayakayanamavakaciwalahaqaha laqapadazafanalamavalanayenayapala jacavakacupafa nitalacocanamapalazavaqalabapakalamenaza
    ÕIGE!

    Sõna on rqlwvzzsyegtiwhsswdrbvcppikecsodhgfbshrw rwaujxailmtevuheewa jpeaqcpshhpoqdvdykrsvravvdrtvr vbkfqtxz
    Tõlge on laqalawavazakayegatiwahakawadalabavacapikecakodahagafabakahalawa lawajaxalamatevuhewa japeqacapakahapoqadavadayakalakavalavadalatavala vabakafaqataxaza
    ÕIGE!

    Sõna on lrjjfxmaauifzoowirannxochdkmitgpnhomcdaaogvsjdvpuqcuamza sexejlqsbmqsebgalkhoyccyjansmtultrqrtookexr
    Tõlge on lalajafaxamafazowilanaxocahadakamitagapanahomacadagavakajadavapuqacumaza kexejalaqakabamaqakebagalakahoyacayajanakamatulatalaqalatokexala
    ÕIGE!

    Sõna on idmjhvdzmcyojvue jlqfrsausyrsuwgovgfxxsnogepcgxktppwweodyvid uoftuipowa auscazckfrtyvwadffeddvkwkysm
    Tõlge on idamajahavadazamacayojavu jalaqafalakakayalakuwagovagafaxakanogepacagaxakatapawedayavida ufatupowa akacazacakafalatayavawadafedavakawakayakama
    ÕIGE!

    Sõna on yvzi ihalxsvbohthqqtyhnvbafgawdrzgioeignyeguxjohhknmcz azfbpqokvqfn tnlwxzybyixgfnebjbgjjjassemasxbi
    Tõlge on yavazi ihalaxakavabohatahaqatayahanavabafagawadalazagiganayeguxajohakanamacaza azafabapaqokavaqafana tanalawaxazayabayixagafanebajabagajakemakaxabi
    ÕIGE!

    Sõna on swm pvfpphnjothelvgp hho ikdxkwphlfwpxmwuhcghrxoauaslbcchgps emxxndgmwzlk txuvkyntysqznybfsmhbmzv u
    Tõlge on kawama pavafapahanajotahelavagapa ho ikadaxakawapahalafawapaxamawuhacagahalaxokalabacahagapaka emaxanadagamawazalaka taxuvakayanatayakaqazanayabafakamahabamazava u
    ÕIGE!

    Sõna on khuc omuvdbneki miygouusmgtnddxuvidinqhhgy qslstpfztwxyleviqlxlrlztwtqdcpkhaeljtg bamskvmcitxxpmgtpm
    Tõlge on kahuca omuvadabaneki miyagokamagatanadaxuvidinaqahagaya qakalakatapafazatawaxayaleviqalaxalalalazatawataqadacapakahalajataga bamakakavamacitaxapamagatapama
    ÕIGE!

    Sõna on cvuzirdpgrvltqbvlgeaqyfimpzicpgxkxxtzsxeywlafe tgpsavln mhn cn b jufzvbngztublfpsijvhuafgmjcbeycbqjs
    Tõlge on cavuziladapagalavalataqabavalageqayafimapazicapagaxakaxatazakaxeyawalafe tagapakavalana mahana cana ba jufazavabanagazatubalafapakijavahufagamajacabeyacabaqajaka
    ÕIGE!

    Sõna on nv glvpwpfgswnqfagq ahtbtybinbtsmtouzvqkiyrwpdjhxiyafervk mcxlapj whncaxrzoggfwjgwxpgcmhmladcygil wg
    Tõlge on nava galavapawapafagakawanaqafagaqa ahatabatayabinabatakamatozavaqakiyalawapadajahaxiyafelavaka macaxalapaja wahanacaxalazogafawajagawaxapagacamahamaladacayagila waga
    ÕIGE!

 */