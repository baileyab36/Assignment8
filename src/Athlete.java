// Assignment #: 8
//         Name: Bailey Bowman
//    StudentID: 1208740698
//      Lecture: 2:00 MWF
//  Description: The class Athlete represents an athlete with
//               their information.
import java.io.*;

public class Athlete implements Serializable
{
    private String firstName, lastName;
    private String sport;
    private int gold, silver, bronze;

    //Constructor to initialize all member variables
    public Athlete()
    {
        firstName = "?";
        lastName = "?";
        sport = "?";
        gold = 0;
        silver = 0;
        bronze = 0;
    }

    //Accessor methods
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getSport()
    {
        return sport;
    }

    public int getGold()
    {
        return gold;
    }

    public int getSilver()
    {
        return silver;
    }

    public int getBronze()
    {
        return bronze;
    }


    //Mutator methods
    public void setFirstName(String first)
    {
        firstName = first;
    }

    public void setLastName(String last)
    {
        lastName = last;
    }

    public void setSport(String someSport)
    {
        sport = someSport;
    }

    public void setGold(int count)
    {
        gold = count;
    }

    public void setSilver(int count)
    {
        silver = count;
    }

    public void setBronze(int count)
    {
        bronze = count;
    }


    //toString() method returns a string containing information of an athlete
    public String toString()
    {
        String result = "Name:\t" + lastName + "," + firstName + "\n"
                + "Sport:\t" + sport + "\n"
                + "Medal Count:\n"
                + "Gold: " + gold + "\n"
                + "Silver: " + silver + "\n"
                + "Bronze: " + bronze + "\n\n";
        return result;
    }
}