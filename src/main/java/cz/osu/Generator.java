package cz.osu;

import java.util.Random;

public class Generator {

    /**
     * The 'database' of all man names.
     */
    private static String[] namesMen = {
            "﻿Abd Alláh", "Abdon", "Ábel", "Abelard", "Abrahám", "Absolón", "Adalbert", "Adam", "Adin", "Adolf", "Adrián", "Agaton",
            "Agne", "Agrippa", "Ahmed", "Achil", "Aidan", "Ailill", "Aladin", "Alan", "Alban", "Alberich", "Albert", "Albín", "Aldo",
            "Aleš", "Alexandr", "Alexej", "Alfons", "Alfréd", "Alois", "Alva", "Alvar", "Alvin", "Amadeus", "Amand", "Amatus", "Ambrož",
            "Amos", "Anatol", "Andělín", "Andrea", "Andreas", "Andrej", "Angus", "Anselm", "Antal", "Antonín", "Aram", "Ariel", "Aristid",
            "Aristides", "Arje", "Arkád", "Armand", "Armin", "Arne", "Arnold", "Arnošt", "Áron", "Arpád", "Arsen", "Artur", "Ashley", "Atanas",
            "Atila", "August", "Augustin", "Aurel", "Avital", "Axel", "Azrael", "Baltazar", "Barabáš", "Barnabáš", "Bartoloměj", "Basil",
            "Bedřich", "Benedikt", "Benjamín", "Beno", "Bernard", "Bertold", "Bertram", "Bivoj", "Blahomil", "Blahomír", "Blahoslav", "Blažej",
            "Bohdan", "Bohuchval", "Bohumil", "Bohumír", "Bohuslav", "Bohuš", "Bojan", "Bolemír", "Boleslav", "Bonaventura", "Bonifác", "Boris",
            "Borislav", "Bořek", "Bořivoj", "Boyan", "Božetěch", "Božidar", "Branimír", "Bratislav", "Bronislav", "Bruno", "Břetislav", "Budimír",
            "Budislav", "Budivoj", "Caesar", "Callum", "Cato", "Cecil", "Celestýn", "Ciarán", "Ctibor", "Ctirad", "Ctislav", "Cyprián", "Cyril",
            "Čeněk", "Česlav", "Čestmír", "Dag", "Dalemil", "Dalibor", "Dalimil", "Daniel", "Dara", "Dareios", "Dáreios", "David", "Denis", "Dětřich",
            "Dezider", "Dimitris", "Diviš", "Dobroslav", "Dominik", "Dorian", "Drahoslav", "Dustin", "Dušan", "Edmund", "Edric", "Eduard", "Edwulf",
            "Egon", "Ehud", "Ejtan", "Eli", "Elias", "Eliáš", "Eliezer", "Elíša", "Emanuel", "Emil", "Erik", "Eskil", "Evan", "Evžen", "Ezra", "Fabian",
            "Felix", "Ferdinand", "Filibert", "Filip", "Florián", "František", "Gabriel", "Gandalf", "Gilbert", "Godric", "Gorazd", "Gracián",
            "Gustav", "Hadrián", "Hanno", "Hanuš", "Harald", "Havel", "Helmut", "Henoch", "Herbert", "Heřman", "Honor", "Honza", "Horymír",
            "Hubert", "Hugo", "Hynek", "Chajim", "Chandra", "Cheyenne", "Chrudoš", "Chrysostomos", "Chřen", "Chuck", "Ignác", "Igor", "Ilja",
            "Ingemar", "Ireneus", "Isá", "Isaiah", "Ivan", "Ivar", "Ivo", "Izmael", "Ja'ir", "Jáchym", "Jakub", "Jan", "Jan Nepomuk", "Jarda", "Jarmil",
            "Jaromír", "Jaroslav", "Jasan", "Jedidja", "Jelle", "Jeremiáš", "Jeroným", "Ježíš", "Jicchak", "Jimram", "Jindřich", "Jiří", "Jišaj", "Johann",
            "Jonáš", "Jonatán", "Josef", "Joshua", "Josiah", "Josselin", "Jost", "Juda", "Julius", "Juraj", "Kajetán", "Kamil", "Karel", "Kasper", "Kašpar",
            "Kazimír", "Ken", "Kevin", "Kilián", "Klement", "Kleofáš", "Konrád", "Kristián", "Kryšpín", "Kryštof", "Květoslav", "Kvido", "Ladislav", "Lazar",
            "Leo", "Leopold", "Leoš", "Lev", "Levi", "Libor", "Lindsay", "Liron", "Lubomír", "Lubor", "Luboš", "Lucian", "Luděk", "Ludomír", "Ludvík", "Lugh",
            "Lukáš", "Luke", "Lumír", "Lyric", "Mahpíya", "Marcel", "Marek", "Marian", "Marius", "Mark", "Martin", "Mařík", "Matěj", "Matouš", "Matyáš", "Maxim",
            "Maxmilián", "Me'ir", "Mečislav", "Medard", "Melichar", "Menachem", "Merlin", "Metoděj", "Michail", "Michal", "Micheáš", "Mikuláš", "Milan", "Miloslav",
            "Miloš", "Mirek", "Miroslav", "Misha", "Mischa", "Mnislav", "Moe", "Mojmír", "Mořic", "Moše", "Narcis", "Nathanael", "Nelson", "Nikola", "Ninoslav",
            "Noah", "Norbert", "Odin", "Oldřich", "Oleg", "Oliver", "Ondřej", "Orlando", "Oskar", "Osmund", "Oswald", "Otakar", "Otmar", "Oto", "Padma", "Pankrác",
            "Patrik", "Pavel", "Pax", "Peregrin", "Petr", "Pipin", "Pius", "Pravoslav", "Predrag", "Prokop", "Přemysl", "Přibyslav", "Quentin", "Radan", "Radek",
            "Radim", "Radmil", "Radomil", "Radomír", "Radoslav", "Radovan", "Radu", "Radúz", "Rafael", "Raimund", "Ralf", "Ratibor", "Ratmír", "Reinhard", "Reinhardt",
            "René", "Richard", "Robert", "Robin", "Rodan", "Roderik", "Roland", "Roman", "Ron", "Rónán", "Rosamund", "Rostislav", "Ruben", "Rudolf", "Ryuu", "Řehoř",
            "Salvátor", "Samay", "Samer", "Samir", "Samuel", "Sanjay", "Saturnin", "Sáva", "Sebastian", "Sergej", "Servác", "Seth", "Silvestr", "Simcha", "Slávek",
            "Slavoj", "Slavomír", "Snorri", "Soběslav", "Stanislav", "Svatopluk", "Svatoslav", "Sven", "Synové hromu", "Šabtaj", "Šimon", "Štefan", "Štěpán", "Tadao",
            "Tadeáš", "Taras", "Tarsicius", "Teobald", "Teodor", "Thea", "Theodorik", "Thorsten", "Tibor", "Timoteus", "Tobiáš", "Toby", "Tomáš", "Tomislav", "Tristan",
            "Urban", "Václav", "Valdemar", "Valentýn", "Vasil", "Vavřinec", "Věnceslav", "Vendelín", "Věroslav", "Viktor", "Vilém", "Vincenc", "Vít", "Vítězslav", "Vlad",
            "Vladan", "Vladimír", "Vladislav", "Vladivoj", "Vlasta", "Vlastibor", "Vlastimil", "Vlastimír", "Vlastislav", "Vojtěch", "Vratislav", "Walter", "Wilmar",
            "Winfred", "Xaver", "Zachariáš", "Záviš", "Zbyněk", "Zbyslav", "Zbyšek", "Zdeněk", "Zdislav", "Zikmund", "Zoltán", "Zvonimír"
    };

