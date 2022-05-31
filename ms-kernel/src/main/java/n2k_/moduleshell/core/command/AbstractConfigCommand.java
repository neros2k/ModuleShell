package n2k_.moduleshell.core.command;
import n2k_.moduleshell.core.AbstractModule;
import net.dv8tion.jda.api.JDA;
public abstract class AbstractConfigCommand extends AbstractCommand {
    public AbstractConfigCommand(AbstractModule module, JDA jda, String name, String description, String prefix) {
        super(module, jda, name, description, prefix);
    }

    public String getConfigName(String serverId) {
        return super.getName();
    }

    public String getConfigDescription(String serverId) {
        return super.getDescription();
    }

    public String getConfigPrefix(String serverId) {
        return super.getPrefix();
    }
}
