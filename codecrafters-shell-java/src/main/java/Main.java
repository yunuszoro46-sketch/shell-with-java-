import java.util.Scanner;
import java.util.Set;

public class Main {
    
    private static final Set<String> BUILTINS = Set.of("echo", "exit", "type");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            System.out.flush();

            if (!scanner.hasNextLine()) {
                break;
            }

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

   
            String[] parts = input.split("\\s+", 2);
            String command = parts[0];
            String arg = parts.length > 1 ? parts[1].trim() : "";

            if (command.equals("exit")) {
                int exitCode = arg.isEmpty() ? 0 : Integer.parseInt(arg);
                System.exit(exitCode);
            } 
            else if (command.equals("echo")) {
                System.out.println(arg);
            } 
            else if (command.equals("type")) {
                if (BUILTINS.contains(arg)) {
                    System.out.println(arg + " is a shell builtin");
                } else {
                    System.out.println(arg + ": not found");
                }
            } 
            else {
                System.out.println(command + ": command not found");
            }
        }
    }
}
