package n2k_.moduleshell.module.base.command;
import n2k_.moduleshell.ModuleEnum;
import n2k_.moduleshell.ModuleShell;
import n2k_.moduleshell.base.AbstractCommandModule;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.command.AbstractMessageCommand;
import n2k_.moduleshell.base.command.CommandContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public class HelpCommand extends AbstractMessageCommand {
    public HelpCommand(AbstractModule module, JDA jda, String name, String description, String prefix) {
        super(module, jda, name, description, prefix);
    }

    @Override
    protected void onMessageCommand(@NotNull CommandContext ctx, @NotNull MessageReceivedEvent event) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Help message");
        ModuleShell.getEnabledModulesMap().get(event.getGuild().getId()).forEach(moduleId -> {
            AbstractModule module = ModuleEnum.getModules().get(moduleId);
            if(module instanceof AbstractCommandModule commandModule) {
                StringBuilder stringBuilder = new StringBuilder();
                commandModule.getCommandList().forEach(command -> {
                    stringBuilder.append(command.getPrefix())
                                 .append(command.getName())
                                 .append(" - ")
                                 .append(command.getDescription())
                                 .append("\n");
                });
                builder.addField(commandModule.getID(), stringBuilder.toString(), false);
            }
        });
        ctx.getChannel().sendMessageEmbeds(builder.build()).queue();
    }
}
