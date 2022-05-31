package n2k_.moduleshell.module.config;
import n2k_.moduleshell.ModuleEnum;
import n2k_.moduleshell.base.AbstractCommandModule;
import n2k_.moduleshell.base.AbstractConfig;
import n2k_.moduleshell.module.config.command.SetValue;
import net.dv8tion.jda.api.JDA;
import java.util.HashMap;
import java.util.Map;
public class ConfigModule extends AbstractCommandModule {
    private final Map<String, HashMap<String, AbstractConfig>> CONFIG_MAP;

    public ConfigModule(String id, JDA jda) {
        super(id, jda);
        this.CONFIG_MAP = new HashMap<>();
    }

    @Override
    public void init() {
        super.addCommand(new SetValue(this, "set", "Set config value command.", "config."));
        super.init();
    }

    public static HashMap<String, AbstractConfig> getGuildConfig(String serverId) {
        ConfigModule configModule = (ConfigModule) ModuleEnum.config_module.getModule();
        if(!configModule.CONFIG_MAP.containsKey(serverId)) {
            configModule.CONFIG_MAP.put(serverId, new HashMap<>());
        }
        return configModule.CONFIG_MAP.get(serverId);
    }

    public static AbstractConfig getConfig(String serverId, String moduleId) {
        HashMap<String, AbstractConfig> guildConfig = ConfigModule.getGuildConfig(serverId);
        if(!guildConfig.containsKey(moduleId)) {
            guildConfig.put(moduleId, ModuleEnum.valueOf(moduleId).getConfig().clone());
        }
        return ConfigModule.getGuildConfig(serverId).get(moduleId);
    }
}
