package it.unibo.oop.lab.collections2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
//import com.sun.tools.classfile.CharacterRangeTable_attribute.Entry;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	Map<String,Set<U>> friends = new HashMap<String,Set<U>>();
	
    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */
	

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
    }
    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	for(String s: friends.keySet()){
    		if(circle.equals(s)) {
    			Set<U> tmp = friends.get(circle);
    			if(!tmp.contains(user)) {
    				tmp.add(user);
    				return true;
    			} else {
    				return false;
    			}
    			
    		} 
    	}
    	friends.put(circle, new HashSet<U>());
    	return this.addFollowedUser(circle, user);
    		
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        for(Entry<String,Set<U>> m : friends.entrySet()) {
        	if(m.getKey().equals(groupName)) {
        		return Set.copyOf(m.getValue());
        	}
        }
        friends.put(groupName, new HashSet<U>());
        return Set.copyOf(getFollowedUsersInGroup(groupName));
    }
    @Override
    public List<U> getFollowedUsers() {
        List<U> l = new LinkedList<U>();
        for(Set<U> set: friends.values()) {
        	l.addAll(set);
        }
        return l;
    }

}
