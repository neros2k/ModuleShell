package n2k_.moduleshell.base;
import n2k_.moduleshell.ModuleShell;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Arrays;
public abstract class AbstractListener extends ListenerAdapter implements Initilizable {
    private final AbstractModule MODULE;
    private final JDA JDA;

    public AbstractListener(AbstractModule module, JDA jda) {
        this.MODULE = module;
        this.JDA = jda;
    }

    @Override
    public void init() {
        JDA.addEventListener(this);
    }

    protected boolean isValid(String id) {
        return Arrays.stream(ModuleShell.getEnabledModulesMap().get(id)).toList().contains(this.MODULE.getID());
    }

    public AbstractModule getModule() {
        return this.MODULE;
    }

    public JDA getJDA() {
        return this.JDA;
    }
}
