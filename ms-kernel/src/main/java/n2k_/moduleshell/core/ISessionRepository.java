package n2k_.moduleshell.core;
public interface ISessionRepository {
    ModuleSession getSession(String guildId);

    boolean isEnabled(String guildId, String moduleId);

    void saveSession(ModuleSession session);
}
