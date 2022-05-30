package n2k_.moduleshell.base;
import n2k_.moduleshell.ModuleShell;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.EventListener;
import java.util.Arrays;
public abstract class AListener implements IInitilizable, EventListener {
    final AModule MODULE;
    final JDA JDA;

    public AListener(AModule module, JDA jda) {
        this.MODULE = module;
        this.JDA = jda;
    }

    @Override
    public void init() {
        JDA.addEventListener(this);
    }

    boolean serverCheck(String serverId) {
        return Arrays.stream(ModuleShell.getEnabledModulesMap().get(serverId)).toList().contains(this.MODULE.ID);
    }
}
