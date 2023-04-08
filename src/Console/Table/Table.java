package Console.Table;

import Console.Colors;
import DataStructure.Vector;
import DataStructure.Exceptions.VectorException;

public class Table implements Cloneable, Comparable<Table> {
    public final char line, column, header_line, header_column;
    public final Colors[] colors = new Colors[4];
    private Vector<Itens> itens;

    public Table(IColor color) throws IllegalArgumentException {
        this(new Vector<Item>(), color);
    }

    public Table(IColor color, char line, char column) throws IllegalArgumentException {
        this(new Vector<Item>(), color, line, column);
    }

    public Table(IColor color, char line, char column, char header_line, char header_column) throws IllegalArgumentException {
        this(new Vector<Item>(), color, line, column, header_line, header_column);
    }

    public Table(Vector<Item> itens, IColor color) throws IllegalArgumentException {
        this(itens, color, '│', '─');
    }

    public Table(Vector<Item> itens, IColor color, char line, char column) throws IllegalArgumentException {
        this(itens, color, line, column, line, column);
    }

    public Table(Vector<Item> itens, IColor color, char line, char column, char header_line, char header_column) throws IllegalArgumentException {
        if(itens == null)
            throw new IllegalArgumentException("Itens cannot be null");

        try { this.itens = (Vector<Itens>) itens.clone(); }
        catch (CloneNotSupportedException e) { throw new IllegalArgumentException("Error in cloning Vector<Item>"); }
        this.colors[0] = color.getPrimary();
        this.colors[1] = color.getPrimaryBackground();
        this.colors[2] = color.getSecundary();
        this.colors[3] = color.getSecundaryBackground();
        this.line = line;
        this.column = column;
        this.header_line = header_line;
        this.header_column = header_column;
    }

    public Table(Colors[] color) throws IllegalArgumentException {
        this(new Vector<Itens>(), color);
    }

    public Table(Colors[] color, char line, char column) throws IllegalArgumentException {
        this(new Vector<Itens>(), color, line, column);
    }

    public Table(Colors[] color, char line, char column, char header_line, char header_column) throws IllegalArgumentException {
        this(new Vector<Itens>(), color, line, column, header_line, header_column);
    }

    public Table(Vector<Itens> itens, Colors[] color) throws IllegalArgumentException {
        this(itens, color, '│', '─');
    }

    public Table(Vector<Itens> itens, Colors[] color, char line, char column) throws IllegalArgumentException {
        this(itens, color, line, column, line, column);
    }

    public Table(Vector<Itens> itens, Colors[] color, char line, char column, char header_line, char header_column) throws IllegalArgumentException {
        if(color.length != 4)
            throw new IllegalArgumentException("Color array must have 4 elements");
        if(itens == null)
            throw new IllegalArgumentException("Itens cannot be null");

        try { this.itens = (Vector<Itens>) itens.clone(); }
        catch (CloneNotSupportedException e) { throw new IllegalArgumentException("Error in cloning Vector<Item>"); }
        this.colors[0] = color[0];
        this.colors[1] = color[1];
        this.colors[2] = color[2];
        this.colors[3] = color[3];
        this.line = line;
        this.column = column;
        this.header_line = header_line;
        this.header_column = header_column;
    }

    public void add(Itens itens) throws VectorException {
        this.itens.push(itens);
    }

    public int columns() {
        int columns = 0;
        for (int i = 0; i < this.itens.size(); i++)
            try { columns += this.itens.get(i).columns(); }
            catch (VectorException e) { }

        return columns;
    }

    public int rows() {
        int rows = 0;
        for (int i = 0; i < this.itens.size(); i++)
            try {
                if (this.itens.get(i).rows() > rows)
                    rows = this.itens.get(i).rows();
            }
            catch (VectorException e) { }

        return rows;
    }

    public int size() { return this.itens.size(); }
    public int length() { return this.itens.length(); }
    public int area() { return this.columns() * this.rows(); }
    public int perimeter() { return (this.columns() * 2) + (this.rows() * 2); }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try { return new Table(this.itens, this.colors, this.line, this.column, this.header_line, this.header_column); }
        catch (IllegalArgumentException e) { throw new CloneNotSupportedException(e.getMessage()); }
    }

    @Override
    public int compareTo(Table obj) {
        return this.size() - obj.size();
    }

    @Override
    public String toString() {
        String table = this.colors[0] + "" + this.colors[1];

        for (int i = 0; i < this.itens.size(); i++) {
            Itens itens;
            char line = this.line;
            char column = this.column;

            try { itens = this.itens.get(i); }
            catch (VectorException e) { itens = null; }
            if(itens instanceof Header) {
                line = this.header_line;
                column = this.header_column;
            }
            
            if(i == 0) {
                table += column;
                for (int j = 0; j < itens.maxLength(); j++)
                    table += line;

                table += column+"\n";
            }

            for(int j = 0; j < itens.size(); j++) {
                table += column;
                try { table += itens.get(j).value; }
                catch (VectorException e) { }
            }

            table += column+"\n"+column;

            for (int j = 0; j < itens.maxLength(); j++)
                table += line;

            table += column+"\n";
        }

        table += Colors.RESET;

        return table;
    }
}