    /**
     * The 'database' of all woman names.
     */
    private static String[] namesWomen = {
            "﻿Aba", "Abigail", "Adéla", "Adelaida", "Adina", "Adriana", "Ælfgifu", "Afra", "Agáta", "Aglaja", "Aida", "Aimée", "Aisha", "Aisling", "Alaia",
            "Alana", "Alannah", "Albína", "Alena", "Alexandra", "Alexia", "Alice", "Alida", "Alina", "Alma", "Aloisie", "Alruna", "Alžběta", "Amaia", "Amálie",
            "Amanda", "Amáta", "Amélie", "Anabela", "Anastázie", "Anděla", "Andrea", "Aneta", "Anežka", "Angelika", "Anita", "Anja", "Anna", "Annika", "Antonie",
            "Aoife", "Apolena", "Arabela", "Aranka", "Areta", "Ariana", "Arleta", "Armida", "Arna", "Ásdís", "Åshild", "Ashley", "Astrid", "Atanázie", "Augustina",
            "Aurélie", "Aurora", "Ava", "Avital", "Aya", "Babeta", "Barbora", "Beáta", "Beatrice", "Bébinn", "Bedřiška", "Bela", "Běla", "Belinda", "Berenika",
            "Bernadeta", "Berta", "Bertolda", "Betty", "Bianka", "Bibiana", "Birgit", "Blahoslava", "Blanka", "Blažena", "Bohdana", "Bohumila", "Bohuslava", "Bojana",
            "Božena", "Božidara", "Branwen", "Brigita", "Bronislava", "Caoimhe", "Carmen", "Cecílie", "Celestina", "Dafné", "Dagmar", "Dahlia", "Dana", "Danica",
            "Daniela", "Dara", "Darina", "Darja", "Debora", "Delia", "Delíla", "Denisa", "Diana", "Dina", "Dita", "Dobromila", "Dobroslava", "Dominga", "Dominika",
            "Dora", "Dorota", "Doubravka", "Drahomila", "Drahomíra", "Drahoslava", "Drusila", "Durancie", "Džamila", "Edeltrud", "Edita", "Eithne", "Ela", "Elektra",
            "Elena", "Eleonora", "Elfryd", "Eliška", "Ella", "Elodie", "Elvíra", "Ema", "Emanuela", "Emílie", "Éowyn", "Epona", "Erika", "Erin", "Erlea", "Esmeralda",
            "Ester", "Ethel", "Euniké", "Eva", "Evelína", "Evženie", "Eydís", "Fatima", "Filipa", "Fiona", "Flora", "Františka", "Freya", "Gabriela", "Gaia", "Galina",
            "Gerda", "Gertruda", "Gita", "Gizela", "Gloria", "Grace", "Gráinne", "Gulnar", "Gvendolin", "Hana", "Hannah", "Hedvika", "Heidi", "Helena", "Hermína", "Hermiona",
            "Holly", "Honor", "Hortenzie", "Hvězdoslava", "Chandra", "Charlotte", "Chelsea", "Cheyenne", "Chloe", "Ida", "Idunn", "Idunn", "Ignácie", "Ilona", "Imogen",
            "Ingeborg", "Ingrid", "Irena", "Iris", "Irma", "Irmhild", "Isolde", "Iška", "Iva", "Ivana", "Iveta", "Ivona", "Izabela", "Jana", "Janine", "Jarmila", "Jaromíra",
            "Jaroslava", "Jasmína", "Jasna", "Jelena", "Jennifer", "Jenovefa", "Jessika", "Jindřiška", "Jiřina", "Jitka", "Johana", "Jolana", "Jolanta", "Jordanka", "Jorga",
            "Jorunn", "Josefina", "Josselin", "Judita", "Julie", "Justina", "Kaja", "Kamila", "Karina", "Karla", "Karolína", "Kassandra", "Kateřina", "Kayla", "Kazi", "Keiko",
            "Kimberly", "Klára", "Klaudie", "Klementina", "Kleopatra", "Klotilda", "Koko", "Konstance", "Konstancie", "Kordelia", "Kordula", "Kornélie", "Kristýna", "Květa",
            "Květoslava", "Kyra", "Lada", "Laetitia", "Lalita", "Lara", "Laura", "Lea", "Leila", "Lenka", "Leona", "Leontina", "Leontýna", "Lia", "Liana", "Liběna", "Libuše",
            "Lila", "Liliana", "Lilith", "Linda", "Lindsay", "Liron", "Lisa", "Liv", "Livie", "Ljuba", "Lola", "Lucie", "Ludmila", "Ludomíra", "Luna", "Lýdie", "Lyric", "Mabel",
            "Magdaléna", "Mahpíya", "Mahulena", "Maite", "Malika", "Malvína", "Marcela", "Margot", "Marguerite", "Mariana", "Marie", "Marika", "Marina", "Marion", "Markéta",
            "Marta", "Martina", "Matylda", "Maya", "Meda", "Medea", "Melanie", "Melia", "Melissa", "Mia", "Michaela", "Mijuki", "Milada", "Milagros", "Mildred", "Milena", "Miloslava",
            "Miluše", "Mína", "Miranda", "Miriam", "Miroslava", "Mischa", "Mizuki", "Moe", "Monika", "Moria", "Morwenna", "Muriel", "Naamah", "Naďa", "Naděžda", "Nami", "Natálie",
            "Nataša", "Nechama", "Nela", "Nerys", "Niamh", "Niké", "Nikita", "Nikola", "Nina", "Noemi", "Nora", "Odette", "Oldřiška", "Olga", "Olivie", "Ondřejka", "Oriana",
            "Otýlie", "Padma", "Paraskeva", "Parvati", "Patricie", "Pavla", "Pavlína", "Pax", "Penelope", "Petra", "Petronela", "Pia", "Piroska", "Pnina", "Pomněnka", "Radana",
            "Radka", "Radmila", "Radomila", "Radovana", "Ragnhild", "Ráchel", "Rebeka", "Regina", "Rena", "Renáta", "René", "Restituta", "Riana", "Rina", "Rita", "Robin", "Romana",
            "Romy", "Rosalind", "Rosamund", "Roswitha", "Roxana", "Rozálie", "Ruslana", "Rút", "Růžena", "Sabina", "Salome", "Samay", "Samia", "Samuela", "Sandra", "Saoirse", "Sára",
            "Saskie", "Selena", "Serafina", "Shirin", "Shreya", "Scholastika", "Sidonia", "Silvie", "Simcha", "Simona", "Sinéad", "Slavěna", "Slavomíra", "Sofie", "Soňa", "Stanislava",
            "Stela", "Suki", "Suri", "Svatava", "Světlana", "Světluše", "Swanhild", "Šárka", "Šarlota", "Šeherezáda", "Širi", "Štěpánka", "Šulamit", "Tabita", "Tair", "Tala", "Talula",
            "Támar", "Tamara", "Tamika", "Tara", "Taťána", "Tereza", "Thea", "Tiffany", "Tórdís", "Ulrika", "Uma", "Úna", "Uršula", "Václava", "Valentýna", "Valérie", "Vanda", "Vanesa",
            "Varvara", "Věnceslava", "Vendula", "Venuše", "Věra", "Veronika", "Vesna", "Viktorie", "Vilma", "Viola", "Vivian", "Vladěna", "Vladimíra", "Vlasta", "Vojtěška", "Vratislava",
            "Winifred", "Winona", "Xenie", "Zara", "Zdeňka", "Zdislava", "Zdravka", "Zenobia", "Zina", "Zita", "Zlata", "Zoe", "Zora", "Zuzana", "Žaneta", "Živa", "Žofie"
    };

