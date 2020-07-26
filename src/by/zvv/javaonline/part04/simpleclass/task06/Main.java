package by.zvv.javaonline.part04.simpleclass.task06;

/* Составьте описание класса для представления времени. Предусмотрите возможность установки времени и 
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. 
 * В случае недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения 
 * времени на заданное количество часов, минут и секунд.
 */
public class Main {

	public static void main(String[] args) {

		Time time1 = new Time();
		Time time2 = new Time(183901);
		Time time3 = new Time(11101);
		Time time4 = new Time(23, 65, 28);

		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
		time3.addHours(145); // 145 часов = 6 суток + 1 час
		System.out.println(time3);
		time3.addMinutes(-1441); // 1441 минута = 24 часа + 1 минута
		System.out.println(time3);
		System.out.println(time4);
		time4.setHours(11);
		time4.setMinutes(1);
		time4.setSeconds(-23);
		System.out.println(time4);
		System.out.println(new Time(-86401));
		System.out.println(new Time(12, 48, 16));

	}

}
