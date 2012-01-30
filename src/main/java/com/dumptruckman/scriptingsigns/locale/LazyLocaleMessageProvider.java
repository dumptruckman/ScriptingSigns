package com.dumptruckman.scriptingsigns.locale;

import java.util.Locale;
import java.util.Set;

/**
 * Multiverse 2 LazyMessageProvider
 * <p/>
 * This interface describes a Multiverse-MessageProvider that only loads locales when they're needed.
 */
public interface LazyLocaleMessageProvider extends MessageProvider {

    /**
     * Loads a localization for a specified {@link java.util.Locale}.
     * <p/>
     * If that localization is already loaded, this method will reload it.
     *
     * @param locale The desired {@link java.util.Locale}.
     * @throws LocalizationLoadingException When an error occurs while trying to load the specified localization.
     * @throws NoSuchLocalizationException  When no localization was found for the desired locale.
     */
    void loadLocale(Locale locale) throws NoSuchLocalizationException, // SUPPRESS CHECKSTYLE: Redundant
            LocalizationLoadingException; // SUPPRESS CHECKSTYLE: Redundant

    /**
     * Retrieves all loaded localizations.
     *
     * @return A {@link java.util.Set} of {@link java.util.Locale}s whose localizations are currently loaded.
     */
    Set<Locale> getLoadedLocales();

    /**
     * Detects if a localization is loaded for the specified {@link java.util.Locale}.
     *
     * @param locale The {@link java.util.Locale}.
     * @return Whether a localization is loaded for the specified {@link java.util.Locale}.
     */
    boolean isLocaleLoaded(Locale locale);

}

