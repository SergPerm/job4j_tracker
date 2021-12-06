package ru.job4j.solid;

/** пример 1
 * класс обработки заказа:
 * - проверяет заказ
 * - сохраняет заказ
 * - отправляет уведомление заказчику
 * - и при этом еще и создаёт новое соединение с БД
 *
 public class OrderProcessor {

    public void process(Order order) {
        if (order.isValid() && save(order)) {
        sendConfirmationEmail(order);
    }
 }

 // сохраняем заказ в базу данных
 private boolean save(Order order) {
    MySqlConnection connection = new MySqlConnection("database.url");
 return true;
 }

 // Шлем письмо клиенту
 private void sendConfirmationEmail(Order order) {
 String name = order.getCustomerName();
 String email = order.getCustomerEmail();
 }
 }
 * для исправления нужно вынести методы save() и sendConfirmationEmail() в интерфейсы
 * реализовать от них классы и уже их использовать
 *
 * пример 2
 * public class People{
 *     People(String name){}
 *     public String getName(){}
 *     public boolean saveBD(People p){}
 * }
 * класс совершает разную работу создаёт и сохраняет в БД,
 * нужно разделить на два класса в одном создаём в другом сохраняем
 *
 * пример 3
 *
 * public class Grabber implements Grab {
 *     private final Properties cfg = new Properties();
 *
 *     public Store store() {
 *         return new PsqlStore(cfg);
 *     }
 *
 *     public Parse parse() {
 *         return new SqlRuParse(new SqlRuDateTimeParser());
 *     }
 *
 *     в данной части кода мы в классе в методах создаем новые объекты
 *     лучше получать их извне через конструктор или в методе init()
 */
public class SRP {

}
