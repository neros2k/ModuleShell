package n2k_.moduleshell.module;
import n2k_.moduleshell.base.AbstractModule;
import net.dv8tion.jda.api.JDA;
public class DefaultModule extends AbstractModule {
    public DefaultModule(String id, JDA jda) {
        super(id, jda);
        super.addListener(new PingCommand(this, jda));
    }
}
