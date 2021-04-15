package nc.proxy;

import nc.block.NCBlocks;
import nc.entity.EntityAntimatterBombPrimed;
import nc.entity.EntityBrian;
import nc.entity.EntityBullet;
import nc.entity.EntityEMPPrimed;
import nc.entity.EntityNuclearGrenade;
import nc.entity.EntityNuclearMonster;
import nc.entity.EntityNukePrimed;
import nc.entity.EntityPaul;
import nc.client.gui.*;
import nc.client.gui.generator.*;
import nc.client.gui.machine.*;
import nc.item.NCItems;
import nc.client.model.*;
import nc.client.render.*;
import nc.tile.accelerator.TileSynchrotron;
import nc.tile.crafting.TileNuclearWorkspace;
import nc.tile.generator.*;
import nc.tile.machine.*;
import nc.tile.other.TileTubing1;
import nc.tile.other.TileTubing2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInitalize() {
		super.preInitalize();
		this.registerRenderThings();
	}
	
	@Override
	public void initialize() {
		super.initialize();
	}
	
	@Override
	public void postInitalize() {
		super.postInitalize();
	}
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if (entity != null) {
			switch(ID) {
				case 0:
					if(entity instanceof TileNuclearFurnace) return new GuiNuclearFurnace(player.inventory, (TileNuclearFurnace) entity);
					return null;
				case 1:
					if(entity instanceof TileFurnace) return new GuiFurnace(player.inventory, (TileFurnace) entity);
					return null;
				case 2:
					if(entity instanceof TileCrusher) return new GuiCrusher(player.inventory, (TileCrusher) entity);
					return null;
				case 3:
					if(entity instanceof TileElectricCrusher) return new GuiElectricCrusher(player.inventory, (TileElectricCrusher) entity);
					return null;
				case 4:
					if(entity instanceof TileElectricFurnace) return new GuiElectricFurnace(player.inventory, (TileElectricFurnace) entity);
					return null;
				case 5:
					if(entity instanceof TileReactionGenerator) return new GuiReactionGenerator(player.inventory, (TileReactionGenerator) entity);
					return null;
				case 6:
					if(entity instanceof TileSeparator) return new GuiSeparator(player.inventory, (TileSeparator) entity);
					return null;
				case 7:
					if(entity instanceof TileHastener) return new GuiHastener(player.inventory, (TileHastener) entity);
					return null;
				case 8:
					if(entity instanceof TileFissionReactor) return new GuiFissionReactor(player.inventory, (TileFissionReactor) entity);
					return null;
				case 9:
					if(entity instanceof TileNuclearWorkspace) return new GuiNuclearWorkspace(player.inventory, world, x, y, z, (TileNuclearWorkspace) entity);
					return null;
				case 10:
					if(entity instanceof TileCollector) return new GuiCollector(player.inventory, (TileCollector) entity);
					return null;
				case 11:
					if(entity instanceof TileFusionReactor) return new GuiFusionReactor(player.inventory, (TileFusionReactor) entity);
					return null;
				case 12:
					if(entity instanceof TileElectrolyser) return new GuiElectrolyser(player.inventory, (TileElectrolyser) entity);
					return null;
				case 13:
					if(entity instanceof TileOxidiser) return new GuiOxidiser(player.inventory, (TileOxidiser) entity);
					return null;
				case 14:
					if(entity instanceof TileIoniser) return new GuiIoniser(player.inventory, (TileIoniser) entity);
					return null;
				case 15:
					if(entity instanceof TileIrradiator) return new GuiIrradiator(player.inventory, (TileIrradiator) entity);
					return null;
				case 16:
					if(entity instanceof TileCooler) return new GuiCooler(player.inventory, (TileCooler) entity);
					return null;
				case 17:
					if(entity instanceof TileFactory) return new GuiFactory(player.inventory, (TileFactory) entity);
					return null;
				case 18:
					if(entity instanceof TileHeliumExtractor) return new GuiHeliumExtractor(player.inventory, (TileHeliumExtractor) entity);
					return null;
				case 19:
					if(entity instanceof TileSynchrotron) return new GuiSynchrotron(player.inventory, (TileSynchrotron) entity);
					return null;
				case 20:
					if(entity instanceof TileAssembler) return new GuiAssembler(player.inventory, (TileAssembler) entity);
					return null;
				case 21:
					if(entity instanceof TileFissionReactorSteam) return new GuiFissionReactorSteam(player.inventory, (TileFissionReactorSteam) entity);
					return null;
				case 22:
					if(entity instanceof TileFusionReactorSteam) return new GuiFusionReactorSteam(player.inventory, (TileFusionReactorSteam) entity);
					return null;
				case 23:
					if(entity instanceof TileRecycler) return new GuiRecycler(player.inventory, (TileRecycler) entity);
					return null;
			}
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	private void registerRenderThings() {
		//Nuclear Workspace
		TileEntitySpecialRenderer render = new RenderNuclearWorkspace();
		ClientRegistry.bindTileEntitySpecialRenderer(TileNuclearWorkspace.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.nuclearWorkspace), new ItemRenderNuclearWorkspace(render, new TileNuclearWorkspace()));
		
		//Fusion Reactor
		TileEntitySpecialRenderer renderfusion = new RenderFusionReactor();
		ClientRegistry.bindTileEntitySpecialRenderer(TileFusionReactor.class, renderfusion);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.fusionReactor), new ItemRenderFusionReactor(renderfusion, new TileFusionReactor()));
		
		//Fusion Reactor Steam
		TileEntitySpecialRenderer renderfusionSteam = new RenderFusionReactorSteam();
		ClientRegistry.bindTileEntitySpecialRenderer(TileFusionReactorSteam.class, renderfusionSteam);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.fusionReactorSteam), new ItemRenderFusionReactorSteam(renderfusionSteam, new TileFusionReactorSteam()));

		//Tubing 1
		TileEntitySpecialRenderer render1 = new RenderTubing1();
		ClientRegistry.bindTileEntitySpecialRenderer(TileTubing1.class, render1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.tubing1), new ItemRenderTubing1(render1, new TileTubing1()));
				
		//Tubing 2
		TileEntitySpecialRenderer render2 = new RenderTubing2();
		ClientRegistry.bindTileEntitySpecialRenderer(TileTubing2.class, render2);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.tubing2), new ItemRenderTubing2(render2, new TileTubing2()));
		
		//Nuke Primed
		RenderingRegistry.registerEntityRenderingHandler(EntityNukePrimed.class, new RenderNukePrimed());
		
		//EMP Primed
		RenderingRegistry.registerEntityRenderingHandler(EntityEMPPrimed.class, new RenderEMPPrimed());
		
		//Antimatter Bomb Primed
		RenderingRegistry.registerEntityRenderingHandler(EntityAntimatterBombPrimed.class, new RenderAntimatterBombPrimed());
		
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityNuclearMonster.class, new RenderNuclearMonster(new ModelNuclearMonster(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPaul.class, new RenderPaul(new ModelPaul(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBrian.class, new RenderBrian(new ModelBrian(), 1.0F));
		
		//Nuclear Grenade
		RenderingRegistry.registerEntityRenderingHandler(EntityNuclearGrenade.class, new RenderSnowball(NCItems.nuclearGrenadeThrown));
		
		//DU Bullet
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
	}

}
