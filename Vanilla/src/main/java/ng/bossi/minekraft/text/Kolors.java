package ng.bossi.minekraft.text;

import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Kolors {

    // Decorations
    public static final TextDecoration MAGIC = TextDecoration.OBFUSCATED;
    public static final TextDecoration BOLD = TextDecoration.BOLD;
    public static final TextDecoration STRIKETHROUGH = TextDecoration.STRIKETHROUGH;
    public static final TextDecoration UNDERLINE = TextDecoration.UNDERLINED;
    public static final TextDecoration ITALIC = TextDecoration.ITALIC;


    // Bukkit Colors
    public static final TextColor DARKBLUE = TextColor.color(0, 0, 170);
    public static final TextColor DARKGREEN = TextColor.color(0, 170, 0);
    public static final TextColor DARKAQUA = TextColor.color(0, 170, 170);
    public static final TextColor DARKRED = TextColor.color(170, 0, 0);
    public static final TextColor DARKPURPLE = TextColor.color(170, 0, 170);
    public static final TextColor GOLD = TextColor.color(255, 170, 0);
    public static final TextColor GRAY = TextColor.color(170, 170, 170);
    public static final TextColor DARKGRAY = TextColor.color(85, 85, 85);
    public static final TextColor BLUE = TextColor.color(85, 85, 255);
    public static final TextColor GREEN = TextColor.color(85, 255, 85);
    public static final TextColor AQUA = TextColor.color(85, 255, 255);
    public static final TextColor RED = TextColor.color(255, 85, 85);
    public static final TextColor LIGHTPURPLE = TextColor.color(255, 85, 255);
    public static final TextColor YELLOW = TextColor.color(255, 255, 85);
    public static final TextColor WHITE = TextColor.color(255, 255, 255);

    // Additional Colors
    public static final TextColor ALICEBLUE = TextColor.color(240, 248, 255);
    public static final TextColor ANTIQUEWHITE = TextColor.color(250, 235, 215);
    public static final TextColor AQUAMARINE = TextColor.color(127, 255, 212);
    public static final TextColor AZURE = TextColor.color(240, 255, 255);
    public static final TextColor BEIGE = TextColor.color(245, 245, 220);
    public static final TextColor BISQUE = TextColor.color(255, 228, 196);
    public static final TextColor BLACK = TextColor.color(0, 0, 0);
    public static final TextColor BLANCHEDALMOND = TextColor.color(255, 235, 205);
    public static final TextColor BLUEVIOLET = TextColor.color(138, 43, 226);
    public static final TextColor BROWN = TextColor.color(165, 42, 42);
    public static final TextColor BURLYWOOD = TextColor.color(222, 184, 135);
    public static final TextColor CADETBLUE = TextColor.color(95, 158, 160);
    public static final TextColor CHARTREUSE = TextColor.color(127, 255, 0);
    public static final TextColor CHOCOLATE = TextColor.color(210, 105, 30);
    public static final TextColor CORAL = TextColor.color(255, 127, 80);
    public static final TextColor CORNFLOWERBLUE = TextColor.color(100, 149, 237);
    public static final TextColor CORNSILK = TextColor.color(255, 248, 220);
    public static final TextColor CRIMSON = TextColor.color(220, 20, 60);
    public static final TextColor CYAN = TextColor.color(0, 255, 255);
    public static final TextColor DARKCYAN = TextColor.color(0, 139, 139);
    public static final TextColor DARKGOLDENROD = TextColor.color(184, 134, 11);
    public static final TextColor DARKKHAKI = TextColor.color(189, 183, 107);
    public static final TextColor DARKMAGENTA = TextColor.color(139, 0, 139);
    public static final TextColor DARKOLIVEGREEN = TextColor.color(85, 107, 47);
    public static final TextColor DARKORANGE = TextColor.color(255, 140, 0);
    public static final TextColor DARKORCHID = TextColor.color(153, 50, 204);
    public static final TextColor DARKSALMON = TextColor.color(233, 150, 122);
    public static final TextColor DARKSEAGREEN = TextColor.color(143, 188, 143);
    public static final TextColor DARKSLATEBLUE = TextColor.color(72, 61, 139);
    public static final TextColor DARKSLATEGRAY = TextColor.color(47, 79, 79);
    public static final TextColor DARKTURQUOISE = TextColor.color(0, 206, 209);
    public static final TextColor DARKVIOLET = TextColor.color(148, 0, 211);
    public static final TextColor DEEPPINK = TextColor.color(255, 20, 147);
    public static final TextColor DEEPSKYBLUE = TextColor.color(0, 191, 255);
    public static final TextColor DIMGRAY = TextColor.color(105, 105, 105);
    public static final TextColor DODGERBLUE = TextColor.color(30, 144, 255);
    public static final TextColor FIREBRICK = TextColor.color(178, 34, 34);
    public static final TextColor FLORALWHITE = TextColor.color(255, 250, 240);
    public static final TextColor FORESTGREEN = TextColor.color(34, 139, 34);
    public static final TextColor FUCHSIA = TextColor.color(255, 0, 255);
    public static final TextColor GAINSBORO = TextColor.color(220, 220, 220);
    public static final TextColor GHOSTWHITE = TextColor.color(248, 248, 255);
    public static final TextColor GOLDENROD = TextColor.color(218, 165, 32);
    public static final TextColor GREENYELLOW = TextColor.color(173, 255, 47);
    public static final TextColor HONEYDEW = TextColor.color(240, 255, 240);
    public static final TextColor HOTPINK = TextColor.color(255, 105, 180);
    public static final TextColor INDIANRED = TextColor.color(205, 92, 92);
    public static final TextColor INDIGO = TextColor.color(75, 0, 130);
    public static final TextColor IVORY = TextColor.color(255, 255, 240);
    public static final TextColor KHAKI = TextColor.color(240, 230, 140);
    public static final TextColor LAVENDER = TextColor.color(230, 230, 250);
    public static final TextColor LAVENDERBLUSH = TextColor.color(255, 240, 245);
    public static final TextColor LAWNGREEN = TextColor.color(124, 252, 0);
    public static final TextColor LEMONCHIFFON = TextColor.color(255, 250, 205);
    public static final TextColor LIGHTBLUE = TextColor.color(173, 216, 230);
    public static final TextColor LIGHTCORAL = TextColor.color(240, 128, 128);
    public static final TextColor LIGHTCYAN = TextColor.color(224, 255, 255);
    public static final TextColor LIGHTGOLDENRODYELLOW = TextColor.color(250, 250, 210);
    public static final TextColor LIGHTGRAY = TextColor.color(211, 211, 211);
    public static final TextColor LIGHTGREEN = TextColor.color(144, 238, 144);
    public static final TextColor LIGHTPINK = TextColor.color(255, 182, 193);
    public static final TextColor LIGHTSALMON = TextColor.color(255, 160, 122);
    public static final TextColor LIGHTSEAGREEN = TextColor.color(32, 178, 170);
    public static final TextColor LIGHTSKYBLUE = TextColor.color(135, 206, 250);
    public static final TextColor LIGHTSLATEGRAY = TextColor.color(119, 136, 153);
    public static final TextColor LIGHTSTEELBLUE = TextColor.color(176, 196, 222);
    public static final TextColor LIGHTYELLOW = TextColor.color(255, 255, 224);
    public static final TextColor LIME = TextColor.color(0, 255, 0);
    public static final TextColor LIMEGREEN = TextColor.color(50, 205, 50);
    public static final TextColor LINEN = TextColor.color(250, 240, 230);
    public static final TextColor MAGENTA = TextColor.color(255, 0, 255);
    public static final TextColor MAROON = TextColor.color(128, 0, 0);
    public static final TextColor MEDIUMAQUAMARINE = TextColor.color(102, 205, 170);
    public static final TextColor MEDIUMBLUE = TextColor.color(0, 0, 205);
    public static final TextColor MEDIUMORCHID = TextColor.color(186, 85, 211);
    public static final TextColor MEDIUMPURPLE = TextColor.color(147, 112, 219);
    public static final TextColor MEDIUMSEAGREEN = TextColor.color(60, 179, 113);
    public static final TextColor MEDIUMSLATEBLUE = TextColor.color(123, 104, 238);
    public static final TextColor MEDIUMSPRINGGREEN = TextColor.color(0, 250, 154);
    public static final TextColor MEDIUMTURQUOISE = TextColor.color(72, 209, 204);
    public static final TextColor MEDIUMVIOLETRED = TextColor.color(199, 21, 133);
    public static final TextColor MIDNIGHTBLUE = TextColor.color(25, 25, 112);
    public static final TextColor MINTCREAM = TextColor.color(245, 255, 250);
    public static final TextColor MISTYROSE = TextColor.color(255, 228, 225);
    public static final TextColor MOCCASIN = TextColor.color(255, 228, 181);
    public static final TextColor NAVAJOWHITE = TextColor.color(255, 222, 173);
    public static final TextColor NAVY = TextColor.color(0, 0, 128);
    public static final TextColor OLDLACE = TextColor.color(253, 245, 230);
    public static final TextColor OLIVE = TextColor.color(128, 128, 0);
    public static final TextColor OLIVEDRAB = TextColor.color(107, 142, 35);
    public static final TextColor ORANGE = TextColor.color(255, 165, 0);
    public static final TextColor ORANGERED = TextColor.color(255, 69, 0);
    public static final TextColor ORCHID = TextColor.color(218, 112, 214);
    public static final TextColor PALEGOLDENROD = TextColor.color(238, 232, 170);
    public static final TextColor PALEGREEN = TextColor.color(152, 251, 152);
    public static final TextColor PALETURQUOISE = TextColor.color(175, 238, 238);
    public static final TextColor PALEVIOLETRED = TextColor.color(219, 112, 147);
    public static final TextColor PAPAYAWHIP = TextColor.color(255, 239, 213);
    public static final TextColor PEACHPUFF = TextColor.color(255, 218, 185);
    public static final TextColor PERU = TextColor.color(205, 133, 63);
    public static final TextColor PINK = TextColor.color(255, 192, 203);
    public static final TextColor PLUM = TextColor.color(221, 160, 221);
    public static final TextColor POWDERBLUE = TextColor.color(176, 224, 230);
    public static final TextColor PURPLE = TextColor.color(128, 0, 128);
    public static final TextColor ROSYBROWN = TextColor.color(188, 143, 143);
    public static final TextColor ROYALBLUE = TextColor.color(65, 105, 225);
    public static final TextColor SADDLEBROWN = TextColor.color(139, 69, 19);
    public static final TextColor SALMON = TextColor.color(250, 128, 114);
    public static final TextColor SANDYBROWN = TextColor.color(244, 164, 96);
    public static final TextColor SEAGREEN = TextColor.color(46, 139, 87);
    public static final TextColor SEASHELL = TextColor.color(255, 245, 238);
    public static final TextColor SIENNA = TextColor.color(160, 82, 45);
    public static final TextColor SILVER = TextColor.color(192, 192, 192);
    public static final TextColor SKYBLUE = TextColor.color(135, 206, 235);
    public static final TextColor SLATEBLUE = TextColor.color(106, 90, 205);
    public static final TextColor SLATEGRAY = TextColor.color(112, 128, 144);
    public static final TextColor SNOW = TextColor.color(255, 250, 250);
    public static final TextColor SPRINGGREEN = TextColor.color(0, 255, 127);
    public static final TextColor STEELBLUE = TextColor.color(70, 130, 180);
    public static final TextColor TAN = TextColor.color(210, 180, 140);
    public static final TextColor TEAL = TextColor.color(0, 128, 128);
    public static final TextColor THISTLE = TextColor.color(216, 191, 216);
    public static final TextColor TOMATO = TextColor.color(255, 99, 71);
    public static final TextColor TURQUOISE = TextColor.color(64, 224, 208);
    public static final TextColor VIOLET = TextColor.color(238, 130, 238);
    public static final TextColor WHEAT = TextColor.color(245, 222, 179);
    public static final TextColor WHITESMOKE = TextColor.color(245, 245, 245);
    public static final TextColor YELLOWGREEN = TextColor.color(154, 205, 50);
    public static final TextColor POISONGREEN = TextColor.color(0, 247, 0);
    public static final TextColor ALMOND = TextColor.color(239, 222, 205);
    public static final TextColor AMARANTH = TextColor.color(229, 43, 80);
    public static final TextColor AMARANTHDEEPPURPLE = TextColor.color(159, 43, 104);
    public static final TextColor AMARANTHPURPLE = TextColor.color(171, 39, 79);
    public static final TextColor ANTIQUERUBY = TextColor.color(132, 27, 45);
    public static final TextColor ANTIQUEFUCHSIA = TextColor.color(145, 92, 131);
    public static final TextColor AMETHYST = TextColor.color(153, 102, 204);
    public static final TextColor BABYBLUE = TextColor.color(137, 207, 240);
    public static final TextColor BABYPINK = TextColor.color(244, 194, 194);
    public static final TextColor BLACKBEAN = TextColor.color(61, 12, 2);
    public static final TextColor BLOODRED = TextColor.color(102, 0, 0);
    public static final TextColor BONE = TextColor.color(227, 218, 201);
    public static final TextColor BRONZE = TextColor.color(205, 127, 50);
    public static final TextColor CARDINAL = TextColor.color(196, 30, 58);
    public static final TextColor CHERRYBLOSSOMPINK = TextColor.color(255, 183, 197);
    public static final TextColor CHILLIRED = TextColor.color(226, 61, 40);
    public static final TextColor CHINAPINK = TextColor.color(222, 111, 161);
    public static final TextColor COPPER = TextColor.color(184, 115, 51);
    public static final TextColor COTTONCANDY = TextColor.color(255, 188, 217);
    public static final TextColor CREAM = TextColor.color(255, 253, 208);
    public static final TextColor EGGSHELL = TextColor.color(240, 234, 214);
    public static final TextColor EGGPLANT = TextColor.color(97, 64, 81);
    public static final TextColor EMERALD = TextColor.color(80, 200, 120);
    public static final TextColor FRENCHBEIGE = TextColor.color(166, 123, 91);
    public static final TextColor FUZZYWUZZY = TextColor.color(204, 102, 102);
    public static final TextColor KOBI = TextColor.color(231, 159, 196);
    public static final TextColor LAVA = TextColor.color(207, 16, 32);
    public static final TextColor MAHOGANY = TextColor.color(192, 64, 0);
    public static final TextColor MANGO = TextColor.color(253, 190, 2);
    public static final TextColor MANGOTANGO = TextColor.color(255, 130, 67);
    public static final TextColor MAXIMUMBLUE = TextColor.color(71, 171, 204);
    public static final TextColor MAXIMUMGREEN = TextColor.color(94, 140, 49);
    public static final TextColor MAXIMUMRED = TextColor.color(217, 33, 33);
    public static final TextColor MAXIMUMPURPLE = TextColor.color(115, 51, 128);
    public static final TextColor MAXIMUMYELLOW = TextColor.color(250, 250, 55);
    public static final TextColor MINTGREEN = TextColor.color(152, 255, 152);
    public static final TextColor OCHRE = TextColor.color(204, 119, 34);
    public static final TextColor OXBLOOD = TextColor.color(128, 0, 32);
    public static final TextColor OXFORDBLUE = TextColor.color(0, 33, 71);
    public static final TextColor PEACH = TextColor.color(255, 229, 180);
    public static final TextColor RICHBLACK = TextColor.color(1, 11, 19);
    public static final TextColor ROYALPURPLE = TextColor.color(120, 81, 169);
    public static final TextColor RUBY = TextColor.color(224, 17, 95);
    public static final TextColor STRAWBERRY = TextColor.color(252, 90, 141);
    public static final TextColor SUNGLOW = TextColor.color(255, 204, 51);
    public static final TextColor SUNSET = TextColor.color(250, 214, 165);
    public static final TextColor TEAGREEN = TextColor.color(208, 240, 192);
    public static final TextColor UNBLEACHEDSILK = TextColor.color(255, 221, 202);
    public static final TextColor UNBLUE = TextColor.color(91, 146, 229);
    public static final TextColor VANILLA = TextColor.color(243, 229, 171);
    public static final TextColor WINE = TextColor.color(114, 47, 55);


    /**
     * Returns all [TextColor]s in this Class
     * @return a List of all Colors in this Class
     */
    public static List<TextColor> allColors() {
        return Arrays.stream(Kolors.class.getFields())
                .filter(field -> field.getType() == TextColor.class)
                .map(field -> {
                    try {
                        return (TextColor) field.get(null);
                    } catch (IllegalArgumentException | IllegalAccessException ignored) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Returns all [TextDecoration]s in this class
     * @return a list of all Decorations in this class
     */
    public static List<TextDecoration> allDecorations() {
        return Arrays.stream(Kolors.class.getFields())
                .filter(field -> field.getType() == TextDecoration.class)
                .map(field -> {
                    try {
                        return (TextDecoration) field.get(null);
                    } catch (IllegalArgumentException | IllegalAccessException ignored) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
