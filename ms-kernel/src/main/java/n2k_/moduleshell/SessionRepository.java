package n2k_.moduleshell;
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
    public void enableModule(String guildId, String moduleId) {
        ModuleSession session = this.getSession(guildId);
        session.getEnabledModules().add(moduleId);
        this.saveSession(guildId, session);
    }

    @Override
    public void saveSession(String guildId, ModuleSession session) {

    }
}
