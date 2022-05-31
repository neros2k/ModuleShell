package n2k_.moduleshell.core.config;
public interface IConfigRepository {
    AbstractConfig getConfig(String guildId, String moduleId);

    void setValue(String guildId, String moduleId, String parameter, String value);

    void saveConfig(String guildId, AbstractConfig config);
}
