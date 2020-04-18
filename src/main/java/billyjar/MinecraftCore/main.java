package billyjar.MinecraftCore;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.permission.PermissionAttachment;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Utils;

import java.util.HashMap;
import java.util.UUID;

public class main extends PluginBase {
    public static main plugin;
    public HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();

    @Override
    public void onEnable()
    {
        plugin = this;
        this.getServer().getPluginManager().registerEvents(new events(), this);
        this.getLogger().info(TextFormat.GREEN + "Plugin Enabled");
    }
    @Override
    public void onDisable()
    {
        this.getLogger().info(TextFormat.RED + "Plugin Disabled");
    }

    //@EventHandler
    //public void onJoin(PlayerJoinEvent e) {
      //  PermissionAttachment attachment = e.getPlayer().addAttachment(this);
        //perms.put(e.getPlayer().getUniqueId(), attachment);

        //PermissionAttachment pperms = perms.get(e.getPlayer().getUniqueId());
    //}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmd = command.getName().toLowerCase();
        if ("example".equals(cmd)) {
            Player target = sender.getServer().getPlayerExact(sender.getName());
            Item item = new Item(ItemID.COMPASS);
            target.getInventory().setItem(4, item);
            target.sendMessage("Given compass to " + target.getName());
            showGmf(target);
        }

        else if ("addperm".equals(cmd)) {
            Player target = sender.getServer().getPlayerExact(sender.getName());
            PermissionAttachment pperms = perms.get(target.getUniqueId());
            pperms.setPermission("MinecraftCore.command.compass", true);
        }

        return true;
    }

    public void showGmf(Player p) {
        FormWindowSimple gui = new FormWindowSimple("Test", "Change your game mode quickly and simply");

        gui.addButton(new ElementButton("Adventure"));
        gui.addButton(new ElementButton("Creative"));
        gui.addButton(new ElementButton("Survival"));
        gui.addButton(new ElementButton("Spectator"));



        p.showFormWindow(gui);
    }


}
