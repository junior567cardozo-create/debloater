package com.debloater.app.data

object DebloatPackages {

    fun getForBrand(brand: String): List<String> {
        val b = brand.lowercase()
        val common = commonGoogle + commonAndroid
        return when {
            b.contains("xiaomi") || b.contains("redmi") || b.contains("poco") ->
                (common + xiaomi).distinct()
            b.contains("samsung") ->
                (common + samsung).distinct()
            b.contains("motorola") || b.contains("moto") ->
                (common + motorola).distinct()
            b.contains("realme") ->
                (common + realme).distinct()
            b.contains("oneplus") ->
                (common + oneplus).distinct()
            b.contains("lg") ->
                (common + lg).distinct()
            b.contains("sony") ->
                (common + sony).distinct()
            else ->
                common.distinct()
        }
    }

    // ── Google bloatware comum a todos ───────────────────────────────────────
    private val commonGoogle = listOf(
        "com.google.android.apps.photos",
        "com.google.android.gm",
        "com.google.android.tts",
        "com.google.android.marvin.talkback",
        "com.google.android.feedback",
        "com.google.android.partnersetup",
        "com.google.android.onetimeinitializer",
        "com.google.android.syncadapters.calendar",
        "com.google.android.ondevicepersonalization.services",
        "com.google.android.federatedcompute",
        "com.google.android.gms.location.history",
        "com.google.mainline.adservices",
        "com.google.mainline.telemetry",
        "com.google.android.health.connect.backuprestore",
        "com.google.android.healthconnect.controller",
        "com.google.android.apps.restore",
        "com.google.android.setupwizard"
    )

    // ── Android AOSP desnecessário ────────────────────────────────────────────
    private val commonAndroid = listOf(
        "com.android.dreams.basic",
        "com.android.dreams.phototable",
        "com.android.wallpaper.livepicker",
        "com.android.bookmarkprovider",
        "com.android.musicfx",
        "com.android.printspooler",
        "com.android.apps.tag"
    )

    // ── Xiaomi / MIUI / HyperOS / POCO ───────────────────────────────────────
    private val xiaomi = listOf(
        "com.miui.backup",
        "com.miui.aod",
        "com.miui.misound",
        "com.miui.vsimcore",
        "com.miui.phone.carriers.overlay.h3g",
        "com.miui.phone.carriers.overlay.vodafone",
        "com.xiaomi.continuity.sdkapp",
        "com.xiaomi.micloud.sdk",
        "com.xiaomi.aon",
        "com.microsoft.deviceintegrationservice",
        "com.microsoftsdk.crossdeviceservicebroker",
        "com.mediatek.voicecommand",
        "com.mediatek.voiceunlock",
        "com.mediatek.lbs.em2.ui",
        "com.mediatek.miravision.ui",
        "com.mediatek.ygps",
        "com.mediatek.engineermode",
        "com.miui.securityadd",
        "com.miui.mediaviewer"
    )

    // ── Samsung ───────────────────────────────────────────────────────────────
    private val samsung = listOf(
        "com.samsung.android.bixby.agent",
        "com.samsung.android.bixby.wakeup",
        "com.samsung.android.bixbyvision.framework",
        "com.samsung.android.app.spage",
        "com.samsung.android.game.gamehome",
        "com.samsung.android.game.gos",
        "com.samsung.android.game.gametools",
        "com.samsung.android.themestore",
        "com.samsung.android.app.tips",
        "com.samsung.android.app.watchmanagergearfit",
        "com.samsung.android.weather",
        "com.samsung.android.calendar",
        "com.samsung.android.email.provider",
        "com.sec.android.app.sbrowser",
        "com.sec.android.app.samsungapps",
        "com.samsung.android.mobileservice",
        "com.samsung.android.rubin.app",
        "com.samsung.android.app.routinesdummy",
        "com.samsung.android.messaging",
        "com.samsung.android.ardaemon",
        "com.samsung.android.app.ar.emoji.editor",
        "com.samsung.android.faceservice",
        "com.samsung.android.privateshare",
        "com.hiya.star"
    )

    // ── Motorola ──────────────────────────────────────────────────────────────
    private val motorola = listOf(
        "com.motorola.brapps",
        "com.motorola.ccc",
        "com.motorola.motosignin",
        "com.motorola.help",
        "com.motorola.targetnotif",
        "com.motorola.timeweatherwidget",
        "com.motorola.motodisplay",
        "com.motorola.actions",
        "com.motorola.audiomonitor",
        "com.motorola.demo",
        "com.motorola.MotCamera2",
        "com.amazon.appmanager",
        "com.amazon.mShop.android.shopping"
    )

    // ── Realme ────────────────────────────────────────────────────────────────
    private val realme = listOf(
        "com.heytap.market",
        "com.heytap.browser",
        "com.heytap.usercenter",
        "com.nearme.gamecenter",
        "com.coloros.weather2",
        "com.oppo.reader",
        "com.oplus.ovoice",
        "com.coloros.healthkit",
        "com.coloros.gamespaceui",
        "com.realme.linkboost",
        "com.coloros.note",
        "com.coloros.calendar"
    )

    // ── OnePlus ───────────────────────────────────────────────────────────────
    private val oneplus = listOf(
        "com.oneplus.brickmode",
        "com.oneplus.account",
        "com.oneplus.shelf",
        "net.oneplus.launcher",
        "com.oneplus.tips",
        "com.oneplus.weather",
        "com.oplus.ovoice",
        "com.oneplus.gamespace",
        "com.oneplus.healthservice"
    )

    // ── LG ───────────────────────────────────────────────────────────────────
    private val lg = listOf(
        "com.lge.clock",
        "com.lge.weather",
        "com.lge.qmemoplus",
        "com.lge.shutdownmonitor",
        "com.lge.smartshare",
        "com.lge.tv.smartshare",
        "com.lge.livesquare",
        "com.lge.appbox"
    )

    // ── Sony ──────────────────────────────────────────────────────────────────
    private val sony = listOf(
        "com.sonymobile.music",
        "com.sonymobile.album",
        "com.sonymobile.video",
        "com.sonymobile.androidapp.sociallife",
        "com.sonymobile.androidapp.skillconnect",
        "com.sonymobile.themes",
        "com.sonyericsson.predictions",
        "com.sonymobile.androidapp.facelocker"
    )
}
