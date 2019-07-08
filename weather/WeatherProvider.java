package weather;

import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather= { "SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {
	}
	
	public static WeatherProvider	getProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}
	
	public String getCurrentWeather(Coordinates coordinates) {
		Random rand = new Random();
		
		int randWeather = rand.nextInt(4);
		return weather[randWeather];
	}
}
