package net.darkhax.tutorial.connected;

import net.darkhax.tutorial.connected.block.BlockConnectedTexture;
import net.darkhax.tutorial.connected.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "connected", name = "Connected Texture Tutorial", version = "1.9")
public class ConnectedTextureMod {
    
    @SidedProxy(clientSide = "net.darkhax.tutorial.connected.client.ClientProxy", serverSide = "net.darkhax.tutorial.connected.common.CommonProxy")
    public static CommonProxy proxy;
    
    @Instance("connected")
    public static ConnectedTextureMod instance;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent pre) {
        
        registerBlock(new BlockConnectedTexture(), "connected_cube");
    }
    
    private Block registerBlock (Block block, String ID) {
        
        block.setRegistryName(ID);
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block), block.getRegistryName());
        return block;
    }
}