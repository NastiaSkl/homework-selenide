package io.react.realworldapp.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env"})

public interface BrowserConfiguration extends Config {

    @DefaultValue("io.react.realworldapp.browser_providers.ChromeWebDriverProvider")
    @Key("remote.browser")
    String remoteChrome();
    @DefaultValue("io.react.realworldapp.browser_providers.FirefoxWebDriverProvider")
    @Key("remote.firefox")
    String remoteFirefox();

}
