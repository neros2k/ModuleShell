package n2k_.moduleshell.module.base;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.command.CallCommand;
import net.dv8tion.jda.api.JDA;
public class DefaultModule extends AbstractModule {
    private final static String DEFAULT_PREFIX = "$";

    public DefaultModule(String id, JDA jda) {
        super(id, jda);
    }

    @Override
    public void init() {
        super.addListener(new CallCommand(
                this, super.getJDA(), "def-ping", "Default ping command.",
                DefaultModule.DEFAULT_PREFIX, (ctx) -> ctx.getChannel().sendMessage("Pong!").queue()
        ));
        super.addListener(new InstallCommand(this, DefaultModule.DEFAULT_PREFIX));
        super.init();
    }

    @Override
    public boolean notValid(String serverId) {
        return false;
    }
}
