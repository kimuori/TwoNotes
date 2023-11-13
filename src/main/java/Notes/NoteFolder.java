package Notes;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

public class NoteFolder extends NoteAbstract implements Organizable {

    private String name;
    public int index;
    private ObservableList<Note> folder; // Notes and subfolders


    public NoteFolder(String name, ObservableList<Note> folder, int index) {
        this.name = name;
        this.folder = folder;
        this.index = index;
    }
    public String getName() {
        return name;
    }

    @Override
    public void setName(String Name) {

    }

    public void setName(String name, int index) {
        this.name = name;

    }

    public ObservableList<Note> getFolder() {
        return folder;
    }

    public void setFolder(ObservableList<Note> folder) {
        this.folder = folder;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static ObservableList<Note> createFolder(){
        return new ObservableList<Note>() {
            @Override
            public void addListener(ListChangeListener<? super Note> listener) {

            }

            @Override
            public void removeListener(ListChangeListener<? super Note> listener) {

            }

            @Override
            public boolean addAll(Note... elements) {
                return false;
            }

            @Override
            public boolean setAll(Note... elements) {
                return false;
            }

            @Override
            public boolean setAll(Collection<? extends Note> col) {
                return false;
            }

            @Override
            public boolean removeAll(Note... elements) {
                return false;
            }

            @Override
            public boolean retainAll(Note... elements) {
                return false;
            }

            @Override
            public void remove(int from, int to) {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Note> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Note note) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Note> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Note> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Note get(int index) {
                return null;
            }

            @Override
            public Note set(int index, Note element) {
                return null;
            }

            @Override
            public void add(int index, Note element) {

            }

            @Override
            public Note remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Note> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Note> listIterator(int index) {
                return null;
            }

            @Override
            public List<Note> subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public void addListener(InvalidationListener listener) {

            }

            @Override
            public void removeListener(InvalidationListener listener) {

            }
        };
    }
}