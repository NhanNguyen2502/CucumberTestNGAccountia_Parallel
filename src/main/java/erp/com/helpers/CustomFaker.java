package erp.com.helpers;

import erp.com.ulitilities.Group;
import net.datafaker.Faker;

public class CustomFaker extends Faker {

    public Group group() {
        return (Group) this.getProvider(Group.class, Group::new);
    }
}
