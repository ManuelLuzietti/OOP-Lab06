package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	private Set<N> nodes;
	private Map<N, Set<N>> edges;
	
	public GraphImpl() {
		this.nodes = new HashSet<N>();
		this.edges = new HashMap<N,Set<N>>();
	}
	@Override
	public void addNode(N node) {
		this.nodes.add(node);
		this.edges.put(node, new HashSet<N>());
	}

	@Override
	public void addEdge(N source, N target){
		if(!this.nodes.contains(source) || !this.nodes.contains(target)) {
			throw new EdgeDoesntExistException();
		}
//		for(Entry<N, Set<N>>  s: this.edges.entrySet()) {
//			if(s.getKey().equals(source)) {
//				s.getValue().add(target);
//			}
//		}
		if(this.edges.containsKey(source)) {
			this.edges.get(source).add(target);
		}
	}

	@Override
	public Set<N> nodeSet() {
		return Set.copyOf(this.nodes);
	}

	@Override
	public Set<N> linkedNodes(N node) {
		if(this.edges.containsKey(node)) {
			return Set.copyOf(this.edges.get(node));
		} else {
			return new HashSet<N>();
		}
	}

	@Override
	public List<N> getPath(N source, N target) {
		
	}

}
