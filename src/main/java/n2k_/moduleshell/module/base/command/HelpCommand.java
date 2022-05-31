package n2k_.moduleshell.module.base.command;
import n2k_.moduleshell.ModuleEnum;
import n2k_.moduleshell.ModuleShell;
import n2k_.moduleshell.base.AbstractCommandModule;
import n2k_.moduleshell.base.AbstractConfig;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.command.AbstractMessageCommand;
import n2k_.moduleshell.base.command.CommandContext;
import n2k_.moduleshell.module.config.ConfigModule;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public class HelpCommand extends AbstractMessageCommand {
    private final static String DEFAULT_NAME = "help";
    private final static String DEFAULT_DESCRIPTION = "Help command.";

    public HelpCommand(AbstractModule module, String prefix) {
        super(module, module.getJDA(), HelpCommand.DEFAULT_NAME, HelpCommand.DEFAULT_DESCRIPTION, prefix);
    }

    @Override
    protected void onMessageCommand(@NotNull CommandContext ctx, @NotNull MessageReceivedEvent event) {
        Guild guild = event.getGuild();
        String guildId = event.getGuild().getId();
        AbstractConfig config = ConfigModule.getConfig(guild.getId(), super.getModule().getID());
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle(config.getLocalised("help_title"));
        ModuleShell.getEnabledModulesMap().get(event.getGuild().getId()).forEach(moduleId -> {
            AbstractModule module = ModuleEnum.getModules().get(moduleId);
            if(module instanceof AbstractCommandModule commandModule) {
                AbstractConfig commandConfig = ConfigModule.getConfig(guild.getId(), commandModule.getID());
                StringBuilder stringBuilder = new StringBuilder();
                commandModule.getCommandList().forEach(command -> {
                    stringBuilder.append(command.getPrefix(guildId))
                                 .append(command.getName(guildId)).append(" - ")
                                 .append(command.getDescription(guildId)).append("\n");
                });
                builder.addField(commandConfig.getLocalised("name"), stringBuilder.toString(), false);
            }
        });
        ctx.getChannel().sendMessageEmbeds(builder.build()).queue();
    }

    public static String getDefaultName() {
        return HelpCommand.DEFAULT_NAME;
    }

    public static String getDefaultDescription() {
        return HelpCommand.DEFAULT_DESCRIPTION;
    }
}
