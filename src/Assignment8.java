// Assignment #: 8
//         Name: Bailey Bowman
//    StudentID: 1208740698
//      Lecture: 2:00 MWF
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;

public class Assignment8 {

    public static void main(String[] args) {
        char input1;
        String firstName, lastName, sport;
        int gold, silver, bronze;
        boolean operation;
        int operation2;
        String line;
        String fileName = null;

        // create a AthleteManagement object. This is used throughout this class.
        AthleteManagement athleteManagement = new AthleteManagement();

        try {
            // print out the menu
            printMenu();

            // create a BufferedReader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("What action would you like to perform?\n");
                line = stdin.readLine().trim();  //read a line
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);

                if (line.length() == 1)          //check if a user entered only one character
                {
                    switch (input1) {
                        case 'A':   //Add Athlete
                            try {
                                System.out.print("Please enter the following information of an athlete:\n");
                                System.out.print("First Name:\n");
                                firstName = stdin.readLine().trim();
                                System.out.print("Last Name:\n");
                                lastName = stdin.readLine().trim();
                                System.out.print("Sport:\n");
                                sport = stdin.readLine().trim();
                                System.out.print("The number of gold medals\n");
                                gold = Integer.parseInt(stdin.readLine().trim());
                                System.out.print("The number of silver medals\n");
                                silver = Integer.parseInt(stdin.readLine().trim());
                                System.out.print("The number of bronze medals\n");
                                bronze = Integer.parseInt(stdin.readLine().trim());

                                operation = athleteManagement.addAthlete(firstName, lastName, sport, gold, silver, bronze);
                                if (operation)
                                    System.out.print("athlete added\n");
                                else
                                    System.out.print("athlete exists\n");
                            } catch (NumberFormatException e) {
                                //user did not enter a number for the medals
                                System.out.println("Invalid Input");
                            } catch (IOException e) {
                            }
                            break;

                        case 'D':  //Count athletes by medal type
                            try {
                                System.out.print("Please enter a medal type, 0 for gold, 1 for silver, 2 for bronze, to count the athletes with such medal:\n");
                                int medalType = Integer.parseInt(stdin.readLine().trim());
                                int athleteCount = athleteManagement.countHowManyAthletesHaveMedals(medalType);

                                System.out.print("The number of athletes with the given medal type: " + athleteCount + "\n");
                            } catch (NumberFormatException e) {
                                //user did not enter a number
                                System.out.println("Invalid input");
                            }
                            break;

                        case 'E':  //Search by athlete name
                            System.out.print("Please enter the first and last names of an athlete to search:\n");
                            System.out.print("First Name:\n");
                            firstName = stdin.readLine().trim();
                            System.out.print("Last Name:\n");
                            lastName = stdin.readLine().trim();
                            operation2 = athleteManagement.athleteNameExists(firstName, lastName);

                            if (operation2 > -1)
                                System.out.print("athlete found\n");
                            else
                                System.out.print("athlete not found\n");
                            break;

                        case 'L':   //List athletes
                            System.out.println("\n" + athleteManagement.listAthletes());
                            break;

                        case 'O':  // Sort by athlete names
                            athleteManagement.sortByAthleteNames();
                            System.out.print("sorted by athlete names\n");
                            break;

                        case 'P':  // Sort by medal counts
                            athleteManagement.sortByMedalCounts();
                            System.out.print("sorted by medal counts\n");
                            break;

                        case 'Q':   //Quit
                            break;

                        case 'R':  //Remove by athlete names
                            System.out.print("Please enter the first and last names of an athlete to remove:\n");
                            System.out.print("First Name:\n");
                            firstName = stdin.readLine().trim();
                            System.out.print("Last Name:\n");
                            lastName = stdin.readLine().trim();
                            operation = athleteManagement.removeAthleteByName(firstName, lastName);

                            if (operation)
                                System.out.print("athlete removed\n");
                            else
                                System.out.print("athlete not found\n");
                            break;

                        case 'T':  //Close AthleteManagement
                            athleteManagement.closeAthleteManagement();
                            System.out.print("athlete management system closed\n");
                            break;

                        case 'U':  //Write Text to a File
                            PrintWriter printWriter = null;
                            try {
                                System.out.print("Please enter a file name to write:\n");
                                fileName = stdin.readLine().trim();
                                File file = new File(fileName);
                                FileWriter fw = new FileWriter(file);
                                BufferedWriter bufferedWriter = new BufferedWriter(fw);
                                printWriter = new PrintWriter(bufferedWriter);

                                System.out.print("Please enter a string to write in the file:\n");
                                String str = stdin.readLine().trim() + "\n";
                                printWriter.print(str);


                                System.out.println(fileName + " was written");


                            } catch (IOException e) {
                                System.out.println(fileName + " was not found.");
                            } finally {
                                if (printWriter != null) {
                                    printWriter.close();
                                }
                            }
                            break;

                        case 'V':  //Read Text from a File
                            BufferedReader br = null;
                            try {
                                System.out.println("Please enter a file name to read:");
                                fileName = stdin.readLine().trim();
                                File file = new File(fileName);
                                FileReader fr = new FileReader(file);
                                br = new BufferedReader(fr);

                                System.out.println(fileName + " was read");

                                String firstLine = br.readLine();

                                System.out.println("The first line of the file is:\n" + firstLine);

                            } catch (FileNotFoundException e) {
                                System.out.println(fileName + " was not found");
                            } catch (IOException e) {

                            } finally {
                                if (br != null) {
                                    br.close();
                                }
                            }


                            break;

                        case 'W':  //Serialize ProjectManagement to a File
                            ObjectOutputStream outStream = null;

                            try {
                                System.out.print("Please enter a file name to write:\n");
                                fileName = stdin.readLine().trim();
                                FileOutputStream fileOutput = new FileOutputStream(fileName);
                                outStream = new ObjectOutputStream(fileOutput);

                                // Serialize this above object to a file
                                outStream.writeObject(athleteManagement);
                                System.out.println(fileName + " was written");
                            } catch (NotSerializableException exception) {
                                System.out.println("NotSerializableException");
                            } catch (IOException exception) {
                            } finally {
                                try {
                                    if (outStream != null) outStream.close();
                                } catch (IOException e) {
                                }

                            }
                            break;

                        case 'X':  //Deserialize ProjectManagement from a File

                            ObjectInputStream inStream = null;

                            try {
                                System.out.print("Please enter a file name to read:\n");
                                fileName = stdin.readLine().trim();
                                FileInputStream fileInput = new FileInputStream(fileName);
                                inStream = new ObjectInputStream(fileInput);

                                // Deserialize from file
                                athleteManagement = (AthleteManagement) inStream.readObject();
                                System.out.println(fileName + " was read");

                            } catch (NotSerializableException exception) {
                                System.out.println("NotSerializableException");
                            } catch (FileNotFoundException exception) {
                                System.out.println(fileName + " was not found");
                            } catch (ClassNotFoundException e) {
                            } finally {
                                try {
                                    if (inStream != null) inStream.close();
                                } catch (IOException e) {
                                }

                            }

                            break;

                        case '?':   //Display Menu
                            printMenu();
                            break;

                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                } else {
                    System.out.print("Unknown action\n");
                }
            } while (input1 != 'Q' || line.length() != 1);
        } catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    /**
     * The method printMenu displays the menu to a user
     **/
    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Athlete\n" +
                "D\t\tCount Athletes for Medal Type\n" +
                "E\t\tSearch for Athlete Name\n" +
                "L\t\tList Athletes\n" +
                "O\t\tSort by Athlete Names\n" +
                "P\t\tSort by Medal Counts\n" +
                "Q\t\tQuit\n" +
                "R\t\tRemove by Athlete Name\n" +
                "T\t\tClose AthleteManagement\n" +
                "U\t\tWrite Text to File\n" +
                "V\t\tRead Text from File\n" +
                "W\t\tSerialize AthleteManagement to File\n" +
                "X\t\tDeserialize AthleteManagement from File\n" +
                "?\t\tDisplay Help\n\n");
    }
} // end of Assignment8 class

