import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ActivitySelectionProblem {

	static void activitySelection(List<Activity> activityList) {
		Comparator<Activity> endTimeComparator = new Comparator<Activity>() {

			@Override
			public int compare(Activity o1, Activity o2) {
				return o1.getFinishTime() - o2.getFinishTime();
			}
		};

		Collections.sort(activityList, endTimeComparator);
		Activity previousActivity = activityList.get(0);
		System.out.println("\n\nRecommended Schedule:\n"+activityList.get(0));
		for (int i = 1; i < activityList.size(); i++) {
			Activity activity = activityList.get(i);
			if (activity.getStartTime() >= previousActivity.getFinishTime()) {
				System.out.println("Activity Selected:-" + activity.getName());
				previousActivity = activity;
			}
		}

	}

	public static void main(String args[]) {

		ArrayList<Activity> activityList = new ArrayList<Activity>();

		// Insert activities in Arraylist
		activityList.add(new Activity("A1", 0, 6));
		activityList.add(new Activity("A2", 3, 4));
		activityList.add(new Activity("A3", 1, 2));
		activityList.add(new Activity("A4", 5, 8));
		activityList.add(new Activity("A5", 5, 7));
		activityList.add(new Activity("A6", 8, 9));

		// Print user entered data
		System.out.println("User provided Schedule:");
		for (int i = 0; i < activityList.size(); i++) {
			Activity activity = activityList.get(i);
			System.out.println(activity.toString());
		}

		// Perform calculation on activities
		activitySelection(activityList);

	}

}
