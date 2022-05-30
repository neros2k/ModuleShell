package n2k_.moduleshell.module.config;
import n2k_.moduleshell.ModuleEnum;
import n2k_.moduleshell.base.AbstractCommandModule;
import n2k_.moduleshell.base.AbstractConfig;
import net.dv8tion.jda.api.JDA;
import java.util.HashMap;
import java.util.Map;
public class ConfigModule extends AbstractCommandModule {
    private final Map<String, HashMap<String, AbstractConfig>> CONFIG_MAP;

    public ConfigModule(String id, JDA jda) {
        super(id, jda);
        this.CONFIG_MAP = new HashMap<>();
    }

    public HashMap<String, AbstractConfig> getGuildConfig(String serverId) {
        return this.CONFIG_MAP.computeIfAbsent(
                serverId, k -> new HashMap<>()
        );
    }

    public AbstractConfig getConfig(String serverId, String moduleId) {
        return this.CONFIG_MAP.get(serverId).computeIfAbsent(
                serverId, k -> ModuleEnum.valueOf(moduleId).getConfig().clone()
        );
    }
}
