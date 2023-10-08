package org.teamvoided.scuffedlib

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.type.BlockSetTypeRegistry
import net.fabricmc.fabric.api.`object`.builder.v1.block.type.WoodTypeRegistry
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.client.render.TexturedRenderLayers
import net.minecraft.client.resource.Material
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.item.SignItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.scuffedlib.sign.MaterialRegistry
import org.teamvoided.scuffedlib.sign.block.VoidSignBlock
import org.teamvoided.scuffedlib.sign.block.VoidWallSignBlock

object ScuffedLib {
    const val MOD_ID = "scuffedlib"
    val LOGGER: Logger = LoggerFactory.getLogger(ScuffedLib::class.java)

    val CUSTOM_PLANKS_ID = Identifier(MOD_ID, "custom_planks")
    private val blocks: Set<Block> = setOf()


    private val SIGN_TEXTURE_ID = Identifier(MOD_ID, "entity/signs/custom")
    private val CUSTOM_SIGN_ID = Identifier(MOD_ID, "custom_sign")
    private val CUSTOM_WALL_SIGN_ID = Identifier(MOD_ID, "custom_wall_sign")


    private val CUSTOM_BLOCK_SET_TYPE = BlockSetTypeRegistry.registerWood(Identifier(MOD_ID, "custom"))
    private val CUSTOM_WOOD_TYPE = WoodTypeRegistry.register(Identifier(MOD_ID, "custom"), CUSTOM_BLOCK_SET_TYPE)

    @Suppress("unused")
    fun commonInit() {
        LOGGER.info("Hello from commonInit")

        // Signs
        val sign: Block = VoidSignBlock(SIGN_TEXTURE_ID, FabricBlockSettings.copyOf(Blocks.OAK_SIGN), CUSTOM_WOOD_TYPE)
        val wallSign: Block =
            VoidWallSignBlock(SIGN_TEXTURE_ID, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN), CUSTOM_WOOD_TYPE)

        val signItem: Item = SignItem(Item.Settings().maxCount(16), sign, wallSign)

        blocks.plus(sign)

        Registry.register(Registries.BLOCK, CUSTOM_SIGN_ID, sign)
        Registry.register(Registries.BLOCK, CUSTOM_WALL_SIGN_ID, wallSign)

        Registry.register(Registries.ITEM, CUSTOM_SIGN_ID, signItem)

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS )
            .register(ItemGroupEvents.ModifyEntries { it.addAfter(Items.BAMBOO_HANGING_SIGN, signItem) })
    }

    @Suppress("unused")
    fun clientInit() {
        LOGGER.info("Hello from clientInit")
        MaterialRegistry.addId(Material(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, SIGN_TEXTURE_ID))
    }
}