package n2k_.moduleshell.core;
import n2k_.moduleshell.core.module.AbstractModule;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
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

    public AbstractModule getModule() {
        return this.MODULE;
    }

    public JDA getJDA() {
        return this.JDA;
    }
}
