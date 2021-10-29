package com.oveln.elements.utils

import taboolib.module.configuration.Config
import taboolib.module.configuration.SecuredFile

object Config {
    @Config(value = "config.yml")
    lateinit var conf: SecuredFile
        private set
    @Config(value = "moudule.yml")
    lateinit var Moudele: SecuredFile
        private set
}