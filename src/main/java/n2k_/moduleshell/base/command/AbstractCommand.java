package n2k_.moduleshell.base.command;
import n2k_.moduleshell.ModuleEnum;
import n2k_.moduleshell.base.AbstractListener;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.module.config.ConfigModule;
import net.dv8tion.jda.api.JDA;
public abstract class AbstractCommand extends AbstractListener {
    private final String NAME;
    private final String DESCRIPTION;
    private final String PREFIX;

    public AbstractCommand(AbstractModule module, JDA jda, String name, String description, String prefix) {
        super(module, jda);
        this.NAME = name;
        this.DESCRIPTION = description;
        this.PREFIX = prefix;
    }

    public String getName() {
        return this.NAME;
    }

    public String getDescription() {
        return this.DESCRIPTION;
    }

    public String getPrefix() {
        return this.PREFIX;
    }

    public String getPrefix(String serverId) {
        return ConfigModule.getConfig(serverId, super.getModule().getID())
                           .getValues().getOrDefault("prefix", this.PREFIX);
    }
}
