package assign6;

import java.util.ArrayList;

/**
 * Represents a list of the members of the Library.
 *
 * @author Jill Seaman
 *
 */
public class MemberList  {
	
	private ArrayList<Member> memberList =
            new ArrayList<Member>();        // list of members
	
	/**
	 * Default constructor, creates an empty member list
	 */
	public MemberList() {
	}
    
	/**
	 * Given a member instance, validates the values and
	 * adds it to the end of the memberList.
     * @param member the person to validate and add to the memberList
	 */
	public boolean addMember(Member member) {
        
        //check for uniqueness
        Member m = findMember(member.getMemberID());
        
        // if  found, return false
        if (m!=null) {
            System.out.println("Unable to add member, member ID is not unique.");
            return false;
        }
        
        else {
            memberList.add(member);
            return true;
        }
    }
    
    
    
    /**
     * removes a member from the memberList based on the given memberID.
     * If no member with that id is in the memberList, returns false.
     * @param memberID the id of the member to be removed
     */
    public boolean removeMember(int memberID) {
        
        // find the member in the list
        Member m = findMember(memberID);
        
        // if found, remove it, else output message
        if (m==null) {
            System.out.println("Unable to remove member, member ID not found");
            return false;
        } else {
            memberList.remove(m);
            return true;
        }
    }
    
    /**
     * Finds a member in the memberList based on the given memberID.
     * If no member with that id is in the memberID, returns null.
     * @param memberID the id of the member to be found
     */
    public Member findMember(int memberID) {
        // find the resourceID in the list
        for (Member m : memberList) {
            if (m.getMemberID()==memberID)
                return m;
        }
        return null;
    }
}