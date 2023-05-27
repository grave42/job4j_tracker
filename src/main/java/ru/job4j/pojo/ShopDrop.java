package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            if (i == index) {
                products[i] = null;
            } else if (i > index) {
                products[i - 1] = products[i];
                products[i] = null;
            }
            System.out.println();
        }

        return products;
    }
}