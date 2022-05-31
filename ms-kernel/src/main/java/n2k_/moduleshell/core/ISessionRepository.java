package n2k_.moduleshell.core;

import n2k_.moduleshell.module.ModuleSession;

public interface ISessionRepository {
    ModuleSession getSession(String guildId);

    boolean isInstalled(String guildId, String moduleId);

    void saveSession(ModuleSession session);
}
