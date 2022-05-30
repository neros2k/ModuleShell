package n2k_.moduleshell.module.msr;
import n2k_.moduleshell.base.AbstractCommandModule;
import n2k_.moduleshell.module.msr.command.InstallCommand;
import net.dv8tion.jda.api.JDA;
public class MsrModule extends AbstractCommandModule {
    private final static String MSR_PREFIX = "msr.";

    public MsrModule(String id, JDA jda) {
        super(id, jda);
    }

    @Override
    public void init() {
        super.addCommand(new InstallCommand(this, "install", "Install module command.", MsrModule.MSR_PREFIX));
        super.init();
    }

    @Override
    public boolean notValid(String serverId) {
        return false;
    }
}
