package nc;

public final class Reference {
    public static final String MOD_NAME = "NuclearCraft";
    public static final String MOD_ID = "NuclearCraft";
    public static final String MINECRAFT_VERSION = "1.7.10";
    public static final String VER_MAJOR = "@MAJOR@";
    public static final String VER_MINOR = "@MINOR@";
    public static final String VER_REVIS = "@REVIS@";
    public static final String MOD_VERSION = VER_MAJOR + "." + VER_MINOR + "." + VER_REVIS;
    public static final String VERSION = MINECRAFT_VERSION + "-" + MOD_VERSION;
    public static final String DEPENDENCY = "required-"+"after:"+""+";"+
    										"required-"+"before:"+""+";";
    public static final String CLIENT_PROXY_CLASS = "nc.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "nc.proxy.CommonProxy";
    public static final String GUI_FACTORY_CLASS = "nc.AgriCraft.gui.GuiFactory";
}
