package n2k_.moduleshell;
import n2k_.moduleshell.base.AbstractConfig;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.module.base.DefaultModule;
import n2k_.moduleshell.module.config.ConfigModule;
import n2k_.moduleshell.module.config.module.BaseConfig;
import n2k_.moduleshell.module.msr.MsrModule;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public enum ModuleEnum {
    default_module(new DefaultModule("default_module", ModuleShell.getJDA()), new BaseConfig()),
    msr_module(new MsrModule("msr_module", ModuleShell.getJDA()), new AbstractConfig() {
        @Override
        public void init() {

        }
    }),
    config_module(new ConfigModule("config_module", ModuleShell.getJDA()), new AbstractConfig() {
        @Override
        public void init() {

        }
    });

    private static Map<String, AbstractModule> MODULES;
    private final AbstractModule MODULE;
    private final AbstractConfig CONFIG;

    ModuleEnum(AbstractModule module, AbstractConfig config) {
        ModuleEnum.getModules().put(module.getID(), module);
        this.MODULE = module;
        this.CONFIG = config;
    }

    public static Map<String, AbstractModule> getModules() {
        if(ModuleEnum.MODULES == null) ModuleEnum.MODULES = new HashMap<>();
        return ModuleEnum.MODULES;
    }

    public static void initModules() {
        Arrays.stream(ModuleEnum.values()).forEach(moduleEnum -> {
            moduleEnum.MODULE.init();
            moduleEnum.CONFIG.init();
        });
    }

    public AbstractModule getModule() {
        return this.MODULE;
    }

    public AbstractConfig getConfig() {
        return this.CONFIG;
    }
}
