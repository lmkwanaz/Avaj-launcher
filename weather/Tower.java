package weather;

import java.util.ArrayList;

import aircrafts.Flyable;
import java.util.List;

public class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();
	private List<Flyable> unregister = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (observers.contains(flyable)) {
			return ;
		}
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		if(unregister.contains(flyable))
			return;
		unregister.add(flyable);
		
	}
	
	protected void	conditionsChanged() {
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
		observers.removeAll(unregister);
	}
}
