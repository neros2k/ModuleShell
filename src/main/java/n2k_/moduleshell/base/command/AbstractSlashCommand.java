package n2k_.moduleshell.base.command;
import n2k_.moduleshell.ModuleShell;
import n2k_.moduleshell.base.AbstractModule;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
public abstract class AbstractSlashCommand extends AbstractMessageCommand {
    public AbstractSlashCommand(AbstractModule module, JDA jda, String name, String description, String prefix) {
        super(module, jda, name, description, prefix);
    }

    @Override
    public void init() {
        super.init();
        super.getJDA().updateCommands().addCommands(Commands.slash(super.getName(), super.getDescription())).queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getGuild() == null || !event.getName().equals(super.getName())) return;
        if(super.getModule().notValid(event.getGuild().getId())) {
            event.reply(ModuleShell.notEnabledModuleMessage(super.getModule().getID())).queue();
        } else {
            this.onSlashCommand(new CommandContext(super.getJDA(), event.getCommandString(), event.getMember(), event.getChannel()), event);
        }
    }

    protected abstract void onSlashCommand(CommandContext ctx, SlashCommandInteractionEvent event);
}
