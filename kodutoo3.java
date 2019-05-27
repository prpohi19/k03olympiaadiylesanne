//https://www.teaduskool.ut.ee/sites/default/files/teaduskool/olympiaad/eesti/eio_2011_12_ev_ylesanded_eesti.pdf
//2. Kaardid 2. lehekülg
class kodutoo3 {
    public static void main(String[] args) {
        int[] esimener = {2, 3};
        int[] teiner = {1, 2, 3};
        int[] kolmasr = {4, 5, 6};
        int summa = 5;
        int saab = 0;
            for (int i = 0; i < teiner.length; i++){
                for (int e = 0; i< kolmasr.length; i++){
                    if (teiner[i]+kolmasr[e] == summa) {
                        System.out.println(teiner[i]);
                        System.out.println(kolmasr[e]);
                        System.out.println(teiner[i]+kolmasr[e]);
                        saab = 1;
                    }
                }//teine for
            }//essa for
        if (saab == 0) {
            System.out.println("ei ole võimalik");
        } else if (saab == 1){
            System.out.println("on võimalik");
        }
    }
}

//int u = 0;
//            for (int i = 0; i < teiner.length - 1; i++) {
//                if (teiner[i] + kolmasr[u] == summa) {
//                    System.out.println("teise ring"+summa);
//                    saab = true;
//                }
//                u++;
//            }
//            int e = 0;
//            for (int i = 0; i < kolmasr.length - 1; i++) {
//                if (kolmasr[i] + teiner[e] == summa) {
//                    System.out.println("kolmanda ring"+summa);
//                    saab = true;
//                }
//                u++;
//            }