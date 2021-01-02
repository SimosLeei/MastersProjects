

public class MainProgramSupermarket {
    public static void main(String[] args) {
        double[][] sales = {{12502.5,2506.75,8088.33,1289.55},{10085.65,1505.85,5800.65, 1184.55},{19258, 1158.57, 9871.22, 1289.78}};
        SupermarketSales sp = new SupermarketSales(sales);
        sp.getKatastimataSales();
        sp.getProductSales();
        sp.geSupermarketSales();


    }
}
