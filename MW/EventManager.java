package MW;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class EventManager implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(10000000);
        Bukkit.broadcastMessage("THIS NIGGA " + player.getName() + " JOINED LMAOOOOOOOOO");
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e){
        ItemStack clickedItem = e.getCurrentItem();
        Material material = clickedItem.getType();
        for (Kit kit : Main.allKits){
            if (material == kit.menuItem){
                kit.equipKit((Player) e.getWhoClicked());
            }
        }
        e.getWhoClicked().closeInventory();
    }
}
