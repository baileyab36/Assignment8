// Assignment #: 8
//         Name: Bailey Bowman
//    StudentID: 1208740698
//      Lecture: 2:00 MWF
//  Description: The Name comparator is a helper class that is used by the athlete management class
//               when it needs to use the Sorts class.
//               If the first athlete has a higher name than the second it will return a negative number, or vice versa a positive.
//               If their last names are same, then their first names should be compared.
//               If they have same first and last names, then 0 should be returned.


import java.util.Comparator;

public class AthleteNameComparator implements Comparator<Athlete> {
    public int compare(Athlete one, Athlete two) {
        int difference;
        String oneFirst, oneLast, twoFirst, twoLast;

        oneFirst = one.getFirstName();
        oneLast = one.getLastName();
        twoFirst = two.getFirstName();
        twoLast = two.getLastName();

        //If the first argument object has a name lexicographically less than that of the second argument,
        //an int less than zero is returned.
        //If the first argument object has a name lexicographically larger than that of the second argument,
        //an int greater than zero is returned.
        difference = oneLast.compareTo(twoLast);
        if (difference == 0) {
            difference = oneFirst.compareTo(twoFirst);
        }

        return difference;
    }

}
