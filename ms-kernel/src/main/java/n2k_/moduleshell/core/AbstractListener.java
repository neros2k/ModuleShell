package n2k_.moduleshell.core;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
public abstract class AbstractListener extends ListenerAdapter implements Initilizable {
    private final AbstractModule MODULE;

    public AbstractListener(AbstractModule module) {
        this.MODULE = module;
    }

    @Override
    public void init() {
        this.MODULE.getJDA().addEventListener(this);
    }

    public AbstractModule getModule() {
        return this.MODULE;
    }
}
