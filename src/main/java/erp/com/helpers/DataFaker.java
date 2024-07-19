package erp.com.helpers;

import erp.com.constants.ConstantGlobal;
import erp.com.ulitilities.Group;
import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataFaker {
    private static Faker faker;

    public static Faker createFaker() {
        faker = new Faker(new Locale(ConstantGlobal.LOCATE));
        return faker;
    }

    public static Faker createFakerByLocate(String locate) {
        faker = new Faker(new Locale(locate));
        return faker;
    }

    public static Faker getDataFaker() {
        if (faker == null) {
            createFaker();
        }
        return faker;
    }

    public static void setFaker(Faker faker) {
        DataFaker.faker = faker;
    }

}
