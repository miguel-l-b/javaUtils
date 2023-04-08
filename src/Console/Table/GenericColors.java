package Console.Table;

import Console.Colors;

public enum GenericColors implements IColor {
    Light(Colors.WHITE, Colors.BLACK, Colors.WHITE, Colors.BLACK),
    Dark(Colors.BLACK, Colors.WHITE, Colors.BLACK, Colors.WHITE),
    Blue(Colors.BLUE, Colors.WHITE, Colors.BLUE, Colors.WHITE),
    Green(Colors.GREEN, Colors.WHITE, Colors.GREEN, Colors.WHITE),
    Red(Colors.RED, Colors.WHITE, Colors.RED, Colors.WHITE),
    Yellow(Colors.YELLOW, Colors.WHITE, Colors.YELLOW, Colors.WHITE),
    Cyan(Colors.CYAN, Colors.WHITE, Colors.CYAN, Colors.WHITE),
    Magenta(Colors.MAGENTA, Colors.WHITE, Colors.MAGENTA, Colors.WHITE);

    public final Colors primary, primaryBackground, secundary, secundaryBackground;

    private GenericColors(Colors primary, Colors primaryBackground, Colors secundary, Colors secundaryBackground) {
        this.primary = primary;
        this.primaryBackground = primaryBackground;
        this.secundary = secundary;
        this.secundaryBackground = secundaryBackground;
    }

    @Override
    public Colors getPrimary() { return this.primary; }

    @Override
    public Colors getPrimaryBackground() { return this.primaryBackground; }

    @Override
    public Colors getSecundary() { return this.secundary; }

    @Override
    public Colors getSecundaryBackground() { return this.secundaryBackground; }
}
