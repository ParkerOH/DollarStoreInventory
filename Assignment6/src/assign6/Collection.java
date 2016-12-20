package assign6;

import java.util.ArrayList;

/**
 * Represents the collection of the Library.
 *
 * @author Jill Seaman
 *
 */
public class Collection  {
	
	private ArrayList<Resource> collection =
            new ArrayList<Resource>();        // list of resources
	
	/**
	 * Default constructor, creates an empty collection
	 */
	public Collection() {
	}
    
	/**
	 * Given a resource instance, adds it to the end of the collection
     * as long as its ID is not already used by another resource in the collection.
     * @param resource the item to add to the collection
	 */
	public boolean addResource(Resource resource) {
        
        //check for uniqueness of resource
        Resource res = findResource(resource.getResourceID());
        
        // if  found, return false
        if (res!=null) {
            System.out.println("Unable to add resource, resource ID not unique");
            return false;
        }
        
        else {
            collection.add(resource);
            return true;
        }
    }
    
    
    
    /**
     * Removes a resource from the collection based on the given resourceID.
     * If no resource with that id is in the collection, returns false.
     * @param resourceID the id of the resource to be removed
     */
    public boolean removeResource(int resourceID) {
        
        // find the resourceID in the collection
        Resource res = findResource(resourceID);
        
        // if found, remove it, else output message
        if (res == null) {
            System.out.println("Unable to remove resource, resource ID not found");
            return false;
        } else {
            collection.remove(res);
            return true;
        }
    }
    
    /**
     * Finds a resource in the collection based on the given resourceID.
     * If no resource with that id is in the collection, returns null.
     * @param resourceID the id of the resource to be found
     */
    public Resource findResource(int resourceID) {
        // find the resourceID in the list
        for (Resource r : collection) {
            if (r.getResourceID()==resourceID)
                return r;
        }
        return null;
    }
}