package moe.feo.ponzischeme.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class GUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player))
            return;// 如果不是玩家操作的，返回
        Player player = (Player) event.getWhoClicked();
        InventoryHolder holder = player.getOpenInventory().getTopInventory().getHolder();
        //mainpage逻辑
        if (holder instanceof MainPage.PonziSchemeGUIHolder) {
            event.setCancelled(true);
            // TODO 主GUI点击相关逻辑
            //毒土豆 即bbs任务
            if (event.getCurrentItem().getType()== Material.POISONOUS_POTATO){
                //简单判断类型为毒土豆，不应该把这个判断当做唯一标准
                //如果有多个任务 应该自己写出所有判断
                //此外 描述以及物品名称未定义
                TaskGuiPage taskGuiPage = new TaskGuiPage("bbs");
                taskGuiPage.openGui(player);
                //阻止物品拿出
                event.setCancelled(true);
            }
            //书与笔 b站任务
            if (event.getCurrentItem().getType()== Material.WRITABLE_BOOK){
                TaskGuiPage taskGuiPage = new TaskGuiPage("bili");
                taskGuiPage.openGui(player);

            }
        }

        if (holder instanceof TaskGuiPage.PonziSchemeGUIHolder){
            event.setCancelled(true);
            //TODO 任务GUI点击相关逻辑
            //纸为论坛回复，下界合金升级模板为bili点赞，海洋之心为bili投币，箱子为bili收藏
            //论坛回复任务
            if (event.getCurrentItem().getType()==Material.PAPER){
                //TODO 点击领取奖励的逻辑
            }

            if (event.getCurrentItem().getType()==Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE||event.getCurrentItem().getType()==Material.HEART_OF_THE_SEA||event.getCurrentItem().getType()==Material.CHEST){
                //TODO 点击领取奖励的逻辑
            }
        }
    }
}
