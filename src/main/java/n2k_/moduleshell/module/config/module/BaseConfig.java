package n2k_.moduleshell.module.config.module;
import n2k_.moduleshell.base.AbstractConfig;
import n2k_.moduleshell.module.base.DefaultModule;
public class BaseConfig extends AbstractConfig {
    @Override
    public void init() {
        this.getValues().put("prefix", DefaultModule.getDefaultPrefix());
        this.getValues().put("locale", "ru");
        this.getValues().put("eng.name", "Base module");
        this.getValues().put("eng.help_title", "Help message");
        this.getValues().put("eng.ping_message", "Pong!");
        this.getValues().put("ru.name", "Базовый модуль");
        this.getValues().put("ru.help_title", "Помощь");
        this.getValues().put("ru.ping_message", "Понг!");
    }
}
