package n2k_.moduleshell.module.config.module;
import n2k_.moduleshell.base.AbstractConfig;
public class BaseConfig extends AbstractConfig {
    @Override
    public void init() {
        this.getValues().put("prefix", "def.");
    }
}
