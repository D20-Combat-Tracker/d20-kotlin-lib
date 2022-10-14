package org.d20CombatTracker.kotlin.lib

import kotlin.math.max
import kotlin.math.min

enum class AbilityType {
    STRENGTH,
    DEXTERITY,
    ENDURANCE,
    INTELLIGENCE,
    WISDOM,
    CHARISMA
}

class StatSheet(
    strength: Int,
    dexterity: Int,
    endurance: Int,
    intelligence: Int,
    wisdom: Int,
    charisma: Int
) {
    private var strength = strength
        set(newScore) { field = setAbilityScore(newScore) }
    private var dexterity = dexterity
        set(newScore) { field = setAbilityScore(newScore) }
    private var endurance = endurance
        set(newScore) { field = setAbilityScore(newScore) }
    private var intelligence = intelligence
        set(newScore) { field = setAbilityScore(newScore) }
    private var wisdom = wisdom
        set(newScore) { field = setAbilityScore(newScore) }
    private var charisma = charisma
        set(newScore) { field = setAbilityScore(newScore) }

    companion object {
        fun getAbilityScore(statSheet: StatSheet, abilityType: AbilityType): Int {
            return statSheet.getAbilityScore(abilityType)
        }
        fun getModifier(abilityScore: Int): Int {
            return (abilityScore - 10) / 2
        }
    }
    fun getAbilityScore(abilityType: AbilityType): Int {
        return when(abilityType) {
            AbilityType.STRENGTH -> this.strength
            AbilityType.DEXTERITY -> this.dexterity
            AbilityType.ENDURANCE -> this.endurance
            AbilityType.INTELLIGENCE -> this.intelligence
            AbilityType.WISDOM -> this.wisdom
            AbilityType.CHARISMA -> this.charisma
        }
    }

    fun getAbilityModifier(abilityType: AbilityType): Int {
        return StatSheet.getModifier(this.getAbilityScore(abilityType))
    }

    private fun setAbilityScore(newScore: Int): Int = if (newScore > 0) {
        min(newScore, 30)
    } else {
        max(newScore, 0)
    }
}

fun defaultStatSheet(): StatSheet {
    return StatSheet(0, 0, 0, 0, 0, 0)
}