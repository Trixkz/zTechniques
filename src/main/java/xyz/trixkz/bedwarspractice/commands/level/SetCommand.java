package xyz.trixkz.bedwarspractice.commands.level;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.trixkz.bedwarspractice.Main;
import xyz.trixkz.bedwarspractice.commands.BaseCommand;
import xyz.trixkz.bedwarspractice.managers.user.User;
import xyz.trixkz.bedwarspractice.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SetCommand extends BaseCommand {

    private Main main;

    public SetCommand(Main main) {
        this.main = main;
    }

    @Override
    public void executeAs(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        Player target = this.main.getServer().getPlayer(args[1]);

        User user = User.getByUUID(target.getUniqueId());

        if (!target.isOnline()) {
            player.sendMessage(Utils.translate("&cError: Player is not currently online"));

            return;
        }

        if (!this.main.getUtils().isNumeric(args[2])) {
            player.sendMessage(Utils.translate("&cError: Please send a valid number"));

            return;
        }

        Integer amount = Integer.parseInt(args[2]);

        user.getSettings().setLevel(amount);
    }

    @Override
    public List<String> getTabCompletions(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> tabCompletions = new ArrayList<String>();

        return tabCompletions;
    }
}
