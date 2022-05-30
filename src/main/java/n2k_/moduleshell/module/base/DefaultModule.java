package n2k_.moduleshell.module.base;
import n2k_.moduleshell.base.AbstractCommandModule;
import n2k_.moduleshell.module.base.command.HelpCommand;
import n2k_.moduleshell.module.base.command.PingCommand;
import net.dv8tion.jda.api.JDA;
public class DefaultModule extends AbstractCommandModule {
    private final static String DEFAULT_PREFIX = "def.";

    public DefaultModule(String id, JDA jda) {
        super(id, jda);
    }

    @Override
    public void init() {
        super.addCommand(new PingCommand(this, super.getJDA(), "ping", "Default ping command.", DefaultModule.DEFAULT_PREFIX));
        super.addCommand(new HelpCommand(this, super.getJDA(), "help", "Default help command.", DefaultModule.DEFAULT_PREFIX));
        super.init();
    }
}
