package ru.job4j.solid;

/**
 * В коде в определении возвращаемого значения метода используется
 * реализация HashSet<String>, а лучше использовать просто Set<String>.
 *
 * public class FullSearch {
 *
 *     public static HashSet<String> extractNumber(List<Task> list) {
 *         HashSet<String> numbers = new HashSet<>();
 *         for (Task task : list) {
 *             numbers.add(task.getNumber());
 *         }
 *         return numbers;
 *     }
 * }
 *
 *  В параметрах метода используется реализация интерфейса ArrayList<UserAction>
 *  вместо использования просто List<UserAction>
 *
 *     private void showMenu(ArrayList<UserAction> actions) {
 *         out.println("Menu.");
 *         int index = 0;
 *         for (UserAction action : actions) {
 *             out.println(index + ". " + action.name());
 *             index++;
 *         }
 *     }
 *
 *  В определении возвращаемого значения метода прописали реализацию интерфейса
 *  ArrayList<Card> вместо использования просто List<Card>
 *
 *    public static ArrayList<Card> generatedCard() {
 *         return Stream.of(Suit.values())
 *                      .flatMap(s -> Stream.of(Value.values())
 *                      .map(v -> new Card(s, v)))
 *                      .collect(Collectors.toList());
 *    }
 *
 *
 *    В классе используется поле с прописанной реализацией и в параметрах конструктора
 *    так же прописана реализация ArrayList<Automobile> правильнее было бы использовать просто
 *    List<Automobile> .
 *
 *    public class SimpleParking implements Parking {
 *
 *     private final int carPlace;
 *     private final int truckPlace;
 *     private ArrayList<Automobile> automobileList;
 *     private int countCars = 0;
 *     private int countTrucks = 0;
 *
 *     public SimpleParking(int carPlace, int truckPlace, ArrayList automobileList) {
 *         this.carPlace = carPlace;
 *         this.truckPlace = truckPlace;
 *         this.automobileList = automobileList;
 *     }
 */

public class DIP {

}
