package by.zvv.javaonline.part04.simpleclass.task09.entity;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> library;

	public Library() {
		library = new ArrayList<>();
	}

	public void addBook(Book book) {
		library.add(book);
	}

	public ArrayList<Book> getLibrary() {
		return library;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((library == null) ? 0 : library.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (library == null) {
			if (other.library != null)
				return false;
		} else if (!library.equals(other.library))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [library=" + library + "]";
	}

}
