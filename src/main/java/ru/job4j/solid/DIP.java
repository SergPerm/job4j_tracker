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
 *
 *     Класс использует переменную List<Employee> employees для хранения списка работников.
 *     Этот вариант жёстко привязан к данной реализации. и это ошибка.
 *
 *     public class ReportEngine implements Report {
 *          private final List<Employee> employees = new ArrayList<>();
 *
 *     Вместо этого через интерфейс Store и реализующий его класс MemStore мы уходим от
 *     прямой связи, а необходимый вариант хранилища мы получаем через конструктор.
 *
 *     public class ReportEngine implements Report {
 *
 *          private final Store store;
 *
 *          public ReportEngine(Store store) {
 *              this.store = store;
 *           }
 *     }
 *
 *     public class MemStore implements Store {
 *
 *          private final List<Employee> employees = new ArrayList<>();
 *     }
 */

public class DIP {

}
