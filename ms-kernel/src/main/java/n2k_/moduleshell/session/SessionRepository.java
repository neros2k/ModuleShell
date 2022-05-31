package n2k_.moduleshell.session;
import n2k_.moduleshell.core.session.ISessionRepository;
import n2k_.moduleshell.core.session.ModuleSession;

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
