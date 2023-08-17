package data.model.mapper

import com.example.domain.models.dota.Hero
import com.example.domain.models.dota.getHeroAttackType
import com.example.domain.models.dota.getHeroAttribute
import com.example.domain.models.dota.getHeroRole
import data.model.HeroDto
import data.remote.DotaHeroesApi


fun HeroDto.toHero(): Hero {
    return Hero(
        id = id,
        localizedName = localizedName,
        primaryAttribute = getHeroAttribute(abbreviation = primaryAttribute),
        attackType = getHeroAttackType(uiValue = attackType),
        roles = roles.map { getHeroRole(uiValue = it) },
        img = "${DotaHeroesApi.BASE_URL}$img",
        icon = "${DotaHeroesApi.BASE_URL}$icon",
        baseHealth = baseHealth,
        baseHealthRegen = baseHealthRegen,
        baseMana = baseMana,
        baseManaRegen = baseManaRegen,
        baseArmor = baseArmor,
        baseMoveRate = baseMoveRate,
        baseAttackMin = baseAttackMin,
        baseAttackMax = baseAttackMax,
        baseStr = baseStr,
        baseAgi = baseAgi,
        baseInt = baseInt,
        strGain = strGain,
        agiGain = agiGain,
        intGain = intGain,
        attackRange = attackRange,
        projectileSpeed = projectileSpeed,
        attackRate = attackRate,
        moveSpeed = moveSpeed,
        turnRate = turnRate,
        legs = legs,
        turboPicks = turboPicks,
        turboWins = turboWins,
        proWins = proWins ?: 0,
        proPick = proPick ?: 0,
        firstPick = firstPick,
        firstWin = firstWin,
        secondPick = secondPick,
        secondWin = secondWin,
        thirdPick = thirdPick,
        thirdWin = thirdWin,
        fourthPick = fourthPick,
        fourthWin = fourthWin,
        fifthPick = fifthPick,
        fifthWin = fifthWin,
        sixthPick = sixthPick,
        sixthWin = sixthWin,
        seventhPick = seventhPick,
        seventhWin = seventhWin,
        eighthWin = eighthWin,
        eighthPick = eighthPick
    )
}