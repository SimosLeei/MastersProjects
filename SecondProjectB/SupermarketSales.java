

public class SupermarketSales {
    double[][] sales;
    int Katastismata;
    int Products;

    public SupermarketSales(double[][] sales){
        for(int i=0; i<sales.length; i++){
            for(int j=0; j<sales[0].length;j++){
                if(sales[i][j]<0) {
                    System.exit(89);
                }

            }
        }
        this.sales = sales;
        this.Katastismata= sales.length;
        this.Products = sales[0].length;

    }

    public void getKatastimataSales() {
        for(int i=0; i<sales.length; i++){
            double sum = 0;
            for(int j=0; j<sales[i].length;j++) {
                sum = sum +sales[i][j];
            }
            System.out.print("---> The sum of the sales in the store no " + (i) +" , is " + sum +"\n");
        }

    }

    public void getProductSales() {
        for(int i=0; i<sales[0].length; i++){
            double sum = 0;
            double average = 0;
            for(int j=0; j<sales.length; j++) {
                sum += sales[j][i];

            }
            average = sum/sales.length;
            System.out.print("\n---> The sales of the product no " + (i) +" is: " + sum +"\n" +
                    "and the average sales per Store is: " +average +"\n ");
        }

    }

    public void geSupermarketSales() {
        double sumStores = 0;
        double average = 0;
        for(int i=0; i<sales.length; i++){


            for(int j=0; j<sales[0].length; j++) {

                sumStores += sales [i][j];

            }

        }
        average = sumStores/sales.length;
        System.out.print("\n---> The total income of all the Supermarket Stores is: " + sumStores +"\n" +
                "and the average income per Store is: " +average +"\n ");

    }
}
