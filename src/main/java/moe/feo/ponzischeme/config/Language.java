package moe.feo.ponzischeme.config;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public enum Language {

    PREFIX("prefix"),
    ENABLE("enable"),
    RELOAD("reload"),
    FAILEDCONNECTSQL("failedconnectsql"),
    NOPERMISSION("nopermission"),
    INVALID("invalid"),
    INVALIDNUM("invalidnum"),
    PLAYERCMD("playercmd"),
    NONE("none"),
    GUI_TITLE("gui.title"),
    GUI_FRAME("gui.frame"),
    GUI_SKULL("gui.skull"),
    GUI_BILIBILI("gui.bilibili"),
    GUI_FLARUM("gui.flarum"),
    HELP_TITLE("help.title"),
    HELP_HELP("help.help"),
    HELP_BINDING("help.binding"),
    HELP_READER("help.reader"),
    HELP_RELOAD("help.reload");

    private static FileConfiguration config;
    private final String path;

    /**
     * @param path
     * 此项语言的路径
     */
    Language(String path) {
        this.path = path;
    }

    /**
     * 加载语言文件
     */
    public static void load() {
        String lang = Config.LANG.getString();
        String fileName = "lang/" + lang + ".yml";
        config = ConfigUtil.load(fileName);
    }

    /**
     * 保存默认的语言文件
     */
    public static void saveDefault() {
        ConfigUtil.saveDefault("lang/zh_cn.yml");
    }

    /**
     * 获取字符串，并转换样式代码
     * @return 最终的字符串
     */
    public String getString() {
        String string = config.getString(path);
        if (string != null){
            string = ChatColor.translateAlternateColorCodes('&', string);
        }
        return string;
    }

    /**
     * 获取字符串list，并转换每个元素的样式代码
     * @return 最终的字符串list
     */
    public List<String> getStringList() {
        List<String> list = new ArrayList<>();
        List<String> source = config.getStringList(path);
        for (String string : source) {
            list.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        return list;
    }
}
