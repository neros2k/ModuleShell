package n2k_.moduleshell.module.base;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.CommandListener;
import net.dv8tion.jda.api.JDA;
public class DefaultModule extends AbstractModule {
    private final static String DEFAULT_PREFIX = "$";

    public DefaultModule(String id, JDA jda) {
        super(id, jda);
    }

    @Override
    public void init() {
        CommandListener LISTENER = new PingCommand(this, super.getJDA(), DefaultModule.DEFAULT_PREFIX);
        LISTENER.init();
        super.addListener(LISTENER);
    }

    @Override
    protected boolean notValid(String serverId) {
        return false;
    }
}
