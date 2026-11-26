package me.biggie.healPlugin;

import com.sun.source.tree.ArrayAccessTree;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.checkerframework.checker.i18nformatter.qual.I18nFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HealCommand implements BasicCommand {
    @Override
    public void execute(CommandSourceStack commandSourceStack, String[] args) {
        if (!(commandSourceStack.getExecutor() instanceof Player ply)) {
            commandSourceStack.getExecutor().sendMessage(
                    Component.text("Only players can use /heal!", NamedTextColor.RED)
            );
            return;
        }
        if (args.length == 0) {
            ply.setHealth(20.0);
        } else {
            var target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                ply.sendMessage(Component.text("The player isn't online!", NamedTextColor.RED));
                return;
            }
            target.setHealth(20.0);
            target.sendMessage(
                    Component.text("Healed " + target.getName() + " successfully!",
                            NamedTextColor.DARK_GREEN));
        }
    }
    @Override
    public Collection<String> suggest(CommandSourceStack commandSourceStack, String[] args) {
        if (args.length <=1){
            var names = new ArrayList<String>();
            for (Player p: Bukkit.getOnlinePlayers()){
                names.add(p.getName());
            }
            return names;
        }
        return List.of();
    }
}
