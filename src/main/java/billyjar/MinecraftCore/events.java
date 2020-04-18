package billyjar.MinecraftCore;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.event.player.PlayerItemConsumeEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.permission.PermissionAttachment;
import cn.nukkit.utils.TextFormat;

import java.util.HashMap;
import java.util.UUID;

public class events implements Listener {

    public HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();

    @EventHandler
    public void onMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        player.sendPopup(TextFormat.RED+"You Moved!");
    }

    @EventHandler
    public void onFormResponse(PlayerFormRespondedEvent e) {
        Player p = e.getPlayer();
        if (e.getWindow() instanceof FormWindowSimple) {
            FormWindowSimple gui = (FormWindowSimple) e.getWindow();
            if (gui.getTitle().equals("Test")) {
                String responseName = gui.getResponse().getClickedButton().getText();
                p.sendMessage("You selected: "+responseName);
            }

            return;
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        PermissionAttachment attachment = e.getPlayer().addAttachment(CorePluginManager.plugin);
        perms.put(e.getPlayer().getUniqueId(), attachment);
        PermissionAttachment pperms = perms.get(e.getPlayer().getUniqueId());
        pperms.setPermission("MinecraftCore.example", true);
    }
}
