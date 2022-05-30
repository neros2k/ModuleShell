package n2k_.moduleshell.module.base;
import n2k_.moduleshell.base.AbstractModule;
import net.dv8tion.jda.api.JDA;
public class DefaultModule extends AbstractModule {
    private final static String DEFAULT_PREFIX = "$";

    public DefaultModule(String id, JDA jda) {
        super(id, jda);
    }

    @Override
    public void init() {
        super.addListener(new PingCommand(this, super.getJDA(), DefaultModule.DEFAULT_PREFIX));
        super.init();
    }

    @Override
    protected boolean notValid(String serverId) {
        return false;
    }
}
