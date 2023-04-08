package Console.Table;

public class Item implements Cloneable, Comparable<Item> {
    public final String value;
    public final int rows, columns;

    public Item(String value) throws IllegalArgumentException {
        this(value, 1, 1);
    }

    public Item(String value, int rows) throws IllegalArgumentException {
        this(value, rows, 1);
    }


    public Item(String value, int rows, int columns) throws IllegalArgumentException {
        if (rows < 1 || columns < 1)
            throw new IllegalArgumentException("Rows and columns must be greater than 0");
        if(value == null)
            throw new IllegalArgumentException("Value cannot be null");

        this.value = value;
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try { return new Item(this.value, this.rows, this.columns); }
        catch (IllegalArgumentException e) { throw new CloneNotSupportedException(e.getMessage()); }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        
        if(!(obj instanceof Item)) return false;

        if(!this.value.equals(((Item) obj).value)) return false;
        if(this.rows != ((Item) obj).rows) return false;
        if(this.columns != ((Item) obj).columns) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;

        hash = hash * 3 + this.value.hashCode();
        hash = hash * 5 + Integer.valueOf(this.rows).hashCode();
        hash = hash * 7 + Integer.valueOf(this.columns).hashCode();

        if(hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        return String.format("Item[%d, %d, %s]", this.rows, this.columns, this.value);
    }

    @Override
    public int compareTo(Item o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
