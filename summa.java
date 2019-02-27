//Kert Liinat
import java.io.*;
import java.util.*;


public class summa{

  public static void main(String[] args) throws Exception{
      BufferedReader lugeja = new BufferedReader(new FileReader("summasis.txt"));
      BufferedWriter kirjutaja = new BufferedWriter(new FileWriter("summaval.txt"));
      List<String> arvud = new ArrayList<String>();
      String rida = lugeja.readLine();


      while(rida != null){
          arvud.add(rida);
          rida = lugeja.readLine();
          /*for (String temp: array1){
	           System.out.println(temp);
	        }*/
      }
      String str = arvud.get(0);
      String array1[] = str.split(" ");
      Integer mituArvu = Integer.valueOf(array1[0]);
      Integer arvudeSumma = Integer.valueOf(array1[1]);
      List<Integer> sobivad = new ArrayList<Integer>();
      List<Integer> unikaalsed = new ArrayList<Integer>();


      for(int i = 0; i < mituArvu; i++){
        arvud.get(i+1);
        //System.out.println(i+1+" "+arvud.get(i+1));
        for(int j = 0; j < mituArvu; j++){
          //int arv = Integer.valueOf(arvud.get());
          if(Integer.valueOf(arvud.get(i+1)) + Integer.valueOf(arvud.get(j+1)) == arvudeSumma && i != j){
            sobivad.add(Integer.valueOf(arvud.get(i+1)));
            sobivad.add(Integer.valueOf(arvud.get(j+1)));
            //Set<Integer> paarid = new HashSet<Integer>(sobivad);
            for (int x : sobivad){
              if (!unikaalsed.contains(x)){
                unikaalsed.add(x);

              }
            }

            }
          }
        }
        int paarideArv = unikaalsed.size() / 2;
        //System.out.println(unikaalsed.size() / 2);
        System.out.println(paarideArv);
        System.out.println(unikaalsed);
        kirjutaja.write(String.valueOf(paarideArv));
        kirjutaja.close();
      }



  }
