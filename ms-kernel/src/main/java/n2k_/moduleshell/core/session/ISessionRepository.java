package n2k_.moduleshell.core.session;
public interface ISessionRepository {
    ModuleSession getSession(String guildId);

    boolean isInstalled(String guildId, String moduleId);

    void enableModule(String guildId, String moduleId);

    void saveSession(String guildId, ModuleSession session);
}