    /**
     * The database of all man surnames.
     */
    private static String[] surnamesMen = {
            "﻿Novák", "Svoboda", "Novotný", "Dvořák", "Černý", "Procházka", "Kučera", "Veselý", "Krejčí", "Horák", "Němec",
            "Marek", "Pospíšil", "Pokorný", "Hájek", "Král", "Jelínek", "Růžička", "Beneš", "Fiala", "Sedláček", "Doležal",
            "Zeman", "Kolář", "Navrátil", "Čermák", "Vaněk", "Urban", "Blažek", "Kříž", "Kovář", "Kratochvíl", "Bartoš", "Vlček",
            "Polák", "Musil", "Kopecký", "Šimek", "Konečný", "Malý", "Holub", "Čech", "Štěpánek", "Staněk", "Kadlec", "Dostál",
            "Soukup", "Šťastný", "Mareš"
    };

    /**
     * The database of all woman surnames.
     */
    private static String[] surnamesWomen = {"﻿﻿Nováková", "Svobodová", "Novotná", "Dvořáková", "Černá", "Procházková", "Kučerová",
            "Veselá", "Horáková", "Němcová", "Marková", "Pokorná", "Pospíšilová", "Hájková", "Králová", "Jelínková", "Růžičková",
            "Benešová", "Fialová", "Sedláčková", "Doležalová", "Zemanová", "Kolářová", "Navrátilová", "Čermáková", "Vaňková", "Urbanová",
            "Kratochvílová", "Šimková", "Blažková", "Křížová", "Kopecká", "Kovářová", "Bartošová", "Vlčková", "Poláková", "Konečná", "Musilová",
            "Čechová", "Malá", "Staňková", "Štěpánková", "Holubová", "Šťastná", "Kadlecová", "Dostálová", "Soukupová", "Marešová", "Sýkorová",
            "Valentová", "Moravcová"
    };

    private static Random random = new Random();

    public static String generateManName(){
        return namesMen[random.nextInt(namesMen.length)];
    }

    public static String generateWomenName(){
        return namesWomen[random.nextInt(namesWomen.length)];
    }

    public static String generateManSurname(){
        return surnamesMen[random.nextInt(surnamesMen.length)];
    }

    public static String generateWomenSurname(){
        return surnamesWomen[random.nextInt(surnamesWomen.length)];
    }
}
