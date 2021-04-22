package nc.proxy;

import nc.*;
import nc.block.*;
import nc.entity.*;
import nc.client.gui.*;
import nc.client.gui.generator.*;
import nc.client.gui.machine.*;
import nc.item.NCItems;
import nc.client.model.*;
import nc.client.render.*;
import nc.tile.accelerator.*;
import nc.tile.crafting.*;
import nc.tile.generator.*;
import nc.tile.machine.*;
import nc.tile.other.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.minecraftforge.client.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import static nc.NuclearCraft.logger;

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
			logger.info("successfuly invoked Clinet Gui Method");
			switch (ID) {
				case NuclearCraft.guiIdNuclearFurnace:
					return new GuiNuclearFurnace(player.inventory, (TileNuclearFurnace) entity);
				case NuclearCraft.guiIdFurnace:
					return new GuiFurnace(player.inventory, (TileFurnace) entity);
				case NuclearCraft.guiIdCrusher:
					return new GuiCrusher(player.inventory, (TileCrusher) entity);
				case NuclearCraft.guiIdElectricCrusher:
					return new GuiElectricCrusher(player.inventory, (TileElectricCrusher) entity);
				case NuclearCraft.guiIdElectricFurnace:
					return new GuiElectricFurnace(player.inventory, (TileElectricFurnace) entity);
				case NuclearCraft.guiIdReactionGenerator:
					return new GuiReactionGenerator(player.inventory, (TileReactionGenerator) entity);
				case NuclearCraft.guiIdSeparator:
					return new GuiSeparator(player.inventory, (TileSeparator) entity);
				case NuclearCraft.guiIdHastener:
					return new GuiHastener(player.inventory, (TileHastener) entity);
				case NuclearCraft.guiIdFissionReactorGraphite:
					return new GuiFissionReactor(player.inventory, (TileFissionReactor) entity);
				case NuclearCraft.guiIdNuclearWorkspace:
					return new GuiNuclearWorkspace(player.inventory, world, x, y, z, (TileNuclearWorkspace) entity);
				case NuclearCraft.guiIdCollector:
					return new GuiCollector(player.inventory, (TileCollector) entity);
				case NuclearCraft.guiIdFusionReactor:
					return new GuiFusionReactor(player.inventory, (TileFusionReactor) entity);
				case NuclearCraft.guiIdElectrolyser:
					return new GuiElectrolyser(player.inventory, (TileElectrolyser) entity);
				case NuclearCraft.guiIdOxidiser:
					return new GuiOxidiser(player.inventory, (TileOxidiser) entity);
				case NuclearCraft.guiIdIoniser:
					return new GuiIoniser(player.inventory, (TileIoniser) entity);
				case NuclearCraft.guiIdIrradiator:
					return new GuiIrradiator(player.inventory, (TileIrradiator) entity);
				case NuclearCraft.guiIdCooler:
					return new GuiCooler(player.inventory, (TileCooler) entity);
				case NuclearCraft.guiIdFactory:
					return new GuiFactory(player.inventory, (TileFactory) entity);
				case NuclearCraft.guiIdHeliumExtractor:
					return new GuiHeliumExtractor(player.inventory, (TileHeliumExtractor) entity);
				case NuclearCraft.guiIdSynchrotron:
					return new GuiSynchrotron(player.inventory, (TileSynchrotron) entity);
				case NuclearCraft.guiIdAssembler:
					return new GuiAssembler(player.inventory, (TileAssembler) entity);
				case NuclearCraft.guiIdFissionReactorSteam:
					return new GuiFissionReactorSteam(player.inventory, (TileFissionReactorSteam) entity);
				case NuclearCraft.guiIdFusionReactorSteam:
					return new GuiFusionReactorSteam(player.inventory, (TileFusionReactorSteam) entity);
				case NuclearCraft.guiIdRecycler:
					return new GuiRecycler(player.inventory, (TileRecycler) entity);
			}
		}
		logger.warn("failed to open Client GUI");
		return null;
	}

	/*
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		logger.error("why this Server method invoke from Client side?");
		return null;
	}
*/
	
	private void registerRenderThings() {
		// Nuclear Workspace
		TileEntitySpecialRenderer render = new RenderNuclearWorkspace();
		ClientRegistry.bindTileEntitySpecialRenderer(TileNuclearWorkspace.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.nuclearWorkspace),
				new ItemRenderNuclearWorkspace(render, new TileNuclearWorkspace()));

		// Fusion Reactor
		TileEntitySpecialRenderer renderfusion = new RenderFusionReactor();
		ClientRegistry.bindTileEntitySpecialRenderer(TileFusionReactor.class, renderfusion);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.fusionReactor),
				new ItemRenderFusionReactor(renderfusion, new TileFusionReactor()));

		// Fusion Reactor Steam
		TileEntitySpecialRenderer renderfusionSteam = new RenderFusionReactorSteam();
		ClientRegistry.bindTileEntitySpecialRenderer(TileFusionReactorSteam.class, renderfusionSteam);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.fusionReactorSteam),
				new ItemRenderFusionReactorSteam(renderfusionSteam, new TileFusionReactorSteam()));

		// Tubing 1
		TileEntitySpecialRenderer render1 = new RenderTubing1();
		ClientRegistry.bindTileEntitySpecialRenderer(TileTubing1.class, render1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.tubing1),
				new ItemRenderTubing1(render1, new TileTubing1()));

		// Tubing 2
		TileEntitySpecialRenderer render2 = new RenderTubing2();
		ClientRegistry.bindTileEntitySpecialRenderer(TileTubing2.class, render2);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NCBlocks.tubing2),
				new ItemRenderTubing2(render2, new TileTubing2()));

		// Nuke Primed
		RenderingRegistry.registerEntityRenderingHandler(EntityNukePrimed.class, new RenderNukePrimed());

		// EMP Primed
		RenderingRegistry.registerEntityRenderingHandler(EntityEMPPrimed.class, new RenderEMPPrimed());

		// Antimatter Bomb Primed
		RenderingRegistry.registerEntityRenderingHandler(EntityAntimatterBombPrimed.class,
				new RenderAntimatterBombPrimed());

		// Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityNuclearMonster.class,
				new RenderNuclearMonster(new ModelNuclearMonster(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPaul.class, new RenderPaul(new ModelPaul(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBrian.class, new RenderBrian(new ModelBrian(), 1.0F));

		// Nuclear Grenade
		RenderingRegistry.registerEntityRenderingHandler(EntityNuclearGrenade.class,
				new RenderSnowball(NCItems.nuclearGrenadeThrown));

		// DU Bullet
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
	}

}
