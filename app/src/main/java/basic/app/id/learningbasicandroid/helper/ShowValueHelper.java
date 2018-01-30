package basic.app.id.learningbasicandroid.helper;

/**
 * Created by snyind on 1/24/18.
 */

public class ShowValueHelper {

    private static String value;

    public static void inputValue(String input1, String input2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input1);
        stringBuilder.append(" ");
        stringBuilder.append(input2);
        value = stringBuilder.toString();
    }

    public static String getValue() {
        return value;
    }
}
