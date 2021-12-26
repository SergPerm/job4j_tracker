package ru.job4j.solid;

/**
 *
 *  В имеющемся интерфейсе Check мы проверяем некое условие,
 *  класс Verificatiion реализует проверку адекватно, а класс Verification2
 *  при некотором условии бросает исключение, которое не ожидает
 *  пользователь интерфейса и чем может вызвать сбой в работе приложения
 *
 *     interface Check {
 *         boolean checking();
 *     }
 *
 *     public class Verificatiion implements Check {
 *
 *         @Override
 *         public boolean cheking() {
 *             if (condition1) {
 *                 return true;
 *             } else {
 *                 return false;
 *             }
 *         }
 *     }
 *
 *     public class Verification2 implements Check {
 *
 *         @Override
 *         public boolean cheking() {
 *             if (condition2) {
 *                 return true;
 *             } else if (condition 3) {
 *                 throw new Exception();
 *             } else {
 *                 return false;
 *             }
 *         }
 *     }
 *
 * в классе-Родителе есть метод определяющий возможность выполнить действие
 * в зависимости от условий, а в классе-наследнике этот метод ужесточён допусловием
 * и при использовании в контексте приложения данного метода наши ожидания
 * не оправдаются, что приведет к сбою в работе
 *
 *     public class Drill {
 *          boolean canDrill(Material mat) {
 *               if (mat.isMetall()) return true;
 *              else return false;
 *          }
 *      }
 *
 *      public class SmallDrill extends Drill {
 *          @Override
 *          boolean canDrill(Material mat) {
 *                 if (mat.isMetall() && mat.isLight()) return true;
 *              else return false;
 *          }
 *      }
 *
 * в классе-Родителе есть метод определяющий валидность вводимого параметра,
 * а в классе-наследнике при использовании метода забыли проверить валидность
 * данного параметра, что может привести к сбою в работе приложения.
 *
 *     public class Drill {
 *          private int speedDrill;
 *
 *          boolean validSpeedDrill(int speed) {
 *               if (speed > 0 && speed <= 500) return true;
 *              else return false;
 *          }
 *
 *          void setSpeedDrill (int speedDrill)
 *              if (validSpeedDrill(speedDrill) {
 *                  this.speedDrill = speedDrill;
 *              } else
 *      }
 *
 *      public class SmallDrill extends Drill {
 *          @Override
 *          void setSpeedDrill (int speedDrill)
 *               this.speedDrill = speedDrill;
 *          }
 *      }
 *
 */
public class LSP {
}
