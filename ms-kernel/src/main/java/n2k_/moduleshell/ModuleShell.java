package n2k_.moduleshell;
import n2k_.moduleshell.core.module.AbstractModule;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.jetbrains.annotations.NotNull;
import javax.security.auth.login.LoginException;
public class ModuleShell {
    private static JDA JDA;

    public static void main(String @NotNull [] args) throws LoginException {
        ModuleShell.JDA = JDABuilder.createDefault("").build();
    }

    public static void registerModule(@NotNull AbstractModule module) {
        module.init();
    }

    public static JDA getJDA() {
        return ModuleShell.JDA;
    }
}