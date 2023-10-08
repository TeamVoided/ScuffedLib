package org.teamvoided.scuffedlib.sign

import net.minecraft.client.resource.Material
import java.util.*

object MaterialRegistry {
    private val identifiers: MutableList<Material> =  ArrayList()
    val ids: Collection<Material> get() = Collections.unmodifiableList(identifiers)
    fun addId(sprite: Material) = identifiers.add(sprite)
}