package cz.osu;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * The wrapper class for localizing.
 */
public class Localizer {

    /**
     * Current language of the application.
     */
    private Language currentLanguage;

    /**
     * The map of all words in given langauge.
     */
    private Map<String, String> languageMap;

    /**
     * Creates a localizer with detected system language.
     */
    public Localizer() {
        detectLanguage();
        initLanguage();
    }

    /**
     * Creates a localizer with given {@code currentLanguage}.
     * @param currentLanguage The given language.
     */
    public Localizer(Language currentLanguage) {
        this.currentLanguage = currentLanguage;
        initLanguage();
    }

    private void detectLanguage() {
        Locale currentLocale = Locale.getDefault();
        String localeLanguage = currentLocale.getISO3Language();

        saveLanguage(localeLanguage);
    }

    /**
     * Saves the language according to the system language. If the language is not recognized, the ENGLISH version is set.
     * @param localeLanguage The system language.
     */
    private void saveLanguage(String localeLanguage) {
        try {
            currentLanguage = Language.valueOf(localeLanguage.toUpperCase());
        }

        catch (IllegalArgumentException ex) {
            System.out.println("The system language is not found. The english version is set.");
            currentLanguage = Language.ENG;
        }
    }

    /**
     * Inits languages according to selected language.
     */
    private void initLanguage() {
        this.languageMap = new HashMap<>();

        // Checks what language is selected and init corresponding map
        if (this.currentLanguage == Language.CES)
            initCzechLanguage();

        else
            initEnglishLanguage();
    }

    /**
     * Inits the czech language words.
     */
    private void initCzechLanguage() {
        languageMap.put("File","Soubor");
        languageMap.put("Directory","Složka");
        languageMap.put("Window","Okno");
        languageMap.put("Display","Obrazovka");
        languageMap.put("Keyboard","Klávesnice");
        languageMap.put("Store","Obchod");
        languageMap.put("Library","Knihovna");
        languageMap.put("Community", "Komunita");
        languageMap.put("AddGame","Přidat hru");
        languageMap.put("Download", "Stahování");
        languageMap.put("FriendList","Seznam přátel");
    }

    /**
     * Inits the english language words.
     */
    private void initEnglishLanguage() {
        this.languageMap.put("File", "File");
        languageMap.put("Directory","Directory");
        languageMap.put("Window","Window");
        languageMap.put("Display","Display");
        languageMap.put("Keyboard","Keyboard");
        languageMap.put("Store","Store");
        languageMap.put("Library","Library");
        languageMap.put("Community", "Community");
        languageMap.put("AddGame","Add Game");
        languageMap.put("Download", "Download");
        languageMap.put("FriendList","Friends list");
    }

    /**
     * Prints whole dictionary.
     */
    public void printWords() {
        System.out.println(this.languageMap);
    }

    public String getValue(String key) {
        return languageMap.get(key);
    }
}
