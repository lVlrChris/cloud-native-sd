public class StringService {

    public String reverse(String input) {
        String revString = "";

        for (int i = input.length() - 1; i > 0; i--) {
            revString += input.charAt(i);
        }

        return revString;
    }
}
