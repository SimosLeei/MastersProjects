public class MainProgram4 {

    public static void main(String[] args) {

        double[][] salesAthens = {{12502.5,2506.75,8088.33,1289.55},{10085.65,1505.85,5800.65, 1184.55},{19258, 1158.57, 9871.22, 1289.78},{125.5,25.5,80,12.5},{10.5,10.5,10.5, 10.5},{1, 11, 22, 33}};
        double[][] salesIoannina = {{125.5,25.5,80,12.5},{10.5,10.5,10.5, 10.5},{1, 11, 22, 33}};
        SupermarketSalesToFile.setSupermarketname("sklavenitis");
        SupermarketSalesToFile athens  = new SupermarketSalesToFile(salesAthens);
        athens.setPoli("Athens");
        athens.getKatastimataSales();
        SupermarketSalesToFile.setSupermarketname("Papageorgiou");
        SupermarketSalesToFile ioannina  = new SupermarketSalesToFile(salesIoannina);
        ioannina.setPoli("Ioannina");
        ioannina.getKatastimataSales();
    }

}
