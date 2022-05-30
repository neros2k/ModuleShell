package n2k_.moduleshell;
import n2k_.moduleshell.module.ModuleEnum;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;
public class ModuleShell {
    private final static Map<String, String[]> ENABLED_MODULES = new HashMap<>();
    private static JDA JDA;

    public static void main(String @NotNull [] args) throws LoginException {
        ModuleShell.JDA = JDABuilder.createDefault("").build();
        ModuleEnum.initModules();
    }

    @Contract(pure = true) @NotNull
    public static String notEnabledModuleMessage(String moduleId) {
        return "Module `" + moduleId + "` not enabled.";
    }

    public static Map<String, String[]> getEnabledModulesMap() {
        return ModuleShell.ENABLED_MODULES;
    }

    public static JDA getJDA() {
        return ModuleShell.JDA;
    }
}