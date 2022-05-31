package n2k_.moduleshell.core.module;
import n2k_.moduleshell.core.config.AbstractConfig;
import net.dv8tion.jda.api.JDA;
public abstract class AbstractConfigModule extends AbstractCommandModule {
    private final AbstractConfig ABSTRACT_CONFIG;

    public AbstractConfigModule(String id, JDA jda, AbstractConfig abstractModule) {
        super(id, jda);
        this.ABSTRACT_CONFIG = abstractModule;
    }

    public AbstractConfig getDefaultConfig() {
        return this.ABSTRACT_CONFIG;
    }

    public AbstractConfig getNewConfig() {
        return this.ABSTRACT_CONFIG.clone();
    }
}
