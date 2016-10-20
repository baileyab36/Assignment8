// Assignment #: 8
//         Name: Bailey Bowman
//    StudentID: 1208740698
//      Lecture: 2:00 MWF
//  Description: The athlete management class is a fully encapsulated object that
//               stores, organizes, and manages the data that is input at the driver class.
//               It takes no user input, and is used only by the driver.


//The athlete management system will be a fully encapsulated object.

import java.io.Serializable;
import java.util.ArrayList;

public class AthleteManagement implements Serializable {
    private ArrayList<Athlete> list;

    // The ArrayLists/Vectors of athleteList is instantiated.
    public AthleteManagement() {
        list = new ArrayList<>();
    }

    // Search for a Athlete object by first name and last name, and return the index of the object if found.
    // Return -1 if not found. The parameter is the first and last names of a Athlete object.
    public int athleteNameExists(String firstName, String lastName) {
        int index = -1;
        boolean firstEqual;
        boolean lastEqual;

        //no two athletes have the same name
        for (Athlete a : list) {
            firstEqual = a.getFirstName().equals(firstName);
            lastEqual = a.getLastName().equals(lastName);
            if (firstEqual && lastEqual) {
                index = list.indexOf(a);
            }
        }

        return index;
    }

    // Search and for Athlete objects in the athlete list that have a medal of the type specify by the parameter,
    // 0 for gold, 1 for silver, and 2 for bronze.
    // Then it returns the count.
    // If there is no such athlete, it will return 0.
    public int countHowManyAthletesHaveMedals(int medalType) {
        int total = 0;

        for (Athlete a : list) {
            switch (medalType) {
                case 0:
                    if (a.getGold() > 0)
                        total++;
                    break;
                case 1:
                    if (a.getSilver() > 0)
                        total++;
                    break;
                case 2:
                    if (a.getBronze() > 0)
                        total++;
                    break;
            }
        }

        return total;
    }

    // Add a Athlete object to the athlete list.
    // Return true if such object was added successfully.
    // Return false if an object with the same first name and last name already exists (the new object is not added).
    public boolean addAthlete(String firstName, String lastName, String sport, int gold, int silver, int bronze) {
        boolean added;
        boolean exists = athleteNameExists(firstName, lastName) == -1;

        if (exists) {
            Athlete athlete = new Athlete();
            athlete.setFirstName(firstName);
            athlete.setLastName(lastName);
            athlete.setSport(sport);
            athlete.setGold(gold);
            athlete.setSilver(silver);
            athlete.setBronze(bronze);
            list.add(athlete);
            added = true;
        } else {
            added = false;
        }

        return added;
    }


    // Remove a Athlete object from the athlete list.
    // Return true if the object was removed successfully.
    // Return false if the object with the given first name and last name does not exist.
    public boolean removeAthleteByName(String firstName, String lastName) {
        boolean removed;
        int index = athleteNameExists(firstName, lastName);

        if (index == -1) {
            removed = false;
        } else {
            list.remove(index);
            removed = true;
        }

        return removed;
    }

    // Sort the list of Athlete objects by first and last names.
    // This method calls the sort method defined in the Sorts class,
    // using an object of AthleteNameComparator class as its second parameter.
    public void sortByAthleteNames() {
        AthleteNameComparator comparator = new AthleteNameComparator();
        Sorts.sort(list, comparator);
    }


    // Sort the list of Athlete objects by medal counts (compare gold first, then silver, then bronze).
    // This method calls the sort method defined in the Sorts class,
    // using an object of MedalCountComparator class as its second parameter.
    public void sortByMedalCounts() {
        MedalCountComparator comparator = new MedalCountComparator();
        list = Sorts.sort(list, comparator);
    }


    // List all Athlete objects in the athlete list.
    // Returns "no athlete" if list is empty.
    public String listAthletes() {
        String str = "";

        if (list.size() == 0) {
            str = "no athlete\n";
        } else {
            for (Athlete a : list) {
                str += a.toString();
            }
        }

        return str;
    }


    // Closes the athlete management system by making the list empty.
    public void closeAthleteManagement() {
        list.clear();
    }


}
