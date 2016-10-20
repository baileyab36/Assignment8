// Assignment #: 8
//         Name: Bailey Bowman
//    StudentID: 1208740698
//      Lecture: 2:00 MWF
//  Description: The Medal comparator is a helper class that is used by the athlete management class
//               when it needs to use the Sorts class.
//               If the first athlete has a higher medal count than the second it will return a negative number,
//               or vice versa a positive.
//               It first compares gold, then silver if the gold count is the same, and then also bronze.
//               If they have same number of medals for all types, it will return 0.

/*
If the first argument object has a larger gold medal count than that of the second argument,
an int less than zero is returned.
If the first argument object has a smaller gold medal count than that of the second argument,
an int greater than zero is returned.
If both gold medal counts are same, then their silver medal counts should be compared.
If both gold medal counts are same and also silver medal counts are same, then their bronze counts should be compared.
If all of gold, silver, and bronze medal counts are same, then 0 should be returned.
 */

import java.util.Comparator;

public class MedalCountComparator implements Comparator<Athlete> {

    public int compare(Athlete one, Athlete two) {
        int difference;

        //return two's golds minus one's golds
        difference = two.getGold() - one.getGold();
        if (difference == 0) {
            // if they have the same amount of golds, compare silver
            difference = two.getSilver() - one.getSilver();
            if (difference == 0)
                //if same amount of both silver and gold, compare bronze
                difference = two.getBronze() - one.getBronze();
        }

        //if difference = 0, they have the same amount of each type of medal.
        return difference;
    }

}
