package n2k_.moduleshell.core;
import net.dv8tion.jda.api.JDA;
import java.util.ArrayList;
import java.util.List;
public abstract class AbstractModule implements Initilizable {
    private final JDA JDA;
    private final String ID;
    private final String NAME;
    private final String DESCRIPTION;
    private final List<AbstractListener> LISTENER_LIST;
    private final List<AbstractCommand> COMMAND_LIST;

    public AbstractModule(JDA jda, String id, String name, String description) {
        this.JDA = jda;
        this.ID = id;
        this.NAME = name;
        this.DESCRIPTION = description;
        this.LISTENER_LIST = new ArrayList<>();
        this.COMMAND_LIST = new ArrayList<>();
    }

    @Override
    public void init() {
        this.LISTENER_LIST.addAll(this.COMMAND_LIST);
        this.LISTENER_LIST.forEach(AbstractListener::init);
    }

    public void addListener(AbstractListener listener) {
        this.LISTENER_LIST.add(listener);
    }

    public void addCommand(AbstractCommand command) {
        this.COMMAND_LIST.add(command);
    }

    public JDA getJDA() {
        return this.JDA;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.NAME;
    }

    public String getDescription() {
        return this.DESCRIPTION;
    }

    public List<AbstractListener> getListenerList() {
        return this.LISTENER_LIST;
    }

    public List<AbstractCommand> getCommandList() {
        return this.COMMAND_LIST;
    }
}
