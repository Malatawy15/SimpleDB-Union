package simpledb.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class QueryData {
	private Collection<SelectQueryData> L = new ArrayList<SelectQueryData>();

	public QueryData(SelectQueryData d) {
		L.add(d);
	}

	public void add(QueryData qd) {
		L.addAll(qd.L);
	}

	public Collection<SelectQueryData> getAll() {
		return L;
	}

	public String toString() {
		Iterator<SelectQueryData> iter = L.iterator();
		String result = iter.next().toString();
		while (iter.hasNext())
			result += " UNION " + iter.next().toString();
		return result;
	}
}
