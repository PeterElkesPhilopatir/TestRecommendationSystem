import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        ArrayList<Float> ratings = new ArrayList<>();
        ArrayList<Float> prices = new ArrayList<>();

        items.add(new Item("iphone 8+", 1, 3, 7, 800));
        items.add(new Item("Lenovo y520", 2, 22, 8, 1200));
        items.add(new Item("iphone X", 1, 1, 8, 1000));
        items.add(new Item("gas cook", 4, 8, 6, 400));
        items.add(new Item("shirt", 10, 12, 8, 20));

        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            Random random1 = new Random();
            items.add(new Item("", 1, 1, random.nextInt(10) + 1, random1.nextInt(10) + 1));
        }

        for (Item item : items) {
            names.add(item.getName());
            ratings.add(item.getRating());
            prices.add(item.getPrice());
        }

        float avgPrice = calculateAVG(prices);
        System.out.println("prices average: " + avgPrice);

        float avgRate = calculateAVG(ratings);
        System.out.println("ratings average: " + avgRate);

//        System.out.println(names);


        float sim = getSimilarity2F(items.get(0), items.get(0), avgRate, avgPrice);
        System.out.println("(Function) similarity between 0 and 0 items : " + sim + "%");

        ArrayList<Float> simis = new ArrayList<>();
        simis = getAllSimilaritiesForOneItem(items, items.get(0), avgRate, avgPrice);

//        System.out.println("Simis0" + simis);

        HashMap<Item, ArrayList<Float>> matrix = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            matrix.put(items.get(i), getAllSimilaritiesForOneItem(items, items.get(i), avgRate, avgPrice));
        }
        for (int i = 0; i < matrix.size(); i++) {

            System.out.println(matrix.get(items.get(i)));
        }
    }

    public static float calculateAVG(ArrayList<Float> array) {
        float x, y;
        x = 0f;
        y = array.size();
        for (float i : array) {
            x += i;
        }
//        System.out.println(x);

        return x / y;
    }

    public static float getSimilarity2F(Item item1, Item item2, float avgR, float avgP) {

        float f1i1 = item1.getRating() - avgR;
        float f1i2 = item2.getRating() - avgR;

        float f2i1 = item1.getPrice() - avgP;
        float f2i2 = item2.getPrice() - avgP;

        float numerator = 0, denominator = 0;
        numerator += f1i1 * f1i2;
        numerator += f2i1 * f2i2;


        denominator += Math.sqrt(Math.pow(f1i1, 2) + Math.pow(f2i1, 2));
        denominator *= Math.sqrt(Math.pow(f1i2, 2) + Math.pow(f2i2, 2));


        return (numerator / denominator) * 100;
    }

    public static ArrayList<Float> getAllSimilaritiesForOneItem(ArrayList<Item> items, Item item, float avgR, float avgP) {
        ArrayList<Float> similarties = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            float s = getSimilarity2F(item, items.get(i), avgR, avgP);
            similarties.add(s);

        }
        return similarties;
    }


}

