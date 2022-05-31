package n2k_.moduleshell.module.config.module;
import n2k_.moduleshell.base.AbstractConfig;
import n2k_.moduleshell.module.base.DefaultModule;
import n2k_.moduleshell.module.base.command.HelpCommand;
import n2k_.moduleshell.module.base.command.PingCommand;
import java.util.Map;
public class BaseConfig extends AbstractConfig {
    @Override
    public void init() {
        Map<String, String> values = super.getValues();
        values.put("prefix", DefaultModule.getDefaultPrefix());
        values.put("locale", "eng");
        values.put("eng.name", "Base module");
        values.put("eng.help_title", "Help message");
        values.put("eng."+PingCommand.getDefaultName()+".message", "Pong!");
        values.put("eng."+PingCommand.getDefaultName()+".name", PingCommand.getDefaultName());
        values.put("eng."+HelpCommand.getDefaultName()+".name", HelpCommand.getDefaultName());
        values.put("eng."+PingCommand.getDefaultName()+".description", PingCommand.getDefaultDescription());
        values.put("eng."+HelpCommand.getDefaultName()+".description", HelpCommand.getDefaultDescription());
        values.put("ru.name", "Базовый модуль");
        values.put("ru.help_title", "Помощь");
        values.put("ru."+PingCommand.getDefaultName()+".message", "Понг!");
        values.put("ru."+PingCommand.getDefaultName()+".name", "пинг");
        values.put("ru."+HelpCommand.getDefaultName()+".name", "помощь");
        values.put("ru."+PingCommand.getDefaultName()+".description", "Показывает скорость ответа бота.");
        values.put("ru."+HelpCommand.getDefaultName()+".description", "Отправляет это сообщение.");
    }
}
