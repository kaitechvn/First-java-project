import java.util.ArrayList;
import java.util.Scanner;
class SimpleStartup {
    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0 ) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }
        return result;
    }
}

class GameHelper {
    public int getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

class Run {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        Scanner scanner = new Scanner(System.in);
        SimpleStartup theStartup = new SimpleStartup();

        ArrayList<String> locationCells = new ArrayList<>();
        locationCells.add("A3");
        locationCells.add("A4");
        locationCells.add("A5");

        theStartup.setLocationCells(locationCells);

        boolean isAlive = true;
        while (isAlive) {
            System.out.print("make prediction: ");
            String userInput = scanner.nextLine();
            String result = theStartup.checkYourself(userInput);
            numOfGuesses++;
            System.out.println(result);
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }
}