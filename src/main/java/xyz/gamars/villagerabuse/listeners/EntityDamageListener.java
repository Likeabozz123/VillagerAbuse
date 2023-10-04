package xyz.gamars.villagerabuse.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.util.NumberConversions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class EntityDamageListener implements Listener {

    public static final Logger PluginLogger = org.bukkit.plugin.PluginLogger.getLogger("VillagerAbuse");

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Villager && event.getDamager() instanceof Player) {
            Villager villager = (Villager) event.getEntity();
            Player player = (((Player) event.getDamager()).getPlayer());
            // make emerald price inversely proportional to health

            List<MerchantRecipe> trades = new ArrayList<>();
            for (MerchantRecipe trade : villager.getRecipes()) {

                if (!(trade.getIngredients().get(1).getType() == Material.AIR)) {
                    List<ItemStack> ingredients = new ArrayList<>();
                    ingredients.add(new ItemStack(Material.DIAMOND, 20));
                    ingredients.add(new ItemStack(Material.DIAMOND, 20));
                    trade.setIngredients(ingredients);
                    trades.add(trade);


                } else {
                    List<ItemStack> ingredients = new ArrayList<>();
                    ingredients.add(new ItemStack(Material.DIAMOND, 20));
                    ingredients.add(new ItemStack(Material.AIR, 0));
                    trade.setIngredients(ingredients);
                    trades.add(trade);
                }
            }

            // find a way to get the new price after punching and or inflation

            villager.setRecipes(trades);

        }
    }

}
