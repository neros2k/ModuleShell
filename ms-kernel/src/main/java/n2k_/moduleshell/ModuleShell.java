package n2k_.moduleshell;
import n2k_.moduleshell.core.config.IConfigRepository;
import n2k_.moduleshell.core.session.ISessionRepository;
import n2k_.moduleshell.core.module.AbstractModule;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.jetbrains.annotations.NotNull;
import javax.security.auth.login.LoginException;
public class ModuleShell {
    private static IConfigRepository CONFIG_REPOSITORY;
    private static ISessionRepository SESSION_REPOSITORY;
    private static JDA JDA;

    public static void main(String @NotNull [] args) throws LoginException {
        ModuleShell.CONFIG_REPOSITORY = new ConfigRepository();
        ModuleShell.SESSION_REPOSITORY = new SessionRepository();
        ModuleShell.JDA = JDABuilder.createDefault("").build();
    }

    public static void registerModule(@NotNull AbstractModule module) {
        module.init();
    }

    public static IConfigRepository getConfigRepository() {
        return ModuleShell.CONFIG_REPOSITORY;
    }

    public static ISessionRepository getSessionRepository() {
        return ModuleShell.SESSION_REPOSITORY;
    }

    public static JDA getJDA() {
        return ModuleShell.JDA;
    }
}