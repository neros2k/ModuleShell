package n2k_.moduleshell.core;
import n2k_.moduleshell.ModuleShell;
import net.dv8tion.jda.api.JDA;
import java.util.ArrayList;
import java.util.List;
public abstract class AbstractModule implements Initilizable {
    private final String ID;
    private final JDA JDA;
    private final List<AbstractListener> LISTENER_LIST;

    public AbstractModule(String id, JDA jda) {
        this.ID = id;
        this.JDA = jda;
        this.LISTENER_LIST = new ArrayList<>();
    }

    @Override
    public void init() {
        this.initListeners();
    }

    public void initListeners() {
        this.LISTENER_LIST.forEach(AbstractListener::init);
    }

    public void addListener(AbstractListener listener) {
        this.LISTENER_LIST.add(listener);
    }

    public boolean notValid(String serverId) {
        if(ModuleShell.getEnabledModulesMap().isEmpty()) return true;
        return !ModuleShell.getEnabledModulesMap().get(serverId).contains(this.ID);
    }

    public String getID() {
        return this.ID;
    }

    public JDA getJDA() {
        return this.JDA;
    }
}
