import java.util.ArrayList;
import java.util.Comparator;

// Assignment #: 8
//         Name: Bailey Bowman
//    StudentID: 1208740698
//      Lecture: 2:00 MWF
//  Description: The Sorts class is a utility class that will be used to sort a list of Athlete objects by the insertion method.


public class Sorts {
    public static ArrayList<Athlete> sort(ArrayList<Athlete> list, Comparator<Athlete> comparator) {

        //iterate up through array
        for (int i = 1; i < list.size(); i++) {
            Athlete biggerAthlete = list.get(i);
            int position = i;

            //while list.get(position) is bigger or equal to the one before it
            //move position down through array to determine where the key should go
            while (position > 0 && comparator.compare(list.get(position - 1), biggerAthlete) >= 0) {
                //move up the next Athlete
                Athlete smallerAthlete = list.get(position - 1);
                list.set(position, smallerAthlete);
                position--;
            }
            //once the space is determined, stick the key in
            //if position = i still, then it nothing changed.
            list.set(position, biggerAthlete);


        }
        return list;
    }
}
