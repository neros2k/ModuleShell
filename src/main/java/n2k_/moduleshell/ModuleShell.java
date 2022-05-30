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
    static {
        //ModuleShell.ENABLED_MODULES.put("909541622600056853", new String[]{"default-module"});
    }
    public static void main(String @NotNull [] args) throws LoginException {
        ModuleShell.JDA = JDABuilder.createDefault("").build();
        ModuleEnum.initModules();
    }

    public static Map<String, String[]> getEnabledModulesMap() {
        return ModuleShell.ENABLED_MODULES;
    }

    public static JDA getJDA() {
        return ModuleShell.JDA;
    }

    @Contract(pure = true) @NotNull
    public static String notEnabledModuleMessage(String moduleId) {
        return "Module `" + moduleId + "` not enabled.";
    }
}