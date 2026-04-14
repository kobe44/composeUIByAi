package com.example.exchange.base.router

/**
 * 全应用 ARouter 路径集中管理。
 *
 * 注意：多模块下 **path 的第一段**会生成 `ARouter$$Group$$xxx`，同一段在不同模块会 Dex 冲突，
 * 因此每个业务模块必须使用不同的首段（例如 `/login/...`、`/user/...`，不要用多个 `/common/...`）。
 */
object RoutePath {

    object Login {
        const val PAGE = "/login/main"
    }

    object User {
        const val PAGE = "/user/main"
    }

    object Asset {
        const val PAGE = "/asset/main"
    }

    object Notify {
        const val PAGE = "/notify/main"
    }

    object Market {
        const val PAGE = "/market/main"
    }

    /** 商城 Demo（Fake Store API + 本地购物车） */
    object Mall {
        const val PAGE = "/mall/main"
    }

    object Trade {
        const val PAGE = "/trade/main"
    }

    object Otc {
        const val PAGE = "/otc/main"
    }

    object Finance {
        const val PAGE = "/finance/main"
    }
}
