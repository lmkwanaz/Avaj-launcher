package aircrafts;

import weather.Coordinates;
import weather.WeatherTower;
import weather.WriteFile;

public class Baloon extends Aircraft implements Flyable {
public WeatherTower weatherTower = new WeatherTower();
	
	Baloon(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	
	public void updateConditions(){
		String weather = weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
				this.coordinates.setHeight(this.coordinates.getHeight() + 4);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setHeight(100);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): It's sunny today!");
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): am scared of lightning, it's raining");
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 3);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): it's foggy am scared!!!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 15);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): i wish i could land its freezing up here");
			break;
			default:
			WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): wheather is not responding!");
			break;
		}
		if (this.coordinates.getHeight() <= 0) {
			WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + ") landing.");
			WriteFile.getWriteFile().writetofile("Tower  says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
	}
	
	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
		
	}


}
