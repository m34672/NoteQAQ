package ArraySum;

import java.util.ArrayList;
import java.util.List;

class JavaExample {

    public static void main(String[] args) {
        /*
         * 練習 1 : 計算 luxury 裡 price 的總和
         * 條件 : 請使用一行程式
         * 提示 : map , reduce
         */
        // [
        // { brand: 'LV', price: 43211 },
        // { brand: 'GUCCI', price: 56566 },
        // { brand: 'HERMES', price: 223378 },
        // ];

        List<Luxury> list = new ArrayList<>();
        list.add(new Luxury("LV", 43211));
        list.add(new Luxury("GUCCI", 56566));
        list.add(new Luxury("HERMES", 223378));

        Integer luxury = list.stream().map(Luxury::getPrice).reduce(Integer::sum).get();
        System.out.println(luxury); // 323155
    }

}

class Luxury {
    String brand;
    Integer price;

    Luxury(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getPrice() {
        return price;
    }
}