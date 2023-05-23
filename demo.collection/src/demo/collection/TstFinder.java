package demo.collection;
import java.util.Arrays;
import java.util.List;

public class TstFinder {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Dory", "Gill", "Bruce", "Mary");
//      findNemo(names);
        String elem = find( names, "Nemo" );
        System.out.println( (elem != null) ? "Found Nemo" : "Sorry, Nemo not found" );
    }
    public static String find(List<String> names, String target) { //pure
        /* functional code - telling "what" */
        return names.stream() //get the stream of elements
                .filter(elem -> elem.equals(target))
                .findAny().orElse(null);
    }
    public static void findNemo(List<String> names) { //impure 
        /* imperative code - telling "how" */
        boolean found = false; //local side effect
        for (String name : names) {
            if (name.equals("Nemo")) {
                found = true;
                break;
            }
        }
        if (found)
            System.out.println("Found Nemo"); //side effect
        else
            System.out.println("Sorry, Nemo not found");
    }
}