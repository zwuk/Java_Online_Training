package by.zvv.javaonline.part04.simpleclass.task05;

import java.util.Arrays;

/* Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу в заданном диапазоне. 
 * Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, 
 * и метод позволяющий получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 * 
 * Счетчик работает по кругу: в случае увеличения при переполнении отсчет начинается с минимального значения. 
 * В обратную сторону - аналогично, при достижении минимума текущее значение принимает максимум и т.д.
 * При установке текущего значения счетчика вне диапазона, значение принимает максимум или минимум диапазона, в зависимости от
 * того, с какой стороны диапазона выбрано значение. Аналогично с установкой минимального и максимального значений диапазона.
 */
public class DecimalСounter {
	private int maximum;
	private int minimum;
	private int current;

	public DecimalСounter() {
		this.minimum = 0;
		this.maximum = 100;
		this.current = 50;
	}

	public DecimalСounter(int a, int b, int c) {
		int[] arr = { a, b, c };
		Arrays.sort(arr);
		this.minimum = arr[0];
		this.current = arr[1];
		this.maximum = arr[2];

	}

	public void incrementCounter() {
		current++;
		if (current > maximum) {
			current = minimum;
		}
	}

	public void decrementCounter() {
		current--;
		if (current < minimum) {
			current = maximum;
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [minimum=" + minimum + ", maximum=" + maximum + ", current=" + current + "]";
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = (maximum < this.current) ? current : maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = (minimum > this.current) ? current : minimum;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		if (current > this.maximum) {
			this.current = this.maximum;
		} else if (current < this.minimum) {
			this.current = this.minimum;
		} else {
			this.current = current;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + current;
		result = prime * result + maximum;
		result = prime * result + minimum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DecimalСounter other = (DecimalСounter) obj;
		if (current != other.current)
			return false;
		if (maximum != other.maximum)
			return false;
		if (minimum != other.minimum)
			return false;
		return true;
	}

}
