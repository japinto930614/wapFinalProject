import models.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VotingDbUtil {
    HashMap<String, Integer> voteStudent = new HashMap<String, Integer>();
    HashMap<String, Integer> voteStaff = new HashMap<String, Integer>();
    HashMap<String, Integer> voteFaculty = new HashMap<String, Integer>();

    public void voteStudent(String username){
        if(voteStudent.containsKey(username)){
            voteStudent.put(username, voteStudent.get(username) + 1);
        } else {
            voteStudent.put(username, 1);
        }
    }

    public void voteStaff(String username){
        if(voteStaff.containsKey(username)){
            voteStaff.put(username, voteStaff.get(username) + 1);
        } else {
            voteStaff.put(username, 1);
        }
    }

    public void voteFaculty(String username){
        if(voteFaculty.containsKey(username)){
            voteFaculty.put(username, voteFaculty.get(username) + 1);
        } else {
            voteFaculty.put(username, 1);
        }
    }

    public String getWinnerStudent(){
        return getHightestMap(voteStudent);
    }

    public String getWinnerStaff(){
        return getHightestMap(voteStaff);
    }

    public String getWinnerFaculty(){
        return getHightestMap(voteFaculty);
    }

    public String getHightestMap(Map<String, Integer> map){
        String highestMap = null;
        int highestVote = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > highestVote) {
                highestMap = entry.getKey();
                highestVote = entry.getValue();
            }
        }
        return highestMap;
    }



}
