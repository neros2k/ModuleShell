package n2k_.moduleshell.core.module;
import n2k_.moduleshell.ModuleShell;
import n2k_.moduleshell.core.AbstractListener;
import n2k_.moduleshell.core.Initilizable;
import n2k_.moduleshell.core.command.CommandContext;
import net.dv8tion.jda.api.JDA;
import org.jetbrains.annotations.NotNull;
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

    public boolean isValid(String guildId) {
        return ModuleShell.getSessionRepository().isInstalled(guildId, this.ID);
    }

    public void onInvalidCall(@NotNull CommandContext ctx) {
        ctx.getChannel().sendMessage("Module "+this.ID+" not installed.").queue();
    }

    public String getID() {
        return this.ID;
    }

    public JDA getJDA() {
        return this.JDA;
    }
}
