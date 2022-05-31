package n2k_.moduleshell;
import n2k_.moduleshell.core.config.AbstractConfig;
import n2k_.moduleshell.core.config.IConfigRepository;
public class ConfigRepository implements IConfigRepository {
    @Override
    public AbstractConfig getConfig(String guildId, String moduleId) {
        return null;
    }

    @Override
    public void setValue(String guildId, String moduleId, String parameter, String value) {

    }

    @Override
    public void saveConfig(String guildId, AbstractConfig config) {

    }
}
