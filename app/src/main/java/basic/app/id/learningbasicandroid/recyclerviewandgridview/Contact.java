package basic.app.id.learningbasicandroid.recyclerviewandgridview;

/**
 * Created by Dell on 2/1/2018.
 */

public class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String name,
                   String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}