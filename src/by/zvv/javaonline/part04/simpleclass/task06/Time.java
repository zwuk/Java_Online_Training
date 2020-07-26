package by.zvv.javaonline.part04.simpleclass.task06;

/* Составьте описание класса для представления времени. Предусмотрите возможность установки времени и 
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. 
 * В случае недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения 
 * времени на заданное количество часов, минут и секунд.
 */
public class Time {
	private int hours;
	private int minutes;
	private int seconds;
	private int timeInSeconds;

	public static final int SECONDS_IN_DAY = 86400;
	public static final int HOURS_IN_DAY = 24;
	public static final int MINUTES_IN_HOUR = 60;
	public static final int SECONDS_IN_MINUTE = 60;

	public Time() {
		hours = 0;
		minutes = 0;
		seconds = 0;
		timeInSeconds = 0;
	}

	public Time(int timeInSeconds) {
		setTime(timeInSeconds);
	}

	public Time(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		checkTime();
	}
	
	// Метод проверки допустимости значений, в случае недопустимых значений полей поле устанавливается в значение 0.
	private void checkTime() {
		hours = (hours < 0 || hours >= HOURS_IN_DAY) ? 0 : hours;
		minutes = (minutes < 0 || minutes >= MINUTES_IN_HOUR) ? 0 : minutes;
		seconds = (seconds < 0 || seconds >= SECONDS_IN_MINUTE) ? 0 : seconds;
		timeInSeconds = hours * MINUTES_IN_HOUR * SECONDS_IN_MINUTE + minutes * SECONDS_IN_MINUTE + seconds;
	}

	// Метод перевода времени в секундах - в часы, минуты и секунды. Если время больше суток, то сутки отсекаются.
	// Если время отрицательное, то отсчет идет в обратную сторону
	public void setTime(int time) {
		time = (time < 0) ? SECONDS_IN_DAY + time % SECONDS_IN_DAY : time;
		timeInSeconds = (time < SECONDS_IN_DAY) ? time : time % SECONDS_IN_DAY;
		int temp = timeInSeconds;
		hours = (int) Math.floor(temp / (MINUTES_IN_HOUR * SECONDS_IN_MINUTE));
		temp -= hours * MINUTES_IN_HOUR * SECONDS_IN_MINUTE;
		minutes = (int) Math.floor(temp / MINUTES_IN_HOUR);
		seconds = temp - minutes * SECONDS_IN_MINUTE;
	}

	public void addHours(int hours) {
		int currentTime = getTimeInSeconds();
		hours = hours * MINUTES_IN_HOUR * SECONDS_IN_MINUTE;
		currentTime += hours;
		setTime(currentTime);
	}

	public void addMinutes(int minutes) {
		int currentTime = getTimeInSeconds();
		minutes *= SECONDS_IN_MINUTE;
		currentTime += minutes;
		setTime(currentTime);
	}

	public void addSeconds(int seconds) {
		int currentTime = getTimeInSeconds();
		currentTime += seconds;
		setTime(currentTime);
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
		checkTime();
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
		checkTime();
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
		checkTime();
	}

	public int getTimeInSeconds() {
		return timeInSeconds;
	}

	@Override
	public String toString() {
		return "Time: " + hours + " hours " + minutes + " minutes " + seconds + " seconds\ttimeInSeconds = "
				+ timeInSeconds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hours;
		result = prime * result + minutes;
		result = prime * result + seconds;
		result = prime * result + timeInSeconds;
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
		Time other = (Time) obj;
		if (hours != other.hours)
			return false;
		if (minutes != other.minutes)
			return false;
		if (seconds != other.seconds)
			return false;
		if (timeInSeconds != other.timeInSeconds)
			return false;
		return true;
	}

}
