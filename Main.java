public class Main {

    public static String highest(SalesPerson[] salesPeople) {
        double maxSales = 0;
        String highestSellerId = null;

        for(SalesPerson salesPerson : salesPeople) {
            if (salesPerson != null) {
                double totalSales = salesPerson.calcTotalSales();
                if(totalSales > maxSales) {
                    maxSales = totalSales;
                    highestSellerId = salesPerson.getId();
                }
            }
        }

        return highestSellerId;
    }
    public static void addSales(Sales s, String id, SalesPerson[] salesPeople) {
        for (SalesPerson salesPerson : salesPeople) {
            if (salesPerson != null && salesPerson.getId().equals(id)) {
                salesPerson.setSalesHistory(s);
                break;
            }
        }
    }



    public static void main(String[] args) {

        SalesPerson[] salesPeople = new SalesPerson[6];
        salesPeople[0] = new SalesPerson("100");
        salesPeople[1] = new SalesPerson("101");
        salesPeople[2] = new SalesPerson("102");
        salesPeople[0].setSalesHistory(new Sales("A100", 300.00, 10));
        salesPeople[0].setSalesHistory(new Sales("A200", 1000.00, 2));
        salesPeople[1].setSalesHistory(new Sales("A300", 2550.40, 10));
        System.out.println(salesPeople[2].getId());
        System.out.println(salesPeople[0].getCount());
        System.out.println(salesPeople[1].getSalesHistory()[0].getValue());
        System.out.println(salesPeople[0].calcTotalSales());
        addSales(new Sales("A100", 500.00, 10), "100", salesPeople);

        String highestSellerId = highest(salesPeople);
        System.out.println(highestSellerId);
    }

}