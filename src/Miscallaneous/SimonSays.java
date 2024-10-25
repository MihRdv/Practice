package Miscallaneous;

import java.util.List;

public class SimonSays {
    /*
Simon asks you to perform operations on a list of numbers that only he tells you.
Create a function which evaluates a list of commands (written in plain English)
if the command begins with Simon says. Return the result as an integer.
     */

    public static int executeCommands(List<String> commands) {
        int total = 0;

        for (String command : commands) {
            command = command.toLowerCase();

            if (command.startsWith("simon says")) {
                String[] commandSplit = command.split("\\s+");

                if (commandSplit.length < 4) {
                    System.out.println("Invalid command format: " + command);
                    continue;
                }

                try {
                    int value = Integer.parseInt(commandSplit[3]);

                    switch (commandSplit[2]) {
                        case "add":
                            total += value;
                            System.out.println("Added " + value + ". Total is now " + total + ".");
                            break;
                        case "subtract":
                            total -= value;
                            System.out.println("Subtracted " + value + ". Total is now " + total + ".");
                            break;
                        default:
                            System.out.println("Invalid command: " + commandSplit[2]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number in command: " + command);
                }
            } else {
                System.out.println("Command ignored (no 'Simon says'): " + command);
            }
        }

        return total;
    }

    public static void main(String[] args) {
        // Change the commands as you see fit
        List<String> commands = List.of("Simon says add 4", "Simon says subtract 2", "add 10", "Simon says subtract 5", "Subtract 3");

        int result = executeCommands(commands);
        System.out.println("Final total: " + result);
    }
}
