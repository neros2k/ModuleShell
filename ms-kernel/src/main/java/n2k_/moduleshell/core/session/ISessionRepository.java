package n2k_.moduleshell.core.session;
public interface ISessionRepository {
    ModuleSession getSession(String guildId);

    boolean isInstalled(String guildId, String moduleId);

    void saveSession(ModuleSession session);
}
