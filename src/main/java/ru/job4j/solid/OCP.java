package ru.job4j.solid;

/**
 *     Пример 1. метод проверяет строки на идентичность, использует regex в методе split()
 *     его можно вынести в параметры метода, чтобы в дальнейшем иметь возможность сравнивать строки
 *     с различными разделителями.
 *
 *     public static boolean isEquals(String originText, String duplicateText) {
 *         boolean rsl = true;
 *         String[] origin = originText.split(" ");
 *         String[] text = duplicateText.split(" ");
 *         HashSet<String> check = new HashSet<>();
 *         for (String word : origin) {
 *             check.add(word);
 *         }
 *         for (String word : text) {
 *             if (!check.contains(word)) {
 *                 rsl = false;
 *                 break;
 *             }
 *         }
 *         return rsl;
 *
 *     Пример 2. часть кода использует реализацию интерфейса Iterator в виде класса
 *     LuckyIterator, но правильнее было бы использовать сам интерфейс Iterator и реализацию
 *     в виде new LuckyIterator().
 *
 *         LuckyIterator iterator = new LuckyIterator();
 *         while (iterator.hasNext()){
 *             Lucky next = iterator.next();
 *             if (next.isLucky()){
 *                 count++;
 *                 System.out.println(next);
 *             }
 *         }
 *
 *     Пример 3. возможно вынести имя файла для сохранения результатов "result.txt" в
 *     private поле и инициировать его в конструкторе, тогда мы сможем гибче реагировать на
 *     изменения места сохранения
 *
 *   public class MultiplicationTable {
 *
 *     public static int[][] multiple(int size) {
 *         int[][] table = new int[size][size];
 *         try (FileOutputStream out = new FileOutputStream("result.txt")) {
 *             for (int i = 0; i < size; i++) {
 *                 for (int j = 0; j < size; j++) {
 *                     table[i][j] = (i + 1) * (j + 1);
 *                     out.write(("" + table[i][j] + " ").getBytes());
 *                 }
 *                 out.write(System.lineSeparator().getBytes());
 *             }
 *         } catch (Exception e) {
 *             e.printStackTrace();
 *         }
 *         return table;
 *     }
 */

public class OCP {

}
