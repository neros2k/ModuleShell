package n2k_.moduleshell.core.session;
import java.util.ArrayList;
import java.util.List;
public class ModuleSession {
    private final List<String> ENABLED_MODULES;

    public ModuleSession() {
        this.ENABLED_MODULES = new ArrayList<>();
    }

    public List<String> getEnabledModules() {
        return this.ENABLED_MODULES;
    }
}
