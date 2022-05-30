package n2k_.moduleshell;
import n2k_.moduleshell.module.ModuleEnum;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import javax.security.auth.login.LoginException;
import java.util.*;
public class ModuleShell {
    private final static Map<String, ArrayList<String>> ENABLED_MODULES = new HashMap<>();
    private static JDA JDA;

    public static void main(String @NotNull [] args) throws LoginException {
        ModuleShell.JDA = JDABuilder.createDefault("").build();
        ModuleEnum.initModules();
    }

    @Contract(pure = true) @NotNull
    public static String notEnabledModuleMessage(String moduleId) {
        return "Module `" + moduleId + "` not enabled.";
    }

    public static Map<String, ArrayList<String>> getEnabledModulesMap() {
            return ModuleShell.ENABLED_MODULES;
    }

    public static boolean enableModule(String serverId, String moduleId) {
        ArrayList<String> enabledModules = ModuleShell.ENABLED_MODULES.get(serverId);
        if(enabledModules == null) {
            enabledModules = new ArrayList<>();
        }
        if(enabledModules.contains(moduleId)) {
            return false;
        } else {
            enabledModules.add(moduleId);
            ModuleShell.ENABLED_MODULES.put(serverId, enabledModules);
            return true;
        }
    }

    public static JDA getJDA() {
        return ModuleShell.JDA;
    }
}