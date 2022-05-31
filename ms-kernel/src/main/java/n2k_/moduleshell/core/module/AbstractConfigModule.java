package n2k_.moduleshell.core.module;
import net.dv8tion.jda.api.JDA;
public abstract class AbstractConfigModule extends AbstractCommandModule {
    public AbstractConfigModule(String id, JDA jda) {
        super(id, jda);
    }


}
