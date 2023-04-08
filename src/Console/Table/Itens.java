package Console.Table;

import DataStructure.Vector;
import DataStructure.Exceptions.VectorException;

public class Itens implements Cloneable, Comparable<Itens> {
    private Vector<Item> array;

    public Itens() {
        this(new Vector<Item>());
    }
    public Itens(Vector<Item> array) throws IllegalArgumentException {
        if(array == null)
            throw new IllegalArgumentException("Array cannot be null");

        this.array = array;
    }

    public void add(Item item) throws VectorException {
        this.array.push(item);
    }

    public void add(String value, int rows) throws IllegalArgumentException, VectorException {
        this.add(new Item(value, rows));
    }

    public void add(String value, int rows, int columns) throws IllegalArgumentException, VectorException {
        this.add(new Item(value, rows, columns));
    }

    public Item get(int index) throws VectorException {
        return this.array.get(index);
    }

    public int size() {
        return this.array.size();
    }

    public int maxLength() {
        int max = 0;
        for (int i = 0; i < array.size(); i++) {
            try {
                if(array.get(i).value.length() > max)
                    max = array.get(i).value.length();
            }
            catch (VectorException e) { }
        }

        return max;
    }

    public int rows() {
        int rows = 0;
        for (int i = 0; i < this.size(); i++)
            try {
                if (this.get(i).rows > rows)
                    rows = this.get(i).rows;
            }
            catch (VectorException e) { }

        return rows;
    }

    public int columns() {
        int columns = 0;
        for (int i = 0; i < this.size(); i++)
            try { columns += this.get(i).columns; }
            catch (VectorException e) { }

        return columns;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Itens((Vector<Item>) this.array.clone());
    }

    @Override
    public int compareTo(Itens itens) {
        return this.size() - itens.size();
    }

    @Override
    public String toString() {
        return this.array.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        
        if(!(obj instanceof Itens)) return false;

        if(!this.array.equals(((Itens) obj).array)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 23;

        hash = hash * 3 + this.array.hashCode();

        if(hash < 0) hash *= -1;

        return hash;
    }
}
