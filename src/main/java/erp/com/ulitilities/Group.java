package erp.com.ulitilities;


import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

public class Group extends AbstractProvider<BaseProviders>{
    private static final String[] GROUPS = {"Group A", "Group B", "Group C", "Group D", "Group E"};

     public Group(BaseProviders faker) {
        super(faker);
    }

    public String group() {
        return GROUPS[faker.random().nextInt(GROUPS.length)];
    }
}
