package n2k_.moduleshell.core.command;
import n2k_.moduleshell.core.AbstractListener;
import n2k_.moduleshell.core.AbstractModule;
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
}
