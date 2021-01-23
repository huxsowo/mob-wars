package MW.GameManagers;

import MW.DamageType;
import MW.GameManagers.DamageManager;
import MW.GamePlayer;
import MW.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class EventManager implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        GamePlayer gamePlayer = new GamePlayer(player);
        Main.gamePlayerHashMap.put(player, gamePlayer);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        Main.gamePlayerHashMap.remove(player);
    }

    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player){
            e.setCancelled(true);
            double damage = Main.gamePlayerHashMap.get((Player) e.getDamager()).getKit().getDamage();
            DamageManager.dealDamage((Player) e.getDamager(), (Player) e.getEntity(), damage, DamageType.MELEE, "Attack", 8);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL){
            e.setCancelled(true);
        }
    }
}
