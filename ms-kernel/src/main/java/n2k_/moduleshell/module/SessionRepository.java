package n2k_.moduleshell.module;
import n2k_.moduleshell.core.ISessionRepository;
public class SessionRepository implements ISessionRepository {
    @Override
    public ModuleSession getSession(String guildId) {
        return null;
    }

    @Override
    public boolean isInstalled(String guildId, String moduleId) {
        return this.getSession(guildId).getEnabledModules().contains(moduleId);
    }

    @Override
    public void saveSession(ModuleSession session) {

    }
}
